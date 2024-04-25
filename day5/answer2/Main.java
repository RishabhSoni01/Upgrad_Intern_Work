package org.example.answer2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Queue;
import java.util.LinkedList;

class MessageQueue {
    private Queue<String> messages = new LinkedList<>();

    public synchronized void addMessage(String message) {
        messages.add(message);
        notifyAll();
    }

    public synchronized String getMessage() throws InterruptedException {
        while (messages.isEmpty()) {
            wait();
        }
        return messages.poll();
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
        for (int i = 1; i < 3; i++) {
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
        ExecutorService senderThreadPool = Executors.newFixedThreadPool(3);
        ExecutorService receiverThreadPool = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 3; i++) {
            senderThreadPool.execute(new MessageSender(messageQueue, "messageSender" + i));
        }

        for (int i = 1; i <= 3; i++) {
            receiverThreadPool.execute(new MessageReceiver(messageQueue, "messageReceiver" + i));
        }

      
        senderThreadPool.shutdown();
        receiverThreadPool.shutdown();
    }
}

