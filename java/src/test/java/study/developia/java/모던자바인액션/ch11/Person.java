package study.developia.java.모던자바인액션.ch11;

import java.util.Optional;

public class Person {

  private Optional<Car> car;
  private int age;

  public Optional<Car> getCar() {
    return car;
  }

  public int getAge() {
    return age;
  }

}
