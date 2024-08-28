import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDocumentController {

    @Autowired
    private TestDocumentService testDocumentService;

    @GetMapping("save")
    public String saveDocument(@RequestParam String message) {
        testDocumentService.saveTestDocument(message);
        return "Document saved!";
    }

    @GetMapping("find")
    public TestDocument findDocument(@RequestParam String id) {
        return testDocumentService.getTestDocument(id);
    }
}

