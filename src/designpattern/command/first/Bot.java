package designpattern.command.first;

public class Bot {
    private Serving serving;

    public Bot(Serving serving) {
        this.serving = serving;
    }

    public void move_bot() {
        serving.serve();
    }
}
