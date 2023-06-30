package org.searchengine.data;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentRepository {
    private final Map<String, Document> documents;

    public DocumentRepository() {
        this.documents = new HashMap<>();
    }

    public void addDocument(Document document) {
        documents.put(document.getId(), document);
    }

    public Document getDocument(String documentId) {
        return documents.get(documentId);
    }

    public List<Document> getAllDocuments() {
        return new ArrayList<>(documents.values());
    }
}