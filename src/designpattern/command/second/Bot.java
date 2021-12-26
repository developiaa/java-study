package designpattern.command.second;

public class Bot {
    private Serving serving;

    //기능 추가
    private Make make;

    private String type;

    public Bot(Serving serving, Make make) {
        this.serving = serving;
        this.make = make;
    }

    public void setType(String type) {
        this.type = type;
    }

    // 모듈이 추가될 때마다 분기가 늘어나게 된다. - 좋지 못한 코드
    // ocp에 위배된다.
    public void move_bot() {
        if (this.type.equals("serve")) {
            serving.serve();
        } else if (this.type.equals("make")) {
            make.cook();
        }

    }
}
