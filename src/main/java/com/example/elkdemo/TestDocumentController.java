package com.example.elkdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class TestDocumentController {

    private static Logger LOG = LoggerFactory
			.getLogger(RestController.class);

    @Autowired
    private TestDocumentService testDocumentService;

    @GetMapping("/save")
    public ResponseEntity<String> saveDocument(@RequestParam String message) {
        testDocumentService.saveTestDocument(message);
        return new ResponseEntity<>("Document saved!", HttpStatus.OK);
    }

    @GetMapping("/find")
    public TestDocument findDocument(@RequestParam String id) {
        return testDocumentService.getTestDocument(id);
    }
}

