package pl.fizzbuzz.library.service;

import java.util.List;

public class QueryList {

    private List<String> queries;

    public QueryList() {
        // required by jackson
    }

    public QueryList(String... queries){
        this.queries = List.of(queries);
    }

    public List<String> getQueries() {
        return queries;
    }

    public void setQueries(List<String> queries) {
        this.queries = queries;
    }
}
