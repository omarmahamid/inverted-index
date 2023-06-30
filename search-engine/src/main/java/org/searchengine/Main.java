package org.searchengine;

import org.searchengine.data.Document;
import org.searchengine.data.DocumentRepository;
import org.searchengine.invertedindex.Index;
import org.searchengine.invertedindex.InvertedIndex;
import org.searchengine.invertedindex.Query;


import java.util.List;

public class Main{




    public static void main(String[] args) {

        InvertedIndex invertedIndex = new InvertedIndex();

        Document doc1 = new Document("1", "This is the first document.");
        Document doc2 = new Document("2", "This document contains some important information.");
        Document doc3 = new Document("3", "Another document is here.");
        Document doc4 = new Document("4", "This document is about the topic.");

        DocumentRepository documentRepository = invertedIndex.getDocumentRepository();
        documentRepository.addDocument(doc1);
        documentRepository.addDocument(doc2);
        documentRepository.addDocument(doc3);
        documentRepository.addDocument(doc4);

        Index index = invertedIndex.buildIndex();


        Query query = new Query();

        query.addTerm("important");

        List<String> searchResults = index.searchQuery(query);

        System.out.println("Search Results:");
        for (String documentId : searchResults) {
            Document document = documentRepository.getDocument(documentId);
            if (document != null) {
                System.out.println("Document ID: " + document.getId());
                System.out.println("Content: " + document.getContent());
                System.out.println("-----------------------");
            }
        }
    }
}