package study.developia.java.testapi.controller;


import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Stream;

@Controller
public class UsersController {

    private UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @ResponseBody
    @GetMapping("/users/{username}/items/total")
    public Map<String, Integer> totalItemsBought(@PathVariable(name = "username")
                                                 String username) {
        Map<String, Integer> map = new HashMap<>();
        int item = usersService.getNumberOfItemsBought(username);
        map.put("totalItemsBought", item);


        Stream<Test> language2 = Stream.of(Test.builder()
                .name("name1")
                .price(10)
                .build(), null, Test.builder()
                .name("name1")
                .price(2)
                .build());
//
//        Stream<Test> language = Stream.empty();
//
//        List<Test> collect = Optional.ofNullable(language).orElse(Stream.of())
//                .filter(Objects::nonNull)
//                .map(d -> Test.builder().build())
//                .reduce();


//        System.out.println("collect = " + collect);


        return map;
    }

    @Value
    static class Test {
        public String name;
        public int price;

        @Builder
        public Test(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }
}
