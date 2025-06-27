package study.developia.design.abstractfactory.test1.checkboxes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        log.info("Windows Checkbox paint");
    }
}
