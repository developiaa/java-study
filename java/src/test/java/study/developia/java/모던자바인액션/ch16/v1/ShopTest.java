package study.developia.java.모던자바인액션.ch16.v1;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Future;

public class ShopTest {
    @Test
    void test() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime
                + " msecs");

        // 다른 상점 질의 같은 다른 작업 수행
        doSomethingElse();

        try {
            Double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");

    }

    private static void doSomethingElse() {
        System.out.println("Doing something else...");
    }
}
