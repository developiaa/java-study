package designpattern.command.third;

public class ServingCommand implements Command {
    private Serving serving;

    //외부에서 의존성 주입
    public ServingCommand(Serving serving) {
        this.serving = serving;
    }

    @Override
    public void run() {
        serving.serve();
    }
}
