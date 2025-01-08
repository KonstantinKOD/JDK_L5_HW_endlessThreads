package KR;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Print(1));
        Thread thread2 = new Thread(new Print(2));
        Thread thread3 = new Thread(new Print(3));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}