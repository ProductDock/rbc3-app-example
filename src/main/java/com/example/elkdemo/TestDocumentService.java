package com.example.elkdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDocumentService {

    @Autowired
    private TestDocumentRepository repository;

    public void saveTestDocument(String message) {
        TestDocument document = new TestDocument();
        document.setMessage(message);
        repository.save(document);
    }

    public TestDocument getTestDocument(String id) {
        return repository.findById(id).orElse(null);
    }
}

