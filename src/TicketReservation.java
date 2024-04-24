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
            waitingList.add(passenger);
            return true;
        } else {
            return false; // Both confirmedList and waitingList are full
        }
    }

    public boolean cancel(String confirmationNumber) {
        Iterator<Passenger> confirmedIterator = confirmedList.iterator();
        Iterator<Passenger> waitingIterator = waitingList.iterator();

        if (removePassenger(confirmedIterator, confirmationNumber)) {
            if (!waitingList.isEmpty()) {
                confirmedList.add(waitingList.pollFirst());
            }
            return true;
        } else if (removePassenger(waitingIterator, confirmationNumber)) {
            return true;
        } else {
            return false; // Passenger with given confirmation number not found
        }
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
}
