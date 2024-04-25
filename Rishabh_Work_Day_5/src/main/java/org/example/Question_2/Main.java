package org.example.Question_2;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MessageQueue {
    private volatile boolean isRunning = true;
    private Queue<String> messages = new LinkedList<>();

    public synchronized void addMessage(String message) {
        messages.add(message);
        notifyAll(); // Notify waiting receivers that a new message is available
    }

    public synchronized String getMessage() throws InterruptedException {
        while (messages.isEmpty() && isRunning) {
            wait(); // Wait until a message is available or the queue is stopped
        }
        return messages.poll();
    }

    public synchronized void stop() {
        isRunning = false;
        notifyAll(); // Notify waiting receivers to check if the queue is stopped
    }
}

class MessageSender implements Runnable {
    private MessageQueue messageQueue;
    private String senderName;

    public MessageSender(MessageQueue messageQueue, String senderName) {
        this.messageQueue = messageQueue;
        this.senderName = senderName;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            String message = "Message from " + senderName + ": " + i;
            messageQueue.addMessage(message);
            System.out.println(senderName + " sent: " + message);
            try {
                Thread.sleep(100); // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MessageReceiver implements Runnable {
    private MessageQueue messageQueue;
    private String receiverName;

    public MessageReceiver(MessageQueue messageQueue, String receiverName) {
        this.messageQueue = messageQueue;
        this.receiverName = receiverName;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = messageQueue.getMessage();
                if (message == null) {
                    break; // Exit the loop if the queue is stopped
                }
                System.out.println(receiverName + " received: " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue();

        // Create thread pools for MessageSenders and MessageReceivers
        ExecutorService senderPool = Executors.newFixedThreadPool(3);
        ExecutorService receiverPool = Executors.newFixedThreadPool(3);

        // Submit MessageSender tasks to the sender thread pool
        senderPool.submit(new MessageSender(messageQueue, "Sender 1"));
        senderPool.submit(new MessageSender(messageQueue, "Sender 2"));
        senderPool.submit(new MessageSender(messageQueue, "Sender 3"));

        // Submit MessageReceiver tasks to the receiver thread pool
        receiverPool.submit(new MessageReceiver(messageQueue, "Receiver 1"));
        receiverPool.submit(new MessageReceiver(messageQueue, "Receiver 2"));
        receiverPool.submit(new MessageReceiver(messageQueue, "Receiver 3"));

        // Shutdown the thread pools after all tasks are completed
        senderPool.shutdown();
        receiverPool.shutdown();
    }
}

