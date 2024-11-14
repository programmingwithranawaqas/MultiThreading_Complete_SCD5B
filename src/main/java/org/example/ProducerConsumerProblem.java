package org.example;

class SharedData{
    private int data;  // this data will be produced or consumed
    private boolean isProduced = false;

    public synchronized void produce(int d) throws InterruptedException {
        if(isProduced)
        {
            wait();
        }
        data = d;
        System.out.println("Produced : "+data);
        isProduced = true;
        notify();
    }
    public synchronized void consume() throws InterruptedException {
        if(!isProduced)
        {
            wait();
        }

        System.out.println("Consumed : "+data);
        isProduced = false;
        notify();
    }
}

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        SharedData sData = new SharedData();
        Thread producerThread = new Thread(()->{
            for (int i=1; i<=10; i++)
            {
                try {
                    sData.produce(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerThread = new Thread(()->{
            for (int i=1; i<=10; i++)
            {
                try {
                    sData.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerThread.start();
        consumerThread.start();

    }
}
