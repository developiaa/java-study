package designpattern.command.first;

public class BotClient {
    public static void main(String[] args) {
        Serving serving = new Serving();

        // 의존성
        Bot bot = new Bot(serving);
        bot.move_bot();

    }
}
