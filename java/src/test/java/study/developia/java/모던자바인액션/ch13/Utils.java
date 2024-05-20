package study.developia.java.모던자바인액션.ch13;

import java.util.List;

public class Utils {

  public static void paint(List<Resizable> l) {
    l.forEach(r -> {
      r.setAbsoluteSize(42, 42);
    });

    //l.forEach(r -> { r.setRelativeSize(2, 2); });
  }

}
