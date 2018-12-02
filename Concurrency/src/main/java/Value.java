public class Value {
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
