package org.foobar.library.model.promql;

import java.io.Serializable;
import java.util.Arrays;

/**
 * POJO for JSON conversion
 */
public class Data implements Serializable {

    private String resultType;
    private Result[] result;

    public Data() {
        //required by Jackson
    }

    public Data(String resultType, Result[] result) {
        this.resultType = resultType;
        this.result = result;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public Result[] getResult() {
        return result;
    }

    public void setResult(Result[] result) {
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
