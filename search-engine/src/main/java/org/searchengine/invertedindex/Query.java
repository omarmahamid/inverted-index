package org.searchengine.invertedindex;

import java.util.List;
import java.util.ArrayList;
public class Query {
    private final List<String> terms;

    public Query() {
        this.terms = new ArrayList<>();
    }

    public void addTerm(String term) {
        terms.add(term);
    }

    public List<String> getTerms() {
        return terms;
    }
}