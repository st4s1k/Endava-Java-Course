import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Value {
    volatile Double value;

    public Value() {
        this.value = 0d;
    }

    public Value(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public synchronized void add(Double value) {
        this.value += value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

class Adder implements Runnable {

    private final Double[] values;
    private final int begin;
    private final int end;
    private Value result;

    public Adder(Value result, Double[] values, int begin, int end){
        this.values = values;
        this.begin = begin;
        this.end = end;
        this.result = result;
    }

    public void run() {

        StringBuilder message = new StringBuilder();

        message.append('\n')
                .append(Thread.currentThread().getName())
                .append(" (Start) result(").append(result).append(")")
                .append(" + sum(").append(begin).append(", ").append(end).append(")")
                .append('\n');

        calculate();

        message.append(Thread.currentThread().getName())
                .append(" (End) result = ").append(result)
                .append('\n');

        System.out.print(message);
    }

    private synchronized void calculate() {
        for (int i = begin; i < values.length && i <= end; i++) {
            result.add(values[i]);
        }
    }
}

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

        System.out.println("\nCalculate sum for this values:\t" + Arrays.toString(values));
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

    }
}
