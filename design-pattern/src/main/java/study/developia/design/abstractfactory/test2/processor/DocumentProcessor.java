package study.developia.design.abstractfactory.test2.processor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class DocumentProcessor implements DocumentTypeProvider {
    public final void process(String fileName) {
        logStart(fileName);
        read(fileName);
        convert(fileName);
        save(fileName);
        logEnd(fileName);
    }

    private void logStart(String fileName) {
        log.info("[START] Processing file: " + fileName);
    }

    private void logEnd(String fileName) {
        log.info("[END] Processing file: " + fileName);
    }

    protected abstract void read(String fileName);

    protected abstract void convert(String fileName);

    protected abstract void save(String fileName);

}
