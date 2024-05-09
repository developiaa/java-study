package study.developia.java.모던자바인액션.ch07;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;

import static study.developia.java.모던자바인액션.ch07.ParallelStreams.measurePerf;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime) // 벤치마크 대상 메소드를 실행하는 데 걸린 평균 시간 측정
@OutputTimeUnit(TimeUnit.MILLISECONDS) // 벤치마크 결과를 밀리초 단위로 출력
@Fork(value = 2, jvmArgs = {"-Xms4G", "-Xmx4G"}) // 4Gb의 힙 공간을 제공한 환경에서 두 번 벤치마크를 수행해 결과의 신뢰성 확보
public class ParallelStreamBenchmark {

  private static final long N = 10_000_000L;

//  @Benchmark // 벤치마크 대상 메소드
//  public long sequentialSum() {
//    return Stream.iterate(1L, i -> i + 1)
//            .limit(N)
//            .reduce(0L, Long::sum);
//  }

  @TearDown(Level.Invocation) // 매 번 벤치마크를 실행한 다음에는 가비지 컬렉터 동작 시도
  public void tearDown() {
    System.gc();
  }

  @Benchmark // 벤치마크 대상 메소드
  public void test() {
    System.out.println("SideEffect parallel sum done in: " +
            measurePerf(ParallelStreams::sideEffectParallelSum, 10_000_000L) + " msecs");
  }

}
