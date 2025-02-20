package si.vratanar.publisherapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/index")
public class IndexController {
    @GetMapping()
    public String index() {
        return "Hello World!";
    }
}
