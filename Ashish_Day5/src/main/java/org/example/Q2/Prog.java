package org.example.Q2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Queue;
import java.util.LinkedList;



class Sender implements Runnable {
    private final MessageQueue queue;
    private final String senderName;

    public Sender(MessageQueue queue, String senderName) {
        this.queue = queue;
        this.senderName = senderName;
    }



    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            queue.addMessage(senderName + " - Message " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Receiver implements Runnable {
    private final MessageQueue queue;

    public Receiver(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            String message = queue.getMessage();
            if (message != null) {
                System.out.println(message);
            }
            try {
                Thread.sleep(100); // Sleep for a short time to avoid busy waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Prog {
    public static void main(String[] args) {


        MessageQueue queue = new MessageQueue();
        ExecutorService senderExecutor = Executors.newFixedThreadPool(3);
        ExecutorService receiverExecutor = Executors.newFixedThreadPool(3);

        // Create and submit sender threads
        for (int i = 0; i < 3; i++) {
            senderExecutor.submit(new Sender(queue, "Sender " + i));
        }

        // Create and submit receiver threads
        for (int i = 0; i < 3; i++) {
            receiverExecutor.submit(new Receiver(queue));
        }

        // Shutdown the executors
        senderExecutor.shutdown();
        receiverExecutor.shutdown();
    }
}