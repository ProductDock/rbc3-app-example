package com.example.elkdemo;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class RestController {
    
    private static Logger LOG = LoggerFactory
			.getLogger(RestController.class);

    @Autowired
    private TestDocumentService testDocumentService;

    @GetMapping("health")
    public ResponseEntity<String> ping() {
        return new ResponseEntity<>("Hello RBC 3!", HttpStatus.OK);
    }

    @GetMapping("save")
    public ResponseEntity<String> saveDocument(@RequestParam String message) {
        testDocumentService.saveTestDocument(message);
        return new ResponseEntity<>("Document saved!", HttpStatus.OK);
    }

    @GetMapping("find")
    public TestDocument findDocument(@RequestParam String id) {
        return testDocumentService.getTestDocument(id);
    }
    @GetMapping("count")
    public ResponseEntity<Void> count() {
        countAsync();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void countAsync() {
        CompletableFuture.runAsync(() -> {
            int i = 0;
            while (i < 60*60) {
                LOG.info("EXECUTING no: " + ++i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
