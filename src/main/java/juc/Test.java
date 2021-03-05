package juc;

import tree.Tree;

import java.util.concurrent.atomic.*;
import java.util.stream.IntStream;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/2/2 3:11 下午
 */
public class Test {

    public AtomicInteger integer;

    public static void main(String[] args) {
//        AtomicIntegerFieldUpdater<Object> objectAtomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater();
        AtomicReference<Tree> treeRef = new AtomicReference<>();
        LongAccumulator accumulator = new LongAccumulator(Long::sum, 0);
        LongAdder adder = new LongAdder();
        IntStream.range(1, 10).forEach(i -> {
            System.out.println("fuck" + i);
            accumulator.accumulate(i);
            adder.add(i);
        });
        System.out.println(accumulator.get());
        accumulator.getThenReset();
        System.out.println(accumulator.get());
//        treeRef.set();
    }
}
