package org.example.Q1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MessageSender implements Runnable {
    private final Queue<Integer> messages;
    private final int maxCapacity;
    private final Lock lock;
    private final Condition messagesNotFull;
    private final Condition messagesNotEmpty;

    MessageSender(Queue<Integer> messages, int maxCapacity, Lock lock, Condition messagesNotFull, Condition messagesNotEmpty) {
        this.messages = messages;
        this.maxCapacity = maxCapacity;
        this.lock = lock;
        this.messagesNotFull = messagesNotFull;
        this.messagesNotEmpty = messagesNotEmpty;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                lock.lock();
                try {
                    while (messages.size() == maxCapacity) {
                        messagesNotFull.await();
                    }

                    messages.offer(i);
                    System.out.println(Thread.currentThread().getName() + " Producing " + i);
                    messagesNotEmpty.signalAll();
                } finally {
                    lock.unlock();
                }
                Thread.sleep((1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class MessageReceiver implements Runnable {
    private final Queue<Integer> messages;
    private final Lock lock;
    private final Condition messagesNotEmpty;
    private final Condition messagesNotFull;

    MessageReceiver(Queue<Integer> messages, Lock lock, Condition messagesNotEmpty, Condition messagesNotFull) {
        this.messages = messages;
        this.lock = lock;
        this.messagesNotEmpty = messagesNotEmpty;
        this.messagesNotFull = messagesNotFull;
    }

    public void run() {
        try {
            while (true) {
                lock.lock();
                try {
                    while (messages.isEmpty()) {
                        messagesNotEmpty.await();
                    }
                    int value = messages.poll();
                    System.out.println(Thread.currentThread().getName() + " " + value);
                    messagesNotFull.signalAll();
                } finally {
                    lock.unlock();
                }
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class MessageQueue {
    public static void main(String[] args) {
        Queue<Integer> messages = new LinkedList<>();
        int maxCapacity = 20;

        Lock lock = new ReentrantLock();
        Condition messagesNotFull = lock.newCondition();
        Condition messagesNotEmpty = lock.newCondition();

        MessageSender messageSender = new MessageSender(messages, maxCapacity, lock, messagesNotFull, messagesNotEmpty);
        MessageReceiver messageReceiver = new MessageReceiver(messages, lock, messagesNotEmpty, messagesNotFull);

        Thread messageSenderThread1 = new Thread(messageSender, "MessageSender1");
        Thread messageReceiverThread1 = new Thread(messageReceiver, "MessageReceiver1");

        Thread messageSenderThread2 = new Thread(messageSender, "MessageSender2");
        Thread messageReceiverThread2 = new Thread(messageReceiver, "MessageReceiver2");

        Thread messageSenderThread3 = new Thread(messageSender, "MessageSender3");
        Thread messageReceiverThread3 = new Thread(messageReceiver, "MessageReceiver3");

        messageSenderThread1.start();
        messageReceiverThread1.start();

        messageSenderThread2.start();
        messageReceiverThread2.start();

        messageSenderThread3.start();
        messageReceiverThread3.start();
    }
}
