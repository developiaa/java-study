package study.developia.design.abstractfactory.test1.buttons;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WindowsButton implements Button {
    @Override
    public void paint() {
        log.info("WindowsButton paint");
    }
}
