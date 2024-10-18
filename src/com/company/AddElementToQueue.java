package com.company;

public class AddElementToQueue implements Runnable {

    private final BlockingQueue<String> queue;


    public AddElementToQueue(BlockingQueue<String> blockingQueue) {
        this.queue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                String task = "Task " + i;
                queue.enqueue(task);
                System.out.println("Added: " + task);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
