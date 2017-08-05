package com.hieblmi.concurreny;

public class StopThread {

    // volatile enables thread communication
    // Raw types except for float and long allow atomic read/write access. Synchronization is still necessary
    // to make sure that changes from one thread are visible to all other threads.
    private static volatile boolean stopThread = false;


    // Changes to this variable in one Thread will not be visible to another one
    // private static boolean stopThread = false;

    public static void main(String[] args) throws Exception {

        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopThread) {
                i++;
            }
            System.out.println("Thread stopped.");
        });

        backgroundThread.start();

        Thread.sleep(2000);
        stopThread = true;
    }
}
