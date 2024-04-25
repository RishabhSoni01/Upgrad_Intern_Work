package org.example.Question1;

import java.util.Queue;
import java.util.LinkedList;

class MessageQueue {
    private Queue<String> queue;

    public MessageQueue() {
        queue = new LinkedList<>();
    }

    public synchronized void addMessage(String message) {
        queue.add(message);
        notifyAll();
    }

    public synchronized String getMessage() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.poll();
    }
}