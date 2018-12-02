import java.util.Stack;

public class Consumer<T extends  Thread> extends Thread {

    private Stack<T> threads;

    public Consumer(Stack<T> threads) {
        this.threads = threads;
    }

    @Override
    public void run() {

        if (!threads.empty()) {

            T thread = threads.pop();

            if (thread.getState() == State.NEW) {
                thread.start();
            }
        }
    }
}
