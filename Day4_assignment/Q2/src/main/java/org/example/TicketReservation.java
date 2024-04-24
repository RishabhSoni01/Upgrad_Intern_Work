package org.example;


import java.util.*;


public class TicketReservation {
    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
           Passenger p =new Passenger(firstName,lastName,age,gender,travelClass,confirmationNumber);
           if(confirmedList.size()<CONFIRMEDLIST_LIMIT){
               confirmedList.add(p);
               return true;
           }else if(waitingList.size()<WAITINGLIST_LIMIT){
               waitingList.addLast(p);
               return true;
           }
           return false;
    }

    public boolean cancel(String confirmationNumber) {

        for(Passenger p:confirmedList){
            if(Objects.equals(p.confirmationNumber, confirmationNumber)){
                int index = confirmedList.indexOf(p);
                Iterator<Passenger> iterator = confirmedList.listIterator(index);
                removePassenger(iterator,confirmationNumber);
                if(waitingList.size()>0){
                    confirmedList.add(waitingList.getFirst());
                    waitingList.pollFirst();
                }
                return true;
            }
        }

        for(Passenger p:waitingList){
            if(Objects.equals(p.confirmationNumber, confirmationNumber)){

                Iterator<Passenger> iterator = waitingList.descendingIterator();
                removePassenger(iterator,confirmationNumber);
                return true;
            }
        }

        return false;
    }

    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {


           while (iterator.hasNext()){
               if(Objects.equals(iterator.next().confirmationNumber, confirmationNumber)){
                   iterator.remove();
                   return true;
               }
           }
           return false;
    }

public static void main(String args[]){

}
}
