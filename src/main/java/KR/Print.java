package KR;

public class Print implements Runnable{
    private static final Object lock = new Object();
    private static int currentNumber = 1;
    private final int numToPrint;

    public Print(int numToPrint) {
        this.numToPrint = numToPrint;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                while (currentNumber != numToPrint) {
                    try {
                        Thread.sleep(300);
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.print(numToPrint + ", ");
                currentNumber = currentNumber % 3 + 1;
                lock.notifyAll();

            }
        }
    }
}
