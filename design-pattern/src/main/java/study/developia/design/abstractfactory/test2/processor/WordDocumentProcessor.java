package study.developia.design.abstractfactory.test2.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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
}
