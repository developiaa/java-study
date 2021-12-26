package designpattern.command.third;


public class Bot {
    private Command command;

    public void move_bot() {
        //커맨드로 캡슐화
        command.run();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
