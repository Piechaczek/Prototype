package com.example.droolsprototype.demo;

import org.foobar.library.model.Metric;
import com.example.droolsprototype.model.QueryInfo;
import org.foobar.library.model.promql.QueryResult;
import com.example.droolsprototype.execution.ExecutionService;
import com.example.droolsprototype.query.PrometheusQueryService;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.TimerTask;

/**
 * Demo performing queries and firing mock rule engine rules
 */
@Component
public class DemoTask extends TimerTask {

    private final PrometheusQueryService queryService;
    private final KieSession kieSession;
    private final ExecutionService executionService;

    private QueryInfo toQuery;
    private final StringBuilder logBuilder;

    public DemoTask(PrometheusQueryService queryService, KieSession kieSession, ExecutionService executionService) {
        this.queryService = queryService;
        this.kieSession = kieSession;
        this.executionService = executionService;

        this.toQuery = new QueryInfo("request_duration_seconds_sum");

        this.logBuilder = new StringBuilder();
    }

    @Override
    public void run() {
        QueryInfo toQuery = this.toQuery; //makes a local copy (so that it's immutable from the outside)
        //sending requests for metrics
        for (String query : toQuery.getQueries()) {
            try {
                QueryResult queryResult = queryService.queryMetric(query);
                logBuilder.append(query).append("\n"); //log query
                Metric metric = new Metric(queryResult);

                //debug
                System.out.println(metric);

                //give control of these objects to the drools engine
                kieSession.insert(metric);
            } catch (Exception e){
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                logBuilder.append(sw).append("\n");
                e.printStackTrace();
            }

        }
        //give control of executor
        kieSession.insert(executionService);

        //tell drools to evaluate all rules
        System.out.println("Running drools...");
        kieSession.fireAllRules();
    }

    public void setToQuery(QueryInfo toQuery) {
        this.toQuery = toQuery;
    }

    public QueryInfo getToQuery(){
        return toQuery;
    }

    public String getQueryLogs(){
        return logBuilder.toString();
    }

}
