package study.developia.design.abstractfactory.test1;

import lombok.extern.slf4j.Slf4j;
import study.developia.design.abstractfactory.test1.app.Application;
import study.developia.design.abstractfactory.test1.factories.GUIFactory;
import study.developia.design.abstractfactory.test1.factories.MacOSFactory;
import study.developia.design.abstractfactory.test1.factories.WindowsFactory;

@Slf4j
public class Main {
    public static void main(String[] args) {
        GUIFactory factory = new MacOSFactory();
        Application application = new Application(factory);
        application.paint();

        GUIFactory factory2 = new WindowsFactory();
        Application application2 = new Application(factory2);
        application2.paint();
    }
}
