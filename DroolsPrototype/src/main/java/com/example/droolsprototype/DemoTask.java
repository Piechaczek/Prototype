package com.example.droolsprototype;

import com.example.droolsprototype.model.Metric;
import com.example.droolsprototype.model.QueryResult;
import com.example.droolsprototype.execution.ExecutionService;
import com.example.droolsprototype.query.PrometheusQueryService;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Component;

import java.util.TimerTask;

@Component
public class DemoTask extends TimerTask {

    private final PrometheusQueryService queryService;
    private final KieSession kieSession;
    private final ExecutionService executionService;

    public DemoTask(PrometheusQueryService queryService, KieSession kieSession, ExecutionService executionService) {
        this.queryService = queryService;
        this.kieSession = kieSession;
        this.executionService = executionService;
    }

    @Override
    public void run() {
        //sending request for one metric
        //query has to look like this: request_duration_seconds_sum{service=\"front-end\"}
        //this means we need to escape both the \ and the " giving us: \\\"
        QueryResult queryResult = queryService.queryMetric("request_duration_seconds_sum{service=\\\"front-end\\\"}");
        Metric metric = new Metric("request_duration_seconds_sum", "front-end", queryResult);

        //debug
        System.out.println(metric);

        //give control of these objects to the drools engine
        kieSession.insert(metric);
        kieSession.insert(executionService);

        //tell drools to evaluate all rules
        System.out.println("Running drools...");
        kieSession.fireAllRules();
    }

}
