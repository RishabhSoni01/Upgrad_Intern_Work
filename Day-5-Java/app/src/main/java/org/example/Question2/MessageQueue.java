package org.example.Question2;

import java.util.Queue;
import java.util.LinkedList;

class MessageQueue {
    private final Object lock = new Object();
    private Queue<String> queue;

    public MessageQueue() {
        queue = new LinkedList<>();
    }

    public void addMessage(String message) {
        synchronized (lock) {
            queue.add(message);
            lock.notifyAll();
        }
    }

    public String getMessage() throws InterruptedException {
        synchronized (lock) {
            while (queue.isEmpty()) {
                lock.wait();
            }
            return queue.poll();
        }
    }
}