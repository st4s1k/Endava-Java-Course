import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Adder implements Runnable {

    private final Double[] values;
    private final int begin;
    private final int end;
    private volatile Double result;

    public Adder(Double result, Double[] values, int begin, int end){
        this.values = values;
        this.begin = begin;
        this.end = end;
        this.result = result;
    }

    public void run() {

        StringBuilder message = new StringBuilder();

        message.append(Thread.currentThread().getName())
                .append(" (Start) result(").append(result).append(")")
                .append(" + sum(").append(begin).append(", ").append(end).append(")");

        calculate();

        message.append(Thread.currentThread().getName())
                .append(" (End) result = ").append(result);

        System.out.println(message);
    }

    private synchronized void calculate() {
        for (int i = begin; i < values.length && i <= end; i++) {
            result += values[i];
        }
    }
}

public class Concurrency {

    public static Double calcSum(Double[] values, int numberOfThreads) {

        Double result = 0d;

        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            int resolution = values.length / numberOfThreads;
            Adder adder = new Adder(result, values, i * resolution, (i + 1) * resolution - 1) ;
            executor.execute(adder);
        }

        while (!executor.isTerminated()) {}

        return 0d;
    }

    public static void main(String[] args) {

        Double[] values = new Double[] {0d, 1d, 2d, 3d, 4d, 5d, 6d, 7d, 8d, 9d};

        int numberOfThreads = 3;

        System.out.println("The sum of values:\n" + Arrays.toString(values));
        System.out.println("equals to: " + calcSum(values, numberOfThreads));
    }
}
