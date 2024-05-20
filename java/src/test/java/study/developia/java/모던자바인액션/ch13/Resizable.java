package study.developia.java.모던자바인액션.ch13;

public interface Resizable extends Drawable {

  int getWidth();
  int getHeight();
  void setWidth(int width);
  void setHeight(int height);
  void setAbsoluteSize(int width, int height);
  default void setRelativeSize(int widthFactor, int heightFactor){
    setAbsoluteSize(getWidth()/ widthFactor, getHeight()/ heightFactor);
  };

}
