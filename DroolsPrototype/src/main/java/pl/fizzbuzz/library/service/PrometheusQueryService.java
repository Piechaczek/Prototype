package pl.fizzbuzz.library.service;

import org.foobar.library.model.Metric;
import org.foobar.library.model.promql.QueryResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Service for making GET requests to the Prometheus service
 * The prometheus URL is provided as a commandline argument of the form --prometheus="..."
 */
@Service
public class PrometheusQueryService {

    private final RestTemplate restTemplate;

    private final String queryTemplate;
    private QueryList queryList;

    private final StringBuilder logBuilder;

    public PrometheusQueryService(RestTemplateBuilder restTemplateBuilder, @Value("${prometheus:}") String prometheusUrl) {
        this.queryTemplate = prometheusUrl + "/api/v1/query?query={some_query}";
        this.restTemplate = restTemplateBuilder.build();
        this.logBuilder = new StringBuilder();
    }

    public Metric queryMetric(String query) {
        logBuilder.append(query).append("\n");
        QueryResult result = this.restTemplate.getForObject(queryTemplate, QueryResult.class, query);
        if (result == null) return null;
        return new Metric(result);
    }

    public List<Metric> queryList(QueryList queries) {
        if (queries == null) return List.of();
        return queries.getQueries()
                .parallelStream()
                .map(this::queryMetric)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<Metric> queryAll(){
        return queryList(this.queryList);
    }

    public QueryList getQueryList() {
        return queryList;
    }

    void setQueryList(QueryList queryList){
        this.queryList = queryList;
    }

    public String getLogs(){
        return this.logBuilder.toString();
    }


}
