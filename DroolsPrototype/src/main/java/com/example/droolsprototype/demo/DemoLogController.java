package com.example.droolsprototype.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoLogController {

    private final DemoTask demoTask;

    public DemoLogController(DemoTask demoTask) {
        this.demoTask = demoTask;
    }

    @GetMapping("/query/log")
    @ResponseBody
    public String getLogEndpoint(){
        return demoTask.getQueryLogs();
    }

    @GetMapping("/query/list")
    @ResponseBody
    public String getListEndpoint(){
        return String.join("\n", demoTask.getToQuery().getQueries());
    }

}
