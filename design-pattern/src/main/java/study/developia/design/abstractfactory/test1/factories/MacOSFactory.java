package study.developia.design.abstractfactory.test1.factories;

import study.developia.design.abstractfactory.test1.buttons.Button;
import study.developia.design.abstractfactory.test1.buttons.MacOSButton;
import study.developia.design.abstractfactory.test1.checkboxes.Checkbox;
import study.developia.design.abstractfactory.test1.checkboxes.MacOSCheckbox;

public class MacOSFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}
