package com.example.droolsprototype.model.promql;

import java.util.Arrays;
import java.util.Map;

/**
 * POJO for JSON conversion
 */
public class Result {

    private Map<String, String> metric;
    private String[] value;

    public Map<String, String> getMetric() {
        return metric;
    }

    public void setMetric(Map<String, String> metric) {
        this.metric = metric;
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Result{" +
                "metric=" + metric +
                ", value=" + Arrays.toString(value) +
                '}';
    }
}
