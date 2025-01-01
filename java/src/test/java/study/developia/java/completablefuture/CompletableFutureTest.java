package study.developia.java.completablefuture;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
public class CompletableFutureTest {
    @Autowired
    Executor threadPoolTaskExecutor;


    private String sayMessage(String message) {
        sleepOneSecond();

        String saidMessage = "Say " + message;
        log.info("Said Message = {}", saidMessage);

        return saidMessage;
    }

    private void sleepOneSecond() {
        try {
            log.info("start to sleep 1 second.");
            Thread.sleep(1000);
            log.info("end to sleep 1 second.");
        } catch (InterruptedException e) {
            throw new IllegalStateException();
        }
    }

    @Test
    void supplyAsync() {
        //given
        String message = "hello";
        CompletableFuture<String> messageFuture = CompletableFuture.supplyAsync(() -> sayMessage(message));

        //when
        String result = messageFuture.join(); // CompletableFuture가 끝나기를 기다리는 블로킹 메서드, get()도 동일하지만 checked exception을 던진다.

        //then
        assertThat(result).isEqualTo("Say hello");
    }

    @Test
    void runAsync() {
        //given
        String message = "Hello";
        CompletableFuture<Void> messageFuture = CompletableFuture.runAsync(() -> sayMessage(message)); // runAsync는 리턴값이 없다.

        //when
        Void join = messageFuture.join();
    }

    @Test
    void completedFuture() {
        //given
        String message = "Hello";
        CompletableFuture<String> messageFuture = CompletableFuture.completedFuture(message); // 완료된 값이나 정적인 값을 감쌀때 사용

        //when
        String result = messageFuture.join();

        //then
        assertThat(result).isEqualTo("Hello");
    }

    @Test
    void thenApply() { // 반환형이 존재
        //given
        String message = "Hello";
        CompletableFuture<String> messageFuture = CompletableFuture.supplyAsync(() -> sayMessage(message));

        //when
        String result = messageFuture.thenApply(data -> "Applied message: " + data)
                .join();

        //then
        assertThat(result).isEqualTo("Applied message: Say " + message);
    }

    @Test
    void thenAccept() { // 반환형이 없음
        //given
        String message = "Hello";
        CompletableFuture<String> messageFuture = CompletableFuture.supplyAsync(() -> sayMessage(message));

        //when
        Void result = messageFuture
                .thenAccept(saidMessage -> {
                    String acceptedMessage = "accepted message : " + saidMessage;
                    log.info("thenAccept {}", acceptedMessage);
                })
                .join();
    }

    @DisplayName("처음 진행한 스레드를 계속 이용한다")
    @Test
    void thenApplyWithSameThread() {
        //given
        String message = "Hello";
        CompletableFuture<String> messageFuture = CompletableFuture.supplyAsync(() -> sayMessage(message), threadPoolTaskExecutor);

        //when
        String result = messageFuture
                .thenApply(saidMessage -> {
                    log.info("thenApply() : Same Thread");
                    return "Applied message : " + saidMessage;
                })
                .join();

        //then
        assertThat(result).isEqualTo("Applied message : Say Hello");
    }

    @Test
    void thenApplyAsync() {
        //given
        String message = "Hello";
        CompletableFuture<String> messageFuture = CompletableFuture.supplyAsync(() -> sayMessage(message));

        //when
        String result = messageFuture
                .thenApplyAsync(saidMessage -> { // 스레드풀을 지정하지 않으면 기본 스레드풀의 다른 스레드를 이용한다.
                    log.info("thenApply() : Same Thread");
                    return "Applied message : " + saidMessage;
                })
                .join();

        //then
        assertThat(result).isEqualTo("Applied message : Say Hello");
    }

    @Test
    void thenApplyAsyncAnotherThreadPool() {
        //given
        String message = "Hello";
        CompletableFuture<String> messageFuture = CompletableFuture.supplyAsync(() -> sayMessage(message));

        //when
        String result = messageFuture
                .thenApplyAsync(saidMessage -> { // 스레드풀을 지정하면 다른 스레드풀의 다른 스레드를 이용한다.
                    log.info("thenApply() : Same Thread");
                    return "Applied message : " + saidMessage;
                }, threadPoolTaskExecutor)
                .join();

        //then
        assertThat(result).isEqualTo("Applied message : Say Hello");
    }
}
