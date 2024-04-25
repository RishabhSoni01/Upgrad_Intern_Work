import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int number = 10;

        FactorialThread factorialThread = new FactorialThread(number);
        FactorsThread factorsThread = new FactorsThread(number);

        factorialThread.start();
        factorsThread.start();

        try {
            factorialThread.join();
            factorsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread finished.");



    MessageQueue messageQueue = new MessageQueue();

    ExecutorService senderPool = Executors.newFixedThreadPool(3);
    ExecutorService receiverPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 3; i++) {
        senderPool.submit(new MessageSender(messageQueue, "Sender-" + i));
    }

        for (int i = 0; i < 3; i++) {
        receiverPool.submit(new MessageReceiver(messageQueue, "Receiver-" + i));
    }

        senderPool.shutdown();
        receiverPool.shutdown();

    }


}

class FactorialThread extends Thread {
    private int number;
    private long factorial;

    public FactorialThread(int number) {
        this.number = number;
        this.factorial = 1;
    }

    public void run() {
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}

class FactorsThread extends Thread {
    private int number;

    public FactorsThread(int number) {
        this.number = number;
    }

    public void run() {
        System.out.print("Factors of " + number + " are: ");
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}