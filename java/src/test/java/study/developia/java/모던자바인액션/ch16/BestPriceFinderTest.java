package study.developia.java.모던자바인액션.ch16;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Supplier;


public class BestPriceFinderTest {
    @Test
    void test1() {
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        execute("findPrice", () -> bestPriceFinder.findPrices("myPhone27S"));
    }

    @Test
    void test2() {
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        execute("parallel", () -> bestPriceFinder.findPricesParallel("myPhone27S"));
    }

    @Test
    void test3() {
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        execute("composed CompletableFuture", () -> bestPriceFinder.findPricesFuture("myPhone27S"));
    }

    @Test
    void test3_2() {
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        bestPriceFinder.printPricesStream("myPhone27S");
    }

    @Test
    void test4() {
        BestPriceFinder bestPriceFinder = new BestPriceFinder();
        execute("composed CompletableFuture", () -> bestPriceFinder.findPricesFuture2("myPhone27S"));
    }

    private static void execute(String msg, Supplier<List<String>> s) {
        long start = System.nanoTime();
        System.out.println(s.get());
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println(msg + " done in " + duration + " msecs");
    }
}
