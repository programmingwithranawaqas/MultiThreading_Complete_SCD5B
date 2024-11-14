package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPools {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for(int i=1; i<=20; i++)
        {
            final int temp = i;
            Runnable task = new Runnable(){
                    @Override
                    public void run(){
                    System.out.println(Thread.currentThread().getName()+" is doing the task : i = "+temp);
                }
            } ;

            executor.execute(task);
        }

        executor.shutdown();

    }
}
