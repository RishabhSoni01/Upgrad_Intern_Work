//import org.example.MessageQueue;
//
package org.example;
////import org.example.MessageQueue;
//////TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
////// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
////public class Main {
////    public static void main(String args[]) {
////        MessageQueue messageQueue=new MessageQueue();
////        Thread messageSender1=new Thread(new MessageSender(messageQueue,"messageSender1"));
////        Thread messageSender2=new Thread(new MessageSender(messageQueue,"messageSender2"));
////        Thread messageSender3=new Thread(new MessageSender(messageQueue,"messageSender3"));
////
////        messageSender1.start();
////        messageSender2.start();
////        messageSender3.start();
////
////        Thread messageReceiver1=new Thread(new MessageReceiver(messageQueue,"messageReceiver1"));
////        Thread messageReceiver2=new Thread(new MessageReceiver(messageQueue,"messageReceiver2"));
////        Thread messageReceiver3=new Thread(new MessageReceiver(messageQueue,"messageReceiver3"));
////
////        messageReceiver1.start();
////        messageReceiver2.start();
////        messageReceiver3.start();
////    }
////}
//public class Main {
//    public static void main(String[] args) {
//        MessageQueue messageQueue = new MessageQueue();
//
//        // Create and start 3 MessageSenders
//        Thread sender1 = new Thread(new MessageSender(messageQueue, "Sender 1"));
//        Thread sender2 = new Thread(new MessageSender(messageQueue, "Sender 2"));
//        Thread sender3 = new Thread(new MessageSender(messageQueue, "Sender 3"));
//        sender1.start();
//        sender2.start();
//        sender3.start();
//
//        // Create and start 3 MessageReceivers
//        Thread receiver1 = new Thread(new MessageReceiver(messageQueue, "Receiver 1"));
//        Thread receiver2 = new Thread(new MessageReceiver(messageQueue, "Receiver 2"));
//        Thread receiver3 = new Thread(new MessageReceiver(messageQueue, "Receiver 3"));
//        receiver1.start();
//        receiver2.start();
//        receiver3.start();
//    }
//}
