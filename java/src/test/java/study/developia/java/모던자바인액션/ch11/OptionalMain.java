package study.developia.java.모던자바인액션.ch11;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class OptionalMain {

    public String getCarInsuranceNameNullSafeV1(PersonV1 person) {
        if (person != null) {
            CarV1 car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "Unknown";
    }

    public String getCarInsuranceNameNullSafeV2(PersonV1 person) {
        if (person == null) {
            return "Unknown";
        }
        CarV1 car = person.getCar();
        if (car == null) {
            return "Unknown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "Unknown";
        }
        return insurance.getName();
    }

    @Test
    void test1() {
        Optional<Car> optCar = Optional.of(new Car());
        Assertions.assertThat(optCar).isNotNull();
    }

    @Test
    void test2() {
        Optional<Car> optCar = Optional.ofNullable(null);
        Assertions.assertThat(optCar).isEqualTo(Optional.empty());
    }

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public Set<String> getCarInsuranceNames(List<Person> persons) {
        return persons.stream()
                .map(Person::getCar)
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optInsurance -> optInsurance.map(Insurance::getName))
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());
    }

    public Insurance findCheapestInsurance(Person person, Car car) {
        // 다른 보험사에서 제공한 질의 서비스
        // 모든 데이터 비교
        Insurance cheapestCompany = new Insurance();
        return cheapestCompany;
    }

    public Optional<Insurance> nullSafeFindCheapestInsuranceQuiz(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }

    public String getCarInsuranceName(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    @Test
    void test3() {
        Optional<Integer> a = stringToInt("a");
        Assertions.assertThat(a).isEqualTo(Optional.empty());

        Optional<Integer> a2 = stringToInt("12344");
        Assertions.assertThat(a2).isNotEqualTo(Optional.empty());
        Assertions.assertThat(a2.get()).isEqualTo(12344);
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    @Test
    void test4() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        Assertions.assertThat(5).isEqualTo(readDuration(props, "a"));
        Assertions.assertThat(0).isEqualTo(readDuration(props, "b"));
        Assertions.assertThat(0).isEqualTo(readDuration(props, "c"));

        Assertions.assertThat(5).isEqualTo(readDurationWithOptional2(props, "a"));
        Assertions.assertThat(0).isEqualTo(readDurationWithOptional2(props, "b"));
        Assertions.assertThat(0).isEqualTo(readDurationWithOptional2(props, "c"));
    }

    public int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException e) {
            }
        }
        return 0;
    }

    public int readDurationWithOptional2(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalMain::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }


}

