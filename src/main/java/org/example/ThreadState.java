package org.example;

class MyThreadState extends Thread{
    public void run()
    {
        for (int i=1; i<=20; i++)
        {
            System.out.println(i);
        }
    }
}

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        //       Thread t1 = new MyThreadState();
//        System.out.println("Thread state before start : "+t1.getState());
//        t1.start();
//        System.out.println("Thread state after start : "+t1.getState());
//        try {
//            t1.join(); // wait to complete t1
//        }catch (InterruptedException e)
//        {
//            System.out.println(e.getMessage());
//        }
//        System.out.println("Thread state after join : "+t1.getState());
        Thread t1 = new MyThreadState();
        Thread t2 = new MyThreadState();
        t1.start();
        t1.join(); // t2 will wait for t1 to complete its task
        t2.start();

    }
}
