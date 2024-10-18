package com.company;

import java.util.ArrayList;
import java.util.List;

public class BlockingQueue<T> {
    private final List<T> queue;
    private final int capacity;


    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new ArrayList<>(capacity);
    }

    public synchronized void enqueue(T task) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(task);
        notifyAll();

    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T task = queue.remove(0);
        notifyAll();
        return task;
    }


    public int getSize() {
        return queue.size();
    }
}
