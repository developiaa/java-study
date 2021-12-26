package designpattern.command.second;

public class BotClient {
    public static void main(String[] args) {
        Serving serving = new Serving();
        //기능이 추가되면 의존성도 추가됨
        Make make = new Make();

        // 의존성
        Bot bot = new Bot(serving, make);

        //서빙
        bot.setType("serve");
        bot.move_bot();

        //요리
        bot.setType("make");
        bot.move_bot();
    }
}
