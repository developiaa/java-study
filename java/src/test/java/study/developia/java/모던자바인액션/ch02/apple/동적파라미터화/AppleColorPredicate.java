package study.developia.java.모던자바인액션.ch02.apple.동적파라미터화;

public class AppleColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}
