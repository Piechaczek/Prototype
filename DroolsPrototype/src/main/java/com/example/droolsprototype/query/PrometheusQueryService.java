package com.example.droolsprototype.query;

import org.foobar.library.model.promql.QueryResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service for making GET requests to the Prometheus service
 * The prometheus URL is provided as a commandline argument of the form --prometheus="..."
 */
@Service
public class PrometheusQueryService {

    private final RestTemplate restTemplate;

    private static String PROMETHEUS_URL;

    public PrometheusQueryService(RestTemplateBuilder restTemplateBuilder, @Value("${prometheus:}") String prometheusUrl) {
        PrometheusQueryService.PROMETHEUS_URL = prometheusUrl;
        this.restTemplate = restTemplateBuilder.build();
    }

    public QueryResult queryMetric(String query) {
        String url = PROMETHEUS_URL + "/api/v1/query?query={some_query}";
        return this.restTemplate.getForObject(url, QueryResult.class, query);
    }


}
