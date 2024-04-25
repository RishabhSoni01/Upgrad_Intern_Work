package org.example.Question2;


class MessageReceiver implements Runnable {
    private MessageQueue queue;

    public MessageReceiver(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = queue.getMessage();
                System.out.println("Received: " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}