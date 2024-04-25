package org.example.Question1;

class MessageSender implements Runnable {
    private MessageQueue queue;

    public MessageSender(MessageQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String message = "Message " + Thread.currentThread().getId() + "-" + i;
            queue.addMessage(message);
            System.out.println("Sent: " + message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
