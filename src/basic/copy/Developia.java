package basic.copy;

public class Developia implements Cloneable {
    public String name;
    public Integer money;

    public Developia() {
    }

    public Developia(String name, Integer money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public Integer getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 실무에서는 해당 메소드가 제한 될 수 있음
    public void setMoney(Integer money) {
        this.money = money;
    }

    // 금액 차감
    public void spendMoney(Integer money) {
        this.money -= money;
    }

    @Override
    public String toString() {
        return "Developia{" +
                "money=" + money +
                '}';
    }

    // 복사 생성자를 이용한 방법
    public Developia(Developia developia) {
        this.name = developia.name;
        this.money = developia.money;
    }

    // 복사 팩토리 메소드를 이용한 방법
    public static Developia newObject(Developia developia) {
        // 기본 생성자 필요
        Developia d = new Developia();
        d.name = developia.name;
        d.money = developia.money;
        return d;
    }

    @Override
    public Developia clone() throws CloneNotSupportedException {
        return (Developia) super.clone();
    }
}
