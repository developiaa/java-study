package designpattern.command.third;

public class MakeCommand implements Command {
    private Make make;

    //외부에서 의존성 주입
    public MakeCommand(Make make) {
        this.make = make;
    }

    @Override
    public void run() {
        make.cook();
    }
}
