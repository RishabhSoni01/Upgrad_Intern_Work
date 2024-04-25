public class MessageReceiver1 implements Runnable{
    private MessageQueue queue;
    private String name;

    public MessageReceiver1(MessageQueue queue, String name) {
        this.queue = queue;
        this.name = name;
    }

    public void run() {
        try {
            while (true) {
                String message = queue.getMessage();
                System.out.println(name + " received: " + message);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
