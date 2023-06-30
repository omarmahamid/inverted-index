package org.searchengine.invertedindex;

import java.util.List;
import java.util.ArrayList;
class IndexEntry {
    private final String term;
    private final List<String> documentIds;

    public IndexEntry(String term) {
        this.term = term;
        this.documentIds = new ArrayList<>();
    }

    public String getTerm() {
        return term;
    }

    public List<String> getDocumentIds() {
        return documentIds;
    }

    public void addDocumentId(String documentId) {
        documentIds.add(documentId);
    }
}
