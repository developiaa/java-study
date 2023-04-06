package basic.phone;

import java.util.*;

public class Phone {
    public static void main(String[] args) {
        Person person = new Person("Developia");
        person.addPhoneNumber(new PhoneNumber("01012345678"));
//        person.addPhoneNumber(new PhoneNumber("010-1234-5678"));
//        person.addPhoneNumber(new PhoneNumber("010 2222 3333"));
        System.out.println("person = " + person);

        System.out.println(person.hasPhoneNumber(new PhoneNumber("010 1234 5678")));

        System.out.println();
        Person person1 = new Person("developia2");
        person1.addPhoneNumber(new PhoneNumber("010-1234-1111"));
        person1.addPhoneNumber(new PhoneNumber("010-4234-1111"));

        Person person2 = new Person("developia3");
        person2.addPhoneNumber(new PhoneNumber("010-2222-3333"));
        person2.addPhoneNumber(new PhoneNumber("010-2222-4444"));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson(person1);
        phoneBook.addPerson(person2);
        System.out.println("phoneBook = " + phoneBook);

        System.out.println(phoneBook.search(new PhoneNumber("010 2222 4444")));
    }

    public static class PhoneNumber {
        public final String phoneNumber;

        public PhoneNumber(String rawPhoneNumber) {
            this.phoneNumber = rawPhoneNumber.replaceAll("[^0-9]", "");
        }

        @Override
        public String toString() {
            return "PhoneNumber{" +
                    "phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof PhoneNumber)) return false;
            return phoneNumber.equals(((PhoneNumber) o).phoneNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(phoneNumber);
        }
    }

    public static class Person {
        public final String name;
        private final List<PhoneNumber> numbers;

        public Person(String name) {
            this.name = name;
            this.numbers = new ArrayList<>();
        }

        public void addPhoneNumber(PhoneNumber phoneNumber) {
            this.numbers.add(phoneNumber);
        }

        public boolean addPhoneNumber(String number) {
            for (char c : number.toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
            return true;
        }

        public boolean hasPhoneNumber(PhoneNumber phoneNumber) {
            return numbers.contains(phoneNumber);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", numbers=" + numbers +
                    '}';
        }
    }

    public static class PhoneBook {
        private final Set<Person> people;

        private PhoneBook(){
            people = new HashSet<>();
        }

        public void addPerson(Person person) {
            people.add(person);
        }

        @Override
        public String toString() {
            return "PhoneBook{" +
                    "people=" + people +
                    '}';
        }

        public Person search(PhoneNumber phoneNumber) {
            return people.stream()
                    .filter(p -> p.hasPhoneNumber(phoneNumber))
                    .findFirst()
                    .orElse(null);
        }

    }
}
