import java.util.ArrayList;
import java.util.List;

public class MessageQueue {
    private List<String> messages = new ArrayList<>();

    public synchronized void addMessage(String message) {
        messages.add(message);
        notifyAll();
    }

    public synchronized String getMessage() throws InterruptedException {
        while (messages.isEmpty()) {
            wait();
        }
        return messages.remove(0);
    }
}
