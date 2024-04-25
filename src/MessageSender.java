
class MessageSender extends Thread {
    private MessageQueue queue;
    private String name;

    public MessageSender(MessageQueue queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            String message = "Message from " + name + ": " + i;
            queue.addMessage(message);
            System.out.println(name + " sent: " + message);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}