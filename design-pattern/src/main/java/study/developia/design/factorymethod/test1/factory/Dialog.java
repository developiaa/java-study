package study.developia.design.factorymethod.test1.factory;

import study.developia.design.factorymethod.test1.buttons.Button;

public abstract class Dialog {
    public void renderWindow() {
        Button button = createButton();
        button.render();
    }

    protected abstract Button createButton();
}
