package com.company;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<String> queue = new BlockingQueue<>(3);

        AddElementToQueue addElement = new AddElementToQueue(queue);
        RemoveElementFromQueue removeElement = new RemoveElementFromQueue(queue);

        Thread addedElements = new Thread(addElement);
        Thread removedElements = new Thread(removeElement);

        addedElements.start();
        removedElements.start();


    }
}
