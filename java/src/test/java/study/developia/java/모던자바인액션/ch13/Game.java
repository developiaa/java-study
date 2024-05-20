package study.developia.java.모던자바인액션.ch13;

import java.util.Arrays;
import java.util.List;

public class Game {

  public static void main(String... args) {
    List<Resizable> resizableShapes = Arrays.asList(
        new Square(), new Triangle(), new Ellipse());
    Utils.paint(resizableShapes);
  }

}
