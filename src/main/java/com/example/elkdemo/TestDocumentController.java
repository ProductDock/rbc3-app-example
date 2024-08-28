import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Controller("db")
public class TestDocumentController {

    @Autowired
    private TestDocumentService testDocumentService;

    @GetMapping("save")
    public ResponseEntity<String> saveDocument(@RequestParam String message) {
        testDocumentService.saveTestDocument(message);
        return new ResponseEntity<>("Document saved!", HttpStatus.OK);
    }

    @GetMapping("find")
    public TestDocument findDocument(@RequestParam String id) {
        return testDocumentService.getTestDocument(id);
    }
}

