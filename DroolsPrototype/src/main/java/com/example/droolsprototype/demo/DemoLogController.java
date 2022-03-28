package com.example.droolsprototype.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.fizzbuzz.library.service.PrometheusQueryService;

/**
 * Rest controller tasked with exposing endpoints with log information
 */
@RestController
public class DemoLogController {

    private final PrometheusQueryService queryService;

    public DemoLogController(PrometheusQueryService queryService) {
        this.queryService = queryService;
    }

    @GetMapping("/query/log")
    @ResponseBody
    public String getLogEndpoint(){
        return queryService.getLogs();
    }

    @GetMapping("/query/list")
    @ResponseBody
    public String getListEndpoint(){
        return String.join("\n",  queryService.getQueryList().getQueries());
    }

}
