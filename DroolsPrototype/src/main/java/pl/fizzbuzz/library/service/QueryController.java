package pl.fizzbuzz.library.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides an endpoint for posting queries to be executed as part of the demo
 */
@RestController
public class QueryController {

    private final PrometheusQueryService queryService;

    public QueryController(PrometheusQueryService queryService) {
        this.queryService = queryService;
    }

    @PostMapping("/queries")
    public ResponseEntity<Object> postQueriesEndpoint(@RequestBody QueryList queryList){
        queryService.setQueryList(queryList);
        return ResponseEntity.ok().build(); //returns 200 OK
    }

}
