package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class JsonTest {
    ObjectMapper objectMapper = new ObjectMapper();
    static class User {
        private String name;
        private int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

    }
    @Test
    void object2Json() throws IOException {
        User user = new User("Ryan", 30);
        // java object to json
        String userAsString = objectMapper.writeValueAsString(user);
        System.out.println("userAsString = " + userAsString);

    }

    @Test
    void string2Object() throws IOException {
        // String to Object
        String json = "{ \"name\" : \"Ryan\", \"age\" : 30 }";
        User user = objectMapper.readValue(json, User.class);
        System.out.println("user.getName() = " + user.getName());
        System.out.println("user.getAge() = " + user.getAge());
    }

    @Test
    void objectTest() throws IOException {
        // 위에 두개 통합 테스트
        User user = new User("Ryan", 30);
        String json = objectMapper.writeValueAsString(user);
        User user2 = objectMapper.readValue(json, User.class);
        System.out.println("user.getName() = " + user2.getName());
        System.out.println("user.getAge() = " + user2.getAge());
    }

    @Test
    void json2JsonNode() throws JsonProcessingException {
        String json = "{ \"name\" : \"Ryan\", \"age\" : 30 }";
        JsonNode jsonNode = objectMapper.readTree(json);
        String name = jsonNode.get("name").asText();// Ryan
        int age = jsonNode.get("age").asInt();// 30

        // 다른 타입으로
        int name2 = jsonNode.get("name").asInt();// 0 에러나지 않고 0으로 반환
        String age2 = jsonNode.get("age").asText();// 30

        JsonNode name3 = jsonNode.get("name");// Ryan
        JsonNode age3 = jsonNode.get("age");// 30

        System.out.println("name = " + name);
        System.out.println("name2 = " + name2);
        System.out.println("age = " + age);
        System.out.println("age2 = " + age2);

        System.out.println("name3 = " + name3);
        System.out.println("age3 = " + age3);
    }

    @Test
    void jsonArrayString2List() throws JsonProcessingException {
        String jsonArr = "[{\"name\":\"Ryan\",\"age\":30},{\"name\":\"Jake\",\"age\":20}]";
        List<User> users = objectMapper.readValue(jsonArr, new TypeReference<>() {
        });

        for (User user : users) {
            System.out.println("user.getName() = " + user.getName());
            System.out.println("user.getAge() = " + user.getAge());
        }
    }

    @Test
    void jsonArrayString2Map() throws JsonProcessingException {
        String jsonArr = "{\"name\":\"Ryan\",\"age\":30}";
        Map<String, Object> users = objectMapper.readValue(jsonArr, new TypeReference<>() {
        });

        for (String s : users.keySet()) {
            System.out.println(s + " : " + users.get(s));
        }
    }

}
