package study.developia.design.factorymethod.test1.buttons;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HtmlButton implements Button {
    @Override
    public void render() {
        System.out.println("<button>Html Button render</button>");
    }

    @Override
    public void onClick() {
        System.out.println("<button>Html Button onClick</button>");
    }
}
