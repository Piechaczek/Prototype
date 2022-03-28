package org.foobar.library.model.promql;

import java.io.Serializable;

/**
 * POJO for JSON conversion
 */
public class QueryResult implements Serializable {

    private String status;
    private Data data;

    public QueryResult() {
        //required by Jackson
    }

    public QueryResult(String status, Data data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "QueryResult{" +
                "status='" + status + '\'' +
                ", data=" + data +
                '}';
    }

}
