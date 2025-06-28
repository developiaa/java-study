package study.developia.design.abstractfactory.test2.service;

import org.springframework.stereotype.Service;
import study.developia.design.abstractfactory.test2.processor.DocumentProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DocumentV2Service {
    private final Map<DocumentType, DocumentProcessor> documentProcessorMap;

    public DocumentV2Service(List<DocumentProcessor> documentProcessorList) {
        documentProcessorMap = new HashMap<>();
        for (DocumentProcessor documentProcessor : documentProcessorList) {
            documentProcessorMap.put(documentProcessor.getDocumentType(), documentProcessor);
        }
    }

    public void process(DocumentType type, String fileName) {
        DocumentProcessor documentProcessor = Optional.ofNullable(documentProcessorMap.get(type))
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 문서 유형입니다."));

        documentProcessor.process(fileName);
    }
}
