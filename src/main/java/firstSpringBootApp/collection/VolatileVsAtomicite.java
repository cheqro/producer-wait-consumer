package firstSpringBootApp.collection;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileVsAtomicite {
    public static volatile int counter = 0;
    public static AtomicInteger atomicInteger = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                //increment();
                atomicInteger.incrementAndGet();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                //increment();
                atomicInteger.incrementAndGet();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(atomicInteger.get());
        System.out.println(counter);
    }

    public static synchronized void increment() {
        counter++;
    }


}
