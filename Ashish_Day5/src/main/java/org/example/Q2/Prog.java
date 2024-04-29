package org.example.Q2;

import java.util.*;
import java.util.concurrent.*;

class MessageQ {
    private final Queue<String> messages;
    private final Object queueLock = new Object();

    public MessageQ() {
        messages = new LinkedList<>();
    }

    public void addMessage(String message) {
        synchronized (queueLock) {
            messages.add(message);
        }
    }

    public String getMessage() {
        synchronized (queueLock) {
            if (messages.isEmpty()) {
                return null;
            }
            return messages.poll();
        }
    }
}

class MessageSend implements Callable<Void> {
    private final MessageQueue queue;
    private final String senderName;

    public MessageSend(MessageQueue queue, String senderName) {
        this.queue = queue;
        this.senderName = senderName;
    }

    @Override
    public Void call() {
        for (int i = 0; i < 10; i++) {
            queue.addMessage(senderName + " - Message " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

class MessageReceive implements Callable<Void> {
    private final MessageQueue queue;
    private final Set<String> printedMessages = Collections.synchronizedSet(new HashSet<>());

    public MessageReceive(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public Void call() {
        while (true) {
            String message = queue.getMessage();
            if (message != null && printedMessages.add(message)) {
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
    public static void main(String[] args) throws InterruptedException {
        MessageQueue queue = new MessageQueue();

        ExecutorService senderPool = Executors.newFixedThreadPool(3);
        ExecutorService receiverPool = Executors.newFixedThreadPool(3);

        List<Future<Void>> senderFutures = new ArrayList<>();
        List<Future<Void>> receiverFutures = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            senderFutures.add(senderPool.submit(new MessageSend(queue, "Sender " + i)));
        }

        for (int i = 0; i < 3; i++) {
            receiverFutures.add(receiverPool.submit(new MessageReceive(queue)));
        }

        senderPool.shutdown();
        receiverPool.shutdown();

        senderFutures.forEach(t -> {
            try {
                t.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        receiverFutures.forEach(t -> {
            try {
                t.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }
}
