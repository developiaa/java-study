package study.developia.java.모던자바인액션.ch02.apple.동적파라미터화;

public class Apple {
    private Integer weight;
    private Color color;

    public Apple(Integer weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
}
