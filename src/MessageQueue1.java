import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue1 {
    private BlockingQueue<String> messages = new LinkedBlockingQueue<>();

    public void addMessage(String message) {
        messages.add(message);
    }

    public String getMessage() throws InterruptedException {
        return messages.take();
    }

}
