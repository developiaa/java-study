package collection.simple;

import collection.simple.list.BasicList;
import collection.simple.list.SimpleList;

import java.util.ArrayList;
import java.util.List;

public class SimpleListMainV1 {
    public static void main(String[] args) {
        SimpleList list = new BasicList();
        list.add("A");
        list.add("B");

        System.out.println("list=" + list);
    }
}
