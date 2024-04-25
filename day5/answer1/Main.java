package org.example.answer1;

import java.util.LinkedList;
import java.util.Queue;


class MessageQueue {
    private Queue<String> messages = new LinkedList<>();

    public synchronized void addMessage(String message){
        messages.add(message);
        notifyAll();
    }

    public synchronized String getMessage() throws InterruptedException {
        while (messages.isEmpty()) {
            wait();
        }
        return messages.poll();
    }
}

class MessageSender implements Runnable{
    private MessageQueue messageQueue;
    private String SenderName;

    public MessageSender(MessageQueue messageQueue,String SenderName){
        this.messageQueue=messageQueue;
        this.SenderName=SenderName;
    }

    @Override
    public void run(){
        for (int i = 1; i < 3; i++) {
            String message = "Message from " + SenderName + ": " + i;
            messageQueue.addMessage(message);
            System.out.println(SenderName + " sent: " + message);
            try {
                Thread.sleep(100); // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MessageReceiver implements Runnable{
    private MessageQueue messageQueue;
    private String ReceiverName;

    public MessageReceiver(MessageQueue messageQueue,String ReceiverName){
        this.messageQueue=messageQueue;
        this.ReceiverName=ReceiverName;
    }
    @Override
    public void run(){
        while(true){
            try{
                String message=messageQueue.getMessage();
                System.out.println(ReceiverName+" received"+ message);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}

public class Main {
    public static void main(String args[]) {
        MessageQueue messageQueue=new MessageQueue();
        Thread messageSender1=new Thread(new MessageSender(messageQueue,"messageSender1"));
        Thread messageSender2=new Thread(new MessageSender(messageQueue,"messageSender2"));
        Thread messageSender3=new Thread(new MessageSender(messageQueue,"messageSender3"));

        messageSender1.start();
        messageSender2.start();
        messageSender3.start();

        Thread messageReceiver1=new Thread(new MessageReceiver(messageQueue,"messageReceiver1"));
        Thread messageReceiver2=new Thread(new MessageReceiver(messageQueue,"messageReceiver2"));
        Thread messageReceiver3=new Thread(new MessageReceiver(messageQueue,"messageReceiver3"));

        messageReceiver1.start();
        messageReceiver2.start();
        messageReceiver3.start();
    }
}