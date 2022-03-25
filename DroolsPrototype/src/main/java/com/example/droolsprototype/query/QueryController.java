package com.example.droolsprototype.query;

import com.example.droolsprototype.demo.DemoTask;
import com.example.droolsprototype.model.QueryInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {

    private final DemoTask demoTask;

    public QueryController(DemoTask demoTask) {
        this.demoTask = demoTask;
    }

    @PostMapping("/queries")
    public ResponseEntity<Object> postQueriesEndpoint(@RequestBody QueryInfo queryInfo){
        demoTask.setToQuery(queryInfo);
        return ResponseEntity.ok().build(); //returns 200 OK
    }

}
