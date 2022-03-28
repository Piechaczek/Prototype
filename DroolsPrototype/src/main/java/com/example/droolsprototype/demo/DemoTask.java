package com.example.droolsprototype.demo;

import com.example.droolsprototype.execution.ExecutionService;
import org.foobar.library.model.Metric;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.fizzbuzz.library.service.PrometheusQueryService;

import java.util.List;
import java.util.TimerTask;

/**
 * Demo performing queries and firing mock rule engine rules
 */
@Component
public class DemoTask extends TimerTask {

    private final PrometheusQueryService queryService;
    private final KieSession kieSession;
    private final ExecutionService executionService;

    @Autowired
    public DemoTask(PrometheusQueryService queryService, KieSession kieSession, ExecutionService executionService) {
        this.queryService = queryService;
        this.kieSession = kieSession;
        this.executionService = executionService;
    }

    @Override
    public void run() {
        try {
            //sending requests for metrics
            List<Metric> metrics = queryService.queryAll();
            for (Metric metric : metrics) {
                //debug
                System.out.println(metric);

                //give control of these objects to the drools engine
                kieSession.insert(metric);
            }
        } catch (Exception e){
            e.printStackTrace(); // TODO better error handling inside the library
        }

        //give control of executor
        kieSession.insert(executionService);

        //tell drools to evaluate all rules
        System.out.println("Running drools...");
        kieSession.fireAllRules();
    }

}
