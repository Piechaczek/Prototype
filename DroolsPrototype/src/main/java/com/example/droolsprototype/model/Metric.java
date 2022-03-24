package com.example.droolsprototype.model;

/**
 * Class which combines the JSON query result converted to a Java object
 * with info about the query (metric name, targeted service etc)
 * HIGHLY temporary, we need to design this class hierarchy from scratch
 */
public class Metric {

    private final String name;
    private final String service;
    private final QueryResult queryResult;

    public Metric(String name, String service, QueryResult queryResult) {
        this.name = name;
        this.service = service;
        this.queryResult = queryResult;
    }

    public String getName() {
        return name;
    }

    public String getService() {
        return service;
    }

    public QueryResult getQueryResult() {
        return queryResult;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "name='" + name + '\'' +
                ", service='" + service + '\'' +
                ", queryResult=" + queryResult +
                '}';
    }
}
