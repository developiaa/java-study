package collection.java;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class MapMain {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "data1");
        map.put(2, "data2");
        map.put(3, "data3");
        System.out.println("map = " + map);

        ConcurrentSkipListMap<Integer, String> concurrentSkipListMap = new ConcurrentSkipListMap<>();
        concurrentSkipListMap.put(1, "data1");
        concurrentSkipListMap.put(2, "data2");
        concurrentSkipListMap.put(3, "data3");
        System.out.println("concurrentSkipListMap = " + concurrentSkipListMap);
    }
}
