package basic.copy.clone;

import basic.copy.DevelopiaList;

import java.util.ArrayList;
import java.util.List;

public class CloneTest {
    public static void main(String[] args) {
        try {
            DevelopiaList developiaList = new DevelopiaList();
            List<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            developiaList.setList(list);

            DevelopiaList copy = developiaList.clone();
            copy.getList().add(4);

            DevelopiaList copy2 = developiaList.deepClone();
            copy2.getList().add(5);

            System.out.println("developiaList = " + developiaList.getList());
            System.out.println("copy = " + copy.getList());
            System.out.println("copy2 = " + copy2.getList());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
