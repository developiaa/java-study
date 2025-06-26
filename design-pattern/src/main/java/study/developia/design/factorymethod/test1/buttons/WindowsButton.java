package study.developia.design.factorymethod.test1.buttons;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WindowsButton implements Button{
    @Override
    public void render() {
        System.out.println("WindowsButton render");

    }

    @Override
    public void onClick() {
        System.out.println("WindowsButton onClick");
    }
}
