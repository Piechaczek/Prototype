package com.example.droolsprototype.query;

import com.example.droolsprototype.model.QueryResult;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Service for making GET requests to the Prometheus service
 * note: in this example the Prometheus url is hardcoded, change it to the url returned by:
 *     minikube service prometheus --namespace="monitoring" --url
 */
@Service
public class PrometheusQueryService {

    private final RestTemplate restTemplate;

    private static final String PROMETHEUS_URL ="http://prometheus.monitoring.svc.cluster.local:9090";


    public PrometheusQueryService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public QueryResult queryMetric(String query) {
        String url = PROMETHEUS_URL + "/api/v1/query?query=\"{some_query}\"";
        return this.restTemplate.getForObject(url, QueryResult.class, query);
    }


}
