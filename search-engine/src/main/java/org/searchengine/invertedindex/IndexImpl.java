package org.searchengine.invertedindex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IndexImpl implements Index {

    private final Map<String, IndexEntry> index;

    public IndexImpl(Map<String, IndexEntry> index){
        this.index = index;
    }

    @Override
    public List<String> searchQuery(Query query) {
        List<String> result = new ArrayList<>();

        query.getTerms()
                .forEach(
                term -> result.addAll(searchTerm(term)));
        return result;
    }

    private List<String> searchTerm(String term) {
        IndexEntry entry = index.get(term);
        if (entry != null) {
            return entry.getDocumentIds();
        }
        return new ArrayList<>();
    }
}
