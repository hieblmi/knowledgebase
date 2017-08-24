package com.hieblmi.concurreny;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProducerConsumerWaitNotify {

    private static final int MAX_SIZE = 10;
    private static final List<Integer> queue = new LinkedList<>();
    private static boolean x = false;

    public static void main(String[] args) throws InterruptedException {


        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        synchronized (queue) {
                            while (queue.size() == MAX_SIZE) {
                                x = true;
                                System.out.println("Queue full. Producer is going to wait.");
                                queue.wait();
                            }
                        }

                        synchronized (queue) {
                            System.out.println("Queue size: " + queue.size());
                            System.out.println("Producer produces...");
                            queue.add(1);
                            Thread.sleep(100);
                            queue.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        synchronized (queue) {
                            while (queue.size() == 0) {
                                x = false;
                                System.out.println("Queue empty. Consumer is going to wait.");
                                queue.wait();
                            }
                        }

                        synchronized (queue) {
                            System.out.println("Queue size: " + queue.size());
                            System.out.println("Consumer consumes...");
                            queue.remove(0);
                            Thread.sleep(200);
                            queue.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        producer.start();
        consumer.start();

    }

}
