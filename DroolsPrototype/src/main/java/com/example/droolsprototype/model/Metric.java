package com.example.droolsprototype.model;

import com.example.droolsprototype.model.promql.QueryResult;

/**
 * Class which transforms the JSON query result converted to a Java object
 * into a more user-friendly format
 * For now it assumes teh query resulted in just one metric
 * HIGHLY temporary, we need to design this class hierarchy from scratch
 */
public class Metric {

    private final String name;
    private final String valueString;
    private final double valueDouble;
    private final double timestamp;
    private final QueryResult queryResult;

    public Metric(QueryResult queryResult) {
        this.queryResult = queryResult;
        this.name = queryResult.getData().getResult()[0].getMetric().get("__name__");
        this.timestamp = Double.parseDouble(queryResult.getData().getResult()[0].getValue()[0]);
        this.valueString = queryResult.getData().getResult()[0].getValue()[1];
        double valueDouble;
        try {
            valueDouble = Double.parseDouble(valueString);
        } catch (NumberFormatException e){
            valueDouble = Double.NaN;
        }
        this.valueDouble = valueDouble;
    }

    public String getName() {
        return name;
    }

    public String getValueString() {
        return valueString;
    }

    public double getValueDouble() {
        return valueDouble;
    }

    public QueryResult getQueryResult() {
        return queryResult;
    }

    public double getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Metric{" +
                "name='" + name + '\'' +
                ", valueString='" + valueString + '\'' +
                ", valueDouble=" + valueDouble +
                ", timestamp=" + timestamp +
                ", queryResult=" + queryResult +
                '}';
    }

}
