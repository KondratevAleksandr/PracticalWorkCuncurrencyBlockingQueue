package com.company;

public class RemoveElementFromQueue implements Runnable {

    private final BlockingQueue<String> queue;

    public RemoveElementFromQueue(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            while (queue.getSize() != 0) {
                String element = queue.dequeue();
                System.out.println("Removed: " + element);
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
