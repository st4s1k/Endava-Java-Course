public class Adder extends Thread {

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

    private synchronized void calculate() {
        for (int i = begin; i < values.length && i <= end; i++) {
            result.add(values[i]);
        }
    }

    @Override
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
}
