import java.util.Arrays;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Concurrency {

    public static Double calcSum(Double[] values, int numberOfThreads) {

        Value result = new Value(0d);

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {

            int resolution = (int) Math.ceil((double) values.length / numberOfThreads);

            Adder adder = new Adder(result, values, i * resolution, (i + 1) * resolution - 1);

            executor.execute(adder);
        }
        executor.shutdown();

        executor.shutdown();

        while (!executor.isTerminated()) {}

        return result.getValue();
    }

    public static void main(String[] args) {

        Double[] values = new Double[] {0d, 1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d};

        int numberOfThreads = 3;

        System.out.println("");
        System.out.println("###########");
        System.out.println("# Task №1 #");
        System.out.println("###########");
        System.out.println("");

        System.out.println("Calculate sum for this values:\t" + Arrays.toString(values));
        System.out.println("\nThe sum of values is: " + calcSum(values, numberOfThreads));

//        OUTPUT:
//
//        Calculate sum for this values:	[0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]
//
//        pool-1-thread-1 (Start) result(0.0) + sum(0, 3)
//        pool-1-thread-1 (End) result = 6.0
//
//        pool-1-thread-2 (Start) result(6.0) + sum(4, 7)
//        pool-1-thread-2 (End) result = 28.0
//
//        pool-1-thread-3 (Start) result(28.0) + sum(8, 11)
//        pool-1-thread-3 (End) result = 45.0
//
//        The sum of values is: 45.0
//
//        Process finished with exit code 0

        System.out.println("");
        System.out.println("###########");
        System.out.println("# Task №2 #");
        System.out.println("###########");
        System.out.println("");

        Stack<Adder> threads = new Stack<Adder>();

        Value[] results = new Value[] {
                new Value(0d),
                new Value(0d),
                new Value(0d),
                new Value(0d),
        };

        threads.push(new Adder(results[0], values, 0, values.length));
        threads.push(new Adder(results[1], values, (int) (0.25*values.length), values.length));
        threads.push(new Adder(results[2], values, (int) (0.50*values.length), values.length));
        threads.push(new Adder(results[3], values, (int) (0.75*values.length), values.length));

        Producer<Adder> adderProducer = new Producer<Adder>(threads);

        Consumer<Adder> adderConsumer = new Consumer<Adder>(threads);

        System.out.println(Arrays.toString(results));

    }
}
