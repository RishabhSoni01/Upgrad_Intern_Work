

public class MessageReceiver extends Thread {
    private MessageQueue queue;
    private String name;

    public MessageReceiver(MessageQueue queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    public void run() {
        while (true) {
            try {
                String message = queue.getMessage();
                System.out.println(name + " received: " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

