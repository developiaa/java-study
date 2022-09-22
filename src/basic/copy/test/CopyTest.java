package basic.copy.test;

import basic.copy.Developia;

public class CopyTest {
    public static void main(String[] args) {
        Developia developiaMain = new Developia("A", 10000);

        /*
         * 얕은 복사(shallow copy)
         * 주소값을 복사하는 얕은 복사가 이루어짐
         */

        Developia developia1 = developiaMain;

        developia1.spendMoney(1000);
        System.out.println("developia1 = " + developia1);
        // 2의 돈을 차감했지만 1도 변화된 것을 알 수 있다.
        System.out.println("developiaMain = " + developiaMain);
        System.out.println();

        /*
         * 깊은 복사(deep copy)
         * 1. 복사 생성자를 이용한 방법
         */
        Developia developiaMain2 = new Developia("A", 10000);
        Developia developia2 = new Developia(developiaMain2);

        developia2.spendMoney(1000);
        System.out.println("developia2 = " + developia2);
        System.out.println("developiaMain2 = " + developiaMain2);
        System.out.println();

        /*
         * 깊은 복사(deep copy)
         * 2. 복사 팩토리 메소드를 이용한 방법
         */
        Developia developiaMain3 = new Developia("A", 10000);
        Developia developia3 = Developia.newObject(developiaMain3);

        developia3.spendMoney(1000);
        System.out.println("developia3 = " + developia3);
        System.out.println("developiaMain3 = " + developiaMain3);
        System.out.println();

        /*
         * 깊은 복사(deep copy)
         * 3. 직접 객체를 생성하여 복사하는 방법
         */
        Developia developiaMain4 = new Developia("A", 10000);
        Developia developia4 = new Developia();
        developia4.setName(developiaMain4.getName());
        // 실무에서는 setMoney와 같은 동작이 제한 될 수 있음
        developia4.setMoney(developiaMain4.getMoney());

        developia4.spendMoney(1000);
        System.out.println("developia4 = " + developia4);
        System.out.println("developiaMain4 = " + developiaMain4);
        System.out.println();

        /*
         * 깊은 복사(deep copy)
         * 4. Cloneable interface 구현
         */
        Developia developiaMain5 = new Developia("A", 10000);
        // final 인스턴스나 배열이 아닌 경우에는 추천되지 않음
        try {
            Developia developia5 = developiaMain5.clone();
            developia5.spendMoney(1000);

            System.out.println("developia5 = " + developia5);
            System.out.println("developiaMain5 = " + developiaMain5);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }


}
