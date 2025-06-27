package study.developia.design.abstractfactory.test1.app;

import study.developia.design.abstractfactory.test1.buttons.Button;
import study.developia.design.abstractfactory.test1.checkboxes.Checkbox;
import study.developia.design.abstractfactory.test1.factories.GUIFactory;

public class Application {
    private final Button butoon;
    private final Checkbox checkbox;

    public Application(GUIFactory guiFactory) {
        this.butoon = guiFactory.createButton();
        this.checkbox = guiFactory.createCheckbox();
    }

    public void paint() {
        butoon.paint();
        checkbox.paint();
    }
}
