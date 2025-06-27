package study.developia.design.abstractfactory.test2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.developia.design.abstractfactory.test2.service.DocumentV1Service;

@RequestMapping("/document")
@RequiredArgsConstructor
@RestController
public class DocumentController {
    private final DocumentV1Service documentV1Service;

    @GetMapping("/v1")
    public void processV1(@RequestParam String type) {
        documentV1Service.process(type, "test");
    }

}
