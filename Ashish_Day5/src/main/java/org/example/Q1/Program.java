package org.example;

import java.util.*;
import java.util.concurrent.Semaphore;

class MessageQueue {
    private final Queue<String> messages;
    private final Object queueLock = new Object();

    public MessageQueue() {
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

class MessageSender {
    private final MessageQueue queue;

    public MessageSender(MessageQueue queue) {
        this.queue = queue;
    }

    public void sendMessage(String message) {
        queue.addMessage(message);
    }
}

class MessageReceiver {
    private final MessageQueue queue;
    private final Set<String> printedMessages = Collections.synchronizedSet(new HashSet<>());
    private final Semaphore semaphore;

    public MessageReceiver(MessageQueue queue, Semaphore semaphore) {
        this.queue = queue;
        this.semaphore = semaphore;
    }

    public void printMessage() {
        try {
            semaphore.acquire();
            String message = queue.getMessage();
            if (message != null && printedMessages.add(message)) {
                System.out.println(message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

public class Program {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();
        Semaphore semaphore = new Semaphore(1); // Semaphore with 1 permit

        List<Thread> senders = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            final int index = i; // Make a copy of the variable i
            senders.add(new Thread(() -> sendMessages(queue, "Sender " + index)));
        }

        List<Thread> receivers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            receivers.add(new Thread(() -> receiveMessages(queue, semaphore)));
        }

        senders.forEach(Thread::start);
        receivers.forEach(Thread::start);

        senders.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        receivers.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    private static void sendMessages(MessageQueue queue, String senderName) {
        for (int i = 0; i < 7; i++) {
            queue.addMessage(senderName + " - Message " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void receiveMessages(MessageQueue queue, Semaphore semaphore) {
        MessageReceiver receiver = new MessageReceiver(queue, semaphore);
        while (true) {
            receiver.printMessage();
            try {
                Thread.sleep(100); // Sleep for a short time to avoid busy waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
