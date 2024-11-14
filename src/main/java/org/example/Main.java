package org.example;

class MyThread extends Thread{
    public void run()
    {
        System.out.println("Thread is running in Thread Class");
    }
}

class MyRunnable implements Runnable
{
    public void run()
    {
        System.out.println("Thread is running in Runnable Interface");
    }
}

public class Main {
    public static void main(String[] args) {
//        Thread t1 = new MyThread();
//        t1.start();
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}