import java.util.Stack;

public class Producer<T extends  Thread> extends Thread {

    private Stack<T> threads;

    public Producer(Stack<T> threads) {
        this.threads = threads;
    }

    @Override
    public void run() {
        super.run();
        // What should I do?
    }
}
