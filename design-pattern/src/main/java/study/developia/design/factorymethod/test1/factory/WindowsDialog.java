package study.developia.design.factorymethod.test1.factory;

import study.developia.design.factorymethod.test1.buttons.Button;
import study.developia.design.factorymethod.test1.buttons.WindowsButton;

public class WindowsDialog extends Dialog {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
