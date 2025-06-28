package study.developia.design.abstractfactory.test2.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import study.developia.design.abstractfactory.test2.service.DocumentType;

@Slf4j
@Component
public class PdfDocumentProcessor extends DocumentProcessor {
    @Override
    protected void read(String fileName) {
        log.info("pdf read file: {}", fileName);
    }

    @Override
    protected void convert(String fileName) {
        log.info("pdf convert file: {}", fileName);
    }

    @Override
    protected void save(String fileName) {
        log.info("pdf save file: {}", fileName);
    }

    @Override
    public DocumentType getDocumentType() {
        return DocumentType.PDF;
    }
}
