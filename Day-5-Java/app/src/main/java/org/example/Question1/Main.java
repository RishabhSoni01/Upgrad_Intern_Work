package org.example.Question1;

public class Main {
    public static void main(String[] args) {
        MessageQueue queue = new MessageQueue();

        for (int i = 0; i < 3; i++) {
            Thread senderThread = new Thread(new MessageSender(queue));
            senderThread.start();
        }

        for (int i = 0; i < 3; i++) {
            Thread receiverThread = new Thread(new MessageReceiver(queue));
            receiverThread.start();
        }
    }
}