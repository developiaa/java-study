package study.developia.java.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

public class UriComponentsBuilderTest {
    @Test
    void test() {
        URI uri = UriComponentsBuilder
                .fromPath("/hotel-rooms/{hotelName}")
                .queryParam("type", "{type}")
                .queryParam("isActive", "{isActive}")
                .scheme("http")
                .host("127.0.0.1")
                .port(8080)
                .build("LineHotel", "Hotel", "true");

        Assertions.assertEquals(uri.toString(), "http://127.0.0.1:8080/hotel-rooms/LineHotel?type=Hotel&isActive=true");
    }

    @Test
    void test2() {
        String path = "/hotel-names/" + "한국호텔";
        URI uri = UriComponentsBuilder
                .fromPath(path)
                .scheme("http")
                .host("127.0.0.1")
                .port(8080)
                .build()
                .toUri();

        System.out.println(uri.toString());
        Assertions.assertEquals(uri.toString(), "http://127.0.0.1:8080/hotel-names/한국호텔");
    }

    @Test
    void test3() {
        String path = "/hotel-names/" + "한국호텔";
        URI uri = UriComponentsBuilder
                .fromPath(path)
                .scheme("http")
                .host("127.0.0.1")
                .port(8080)
                .build(false)
                .encode().toUri();

        System.out.println(uri.toString());
        Assertions.assertEquals(uri.toString(), "http://127.0.0.1:8080/hotel-names/%ED%95%9C%EA%B5%AD%ED%98%B8%ED%85%94");
    }
}
