package study.developia.design.abstractfactory.test2.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.developia.design.abstractfactory.test2.service.DocumentType;

@Slf4j
@Component
public class WordDocumentProcessor extends DocumentProcessor {
    @Override
    protected void read(String fileName) {
        log.info("word read file: {}", fileName);
    }

    @Override
    protected void convert(String fileName) {
        log.info("word convert file: {}", fileName);
    }

    @Override
    protected void save(String fileName) {
        log.info("word save file: {}", fileName);
    }

    @Override
    public DocumentType getDocumentType() {
        return DocumentType.WORD;
    }
}
