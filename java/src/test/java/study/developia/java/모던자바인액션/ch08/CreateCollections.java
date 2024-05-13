package study.developia.java.모던자바인액션.ch08;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class CreateCollections {
    @Test
    void test1() {
        List<String> list = new ArrayList<>();
        list.add("Raphael");
        list.add("Olivia");
        list.add("Thibaut");
        list.set(0, "TEST");

        System.out.println(list);
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void test1_error() {
        List<String> list2 = Arrays.asList("Raphael", "Olivia", "Thibaut");
        try {
            list2.add("Thu"); // 고정된 길이의 list이기 때문에 추가는 불가능 - UnsupportedOperationException 발생
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test2() {
        Set<String> set = new HashSet<>(Arrays.asList("Raphael", "Olivia", "Thibaut"));
        assertThat(set.size()).isEqualTo(3);

        Set<String> set2 = Stream.of("Raphael", "Olivia", "Thibaut")
                .collect(Collectors.toSet());

        assertThat(set.size()).isEqualTo(set2.size());
    }

    @Test
    void test3() {
        // 역시 동일하게 에러 발생 - 크기를 바꿀 수 없는 리스트
        List<String> list2 = List.of("Raphael", "Olivia", "Thibaut");
//        list2.set(0, "TEST"); // 치환도 불가능
        try {
            list2.add("Thu"); // 고정된 길이의 list이기 때문에 추가는 불가능 - UnsupportedOperationException 발생
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        }
    }

    @Test
    void test4() {
        Map<String, Integer> map = Map.of("a", 10, "b", 20, "c", 30);
        Map<String, Integer> map2 = Map.ofEntries(
                entry("a", 10),
                entry("b", 20),
                entry("c", 30));

        assertThat(map.size()).isEqualTo(map2.size());
    }

    @Test
    void test5() {
        Map<String, String> map = Map.ofEntries(
                entry("a", "50"),
                entry("c", "40"),
                entry("b", "30"));

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(System.out::println);
        // forEachOrdered : 병렬 스트림에도 정렬을 보장한다
        // forEach : 병렬 스트림에는 정렬을 보장하지 않는다.

        System.out.println();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(System.out::println);
    }


    @Test
    void test_ex() {
        List<String> referenceCodes = Arrays.asList("a12", "C14", "b13");
        referenceCodes.stream()
                .map(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        for (ListIterator<String> iterator = referenceCodes.listIterator(); iterator.hasNext(); ) {
            String code = iterator.next();
            iterator.set(Character.toUpperCase(code.charAt(0)) + code.substring(1));
        }

        referenceCodes = Arrays.asList("a12", "C14", "b13");
        referenceCodes.replaceAll(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1));
        System.out.println("Changed by replaceAll(): " + referenceCodes);
    }

    @Test
    void test_ex2() {
        Map<String, List<String>> friendsToMovies = new HashMap<>();

        String friend = "Raphael";
        List<String> movies = friendsToMovies.get(friend);
        if (movies == null) {
            movies = new ArrayList<>();
            friendsToMovies.put(friend, movies);
        }
        movies.add("Star Wars");
        assertThat(friendsToMovies.size()).isEqualTo(1);

        friendsToMovies.clear();
        friendsToMovies.computeIfAbsent("Raphael", name -> new ArrayList<>())
                .add("Star Wars");

        assertThat(friendsToMovies.size()).isEqualTo(1);
        assertThat(friendsToMovies.get("Raphael").get(0)).isEqualTo("Star Wars");

        friendsToMovies.put("TEST", new ArrayList<>());
        friendsToMovies.computeIfPresent("Raphael", (key, value) -> {
                    System.out.println(key); // Raphael
                    System.out.println(value); // [Star Wars]
                    return new ArrayList<>();
                })
                .add("Star Wars2");

        System.out.println(friendsToMovies); // {Raphael=[Star Wars2], TEST=[]}
    }


    @Test
    void test6() {
        Map<String, String> favouriteMovies = Map.ofEntries(
                entry("Raphael", "Star Wars"),
                entry("Cristina", "Matrix"),
                entry("Olivia", "James Bond"));

        String orDefault = favouriteMovies.getOrDefault("Olivia", "Matrix");
        String orDefault2 = favouriteMovies.getOrDefault("Thibaut", "Matrix");

        assertThat(orDefault).isEqualTo("James Bond");
        assertThat(orDefault2).isEqualTo("Matrix"); // 값이 없는 경우 default 값 반환
    }

    @Test
    void test7() {
        Map<String, List<String>> friendsToMovies = new HashMap<>();

        String friend = "Raphael";
        List<String> movies = friendsToMovies.get(friend);
        if (movies == null) {
            movies = new ArrayList<>();
            friendsToMovies.put(friend, movies);
        }
        movies.add("Star Wars");
        System.out.println(friendsToMovies);

        System.out.println("--> Adding a friend and movie using computeIfAbsent()");
        friendsToMovies.clear();
        friendsToMovies.computeIfAbsent("Raphael", name -> new ArrayList<>())
                .add("Star Wars");

        assertThat(friendsToMovies.keySet()).containsExactly("Raphael");
        assertThat(friendsToMovies.get("Raphael")).isEqualTo(List.of("Star Wars"));
    }

    @Test
    void test8() {
        // 바꿀 수 있는 맵 필요!
        Map<String, String> favouriteMovies = new HashMap<>();
        favouriteMovies.put("Raphael", "Jack Reacher 2");
        favouriteMovies.put("Cristina", "Matrix");
        favouriteMovies.put("Olivia", "James Bond");
        String key = "Raphael";
        String value = "Jack Reacher 2";

        System.out.println("--> Removing an unwanted entry the cumbersome way");
        boolean result = remove(favouriteMovies, key, value);
        boolean result2 = remove(favouriteMovies, "test", value);
        System.out.printf("%s [%b]%n", favouriteMovies, result);
        System.out.printf("%s [%b]%n", favouriteMovies, result2);

        // 두 번째 테스트를 하기 전에 삭제된 항목을 다시 돌려놓음
        favouriteMovies.put("Raphael", "Jack Reacher 2");

        System.out.println("--> Removing an unwanted the easy way");
        favouriteMovies.remove(key, value);
        favouriteMovies.remove("test", value);
        System.out.printf("%s [%b]%n", favouriteMovies, result);
    }

    private static <K, V> boolean remove(Map<K, V> favouriteMovies, K key, V value) {
        if (favouriteMovies.containsKey(key) && Objects.equals(favouriteMovies.get(key), value)) {
            favouriteMovies.remove(key);
            return true;
        }
        return false;
    }

    @Test
    void test9() {
        Map<String, String> favouriteMovies = new HashMap<>();
        favouriteMovies.put("Raphael", "Star Wars");
        favouriteMovies.put("Olivia", "james bond");

        System.out.println("--> Replacing values in a map with replaceAll()");
        favouriteMovies.replaceAll((friend, movie) -> movie.toUpperCase());
        System.out.println(favouriteMovies);

        assertThat(favouriteMovies.get("Raphael")).isEqualTo("STAR WARS");
    }

    @Test
    void test10() {
        Map<String, String> family = Map.ofEntries(
                entry("Teo", "Star Wars"),
                entry("Cristina", "James Bond"));
        Map<String, String> friends = Map.ofEntries(entry("Raphael", "Star Wars"));

        System.out.println("--> Merging the old way");
        Map<String, String> everyone = new HashMap<>(family);
        everyone.putAll(friends);
        System.out.println(everyone);

        Map<String, String> friends2 = Map.ofEntries(
                entry("Raphael", "Star Wars"),
                entry("Cristina", "Matrix"));

        System.out.println("--> Merging maps using merge()");
        Map<String, String> everyone2 = new HashMap<>(family);
        friends2.forEach((k, v) -> everyone2.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
        System.out.println(everyone2);
    }

    @Test
    void quiz8_2() {
        Map<String, Integer> movies = new HashMap<>();
        movies.put("JamesBond", 20);
        movies.put("Matrix", 15);
        movies.put("Harry Potter", 5);

        Iterator<Map.Entry<String, Integer>> iterator = movies.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() < 10) {
                iterator.remove();
            }
        }
        System.out.println(movies);
        assertThat(movies.size()).isEqualTo(2);

        movies.clear();
        movies.put("JamesBond", 20);
        movies.put("Matrix", 15);
        movies.put("Harry Potter", 5);
        System.out.println(movies);
        assertThat(movies.size()).isEqualTo(3);


        movies.entrySet().removeIf(entry -> entry.getValue() < 10);
        assertThat(movies.size()).isEqualTo(2);

    }


}
