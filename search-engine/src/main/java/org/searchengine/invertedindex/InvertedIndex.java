package org.searchengine.invertedindex;

import org.searchengine.data.Document;
import org.searchengine.data.DocumentRepository;

import java.util.*;

public class InvertedIndex {

    private final DocumentRepository documentRepository;

    public InvertedIndex() {
        this.documentRepository = new DocumentRepository();
    }

    public Index buildIndex() {
        List<Document> documents = documentRepository.getAllDocuments();
        Map<String, IndexEntry> index = new HashMap<>();

        for (Document document : documents) {
            List<String> terms = tokenize(document.getContent());
            for (String term : terms) {
                addTerm(term, document.getId(), index);
            }
        }
        return new IndexImpl(index);
    }

    private void addTerm(String term, String documentId, Map<String, IndexEntry> index) {
        IndexEntry entry = index.getOrDefault(term, new IndexEntry(term));
        entry.addDocumentId(documentId);
        index.put(term, entry);
    }


    private List<String> tokenize(String content) {
        return Arrays.asList(content.split("\\s+"));
    }

    public DocumentRepository getDocumentRepository() {
        return documentRepository;
    }
}