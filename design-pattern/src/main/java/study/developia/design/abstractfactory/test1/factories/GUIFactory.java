package study.developia.design.abstractfactory.test1.factories;

import study.developia.design.abstractfactory.test1.buttons.Button;
import study.developia.design.abstractfactory.test1.checkboxes.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
