package study.developia.design.abstractfactory.test2.service;

import org.springframework.stereotype.Service;
import study.developia.design.abstractfactory.test2.processor.DocumentProcessor;
import study.developia.design.abstractfactory.test2.processor.PdfDocumentProcessor;
import study.developia.design.abstractfactory.test2.processor.WordDocumentProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class DocumentV1Service {
    private final Map<String, DocumentProcessor> documentProcessorMap;

    public DocumentV1Service(
            PdfDocumentProcessor pdfDocumentProcessor,
            WordDocumentProcessor wordDocumentProcessor
    ) {
        documentProcessorMap = new HashMap<>();
        documentProcessorMap.put("pdf", pdfDocumentProcessor);
        documentProcessorMap.put("word", wordDocumentProcessor);
    }

    public void process(String type, String fileName) {
        DocumentProcessor documentProcessor = Optional.ofNullable(documentProcessorMap.get(type))
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 문서 유형입니다."));

        documentProcessor.process(fileName);
    }
}
