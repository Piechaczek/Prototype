package com.example.droolsprototype.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * POJO for JSON conversion
 */
public class Data implements Serializable {

    private String resultType;
    private String[] result;

    public Data() {
        //required by Jackson
    }

    public Data(String resultType, String[] result) {
        this.resultType = resultType;
        this.result = result;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String[] getResult() {
        return result;
    }

    public void setResult(String[] result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Data{" +
                "resultType='" + resultType + '\'' +
                ", result='" + Arrays.toString(result) + '\'' +
                '}';
    }

}
