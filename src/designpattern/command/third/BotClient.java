package designpattern.command.third;


public class BotClient {
    public static void main(String[] args) {
        Serving serving = new Serving();
        Make make = new Make();

        Command servingCommand = new ServingCommand(serving);
        MakeCommand makeCommand = new MakeCommand(make);
        Bot bot = new Bot();

        //serving
        //setter로 해도 되고 생성자에서 해도 됨
        bot.setCommand(servingCommand);
        bot.move_bot();

        //make
        bot.setCommand(makeCommand);
        bot.move_bot();

        /**
         * 새로운 동작이 추가된다고 하더라도 command 인터페이스를 구현하기만 하면 되기 때문에
         * ocp 원칙에 위배되지 않는다.
         *
         */
    }
}
