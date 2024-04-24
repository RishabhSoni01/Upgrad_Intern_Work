package org.example.Question2;
import org.example.Question2.Passenger;
import java.util.*;

public class TicketReservation {
    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);

        if (confirmedList.size() < CONFIRMEDLIST_LIMIT) {
            confirmedList.add(passenger);
            return true;
        } else if (waitingList.size() < WAITINGLIST_LIMIT) {
            waitingList.offerLast(passenger);
            return true;
        } else {
            return false;
        }
    }

    public boolean cancel(String confirmationNumber) {
        Iterator<Passenger> confirmedIterator = confirmedList.iterator();
        if (removePassenger(confirmedIterator, confirmationNumber)) {
            if (!waitingList.isEmpty()) {
                confirmedList.add(waitingList.pollFirst());
            }
            return true;
        }

        Iterator<Passenger> waitingIterator = waitingList.iterator();
        return removePassenger(waitingIterator, confirmationNumber);
    }

    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while (iterator.hasNext()) {
            Passenger passenger = iterator.next();
            if (passenger.getConfirmationNumber().equals(confirmationNumber)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    public List<Passenger> getConfirmedList() {
        return confirmedList;
    }

    public Deque<Passenger> getWaitingList() {
        return waitingList;
    }
}
