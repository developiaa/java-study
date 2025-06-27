package study.developia.design.abstractfactory.test1.factories;

import study.developia.design.abstractfactory.test1.buttons.Button;
import study.developia.design.abstractfactory.test1.buttons.WindowsButton;
import study.developia.design.abstractfactory.test1.checkboxes.Checkbox;
import study.developia.design.abstractfactory.test1.checkboxes.WindowsCheckbox;

public class WindowsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
