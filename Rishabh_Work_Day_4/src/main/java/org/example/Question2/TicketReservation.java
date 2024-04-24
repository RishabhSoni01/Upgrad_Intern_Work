package org.example.Question2;

import org.example.Question2.Passenger;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayDeque;

public class TicketReservation {
    private static final int CONFIRMEDLIST_LIMIT = 10;
    private static final int WAITINGLIST_LIMIT = 3;

    private List<Passenger> confirmedList = new ArrayList<>();
    private Deque<Passenger> waitingList = new ArrayDeque<>();

    public boolean bookFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        if (confirmedList.size() < CONFIRMEDLIST_LIMIT) {
            Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);
            confirmedList.add(passenger);
            return true;
        } else if (waitingList.size() < WAITINGLIST_LIMIT) {
            Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);
            waitingList.offer(passenger);
            return true;
        } else {
            return false; // Both confirmedList and waitingList are full
        }
    }

    public boolean cancel(String confirmationNumber) {
        // Remove the passenger from confirmedList or waitingList
        boolean removed = removePassenger(confirmedList.iterator(), confirmationNumber);
        if (!removed) {
            removed = removePassenger(waitingList.iterator(), confirmationNumber);
        }

        // If passenger was removed from confirmedList, move the first passenger from waitingList to confirmedList
        if (removed && confirmedList.size() < CONFIRMEDLIST_LIMIT && !waitingList.isEmpty()) {
            confirmedList.add(waitingList.poll());
        }

        return removed;
    }

    public boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while (iterator.hasNext()) {
            Passenger passenger = iterator.next();
            if (passenger.getConfirmationNumber().equals(confirmationNumber)) {
                iterator.remove();
                return true;
            }
        }
        return false; // Passenger not found
    }
}
