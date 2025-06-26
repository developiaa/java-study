package study.developia.design.factorymethod.test1;

import study.developia.design.factorymethod.test1.factory.Dialog;
import study.developia.design.factorymethod.test1.factory.HtmlDialog;
import study.developia.design.factorymethod.test1.factory.WindowsDialog;

public class Main {
    public static void main(String[] args) {
        Dialog windowsDialog = new WindowsDialog();
        windowsDialog.renderWindow();

        // protected 클래스이기 때문
        //windowsDialog.createButton();

        WindowsDialog windowsDialog1 = new WindowsDialog();
        windowsDialog1.createButton(); // 구체 클래스는 public

        Dialog htmlDialog = new HtmlDialog();
        htmlDialog.renderWindow();
    }
}
