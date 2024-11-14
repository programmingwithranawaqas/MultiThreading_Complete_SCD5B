package org.example;

class Counter{
    int count = 0;
    public synchronized void increment() {
        count++;
    }
}

class UnsynchThread extends Thread{
    Counter counter;
    UnsynchThread(Counter counter)
    {
        this.counter = counter;
    }
    public void run()
    {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

public class ThreadSynchronization {
    public static void main(String[] args) throws InterruptedException {
        Counter counterMain = new Counter();

        Thread t1 = new UnsynchThread(counterMain);
        Thread t2 = new UnsynchThread(counterMain);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Count : "+counterMain.count);

    }
}
