package org.example;

import org.example.Passenger;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayDeque;

public class TicketReservation {
    private static final int DEFAULT_MAX_CONFIRMED_LIST_SIZE;
    private static final int DEFAULT_MAX_WAITING_LIST_SIZE;

    static {
        DEFAULT_MAX_CONFIRMED_LIST_SIZE = 10;
        DEFAULT_MAX_WAITING_LIST_SIZE = 3;
    }

    private final int maxConfirmedListSize;
    private final int maxWaitingListSize;

    private final List<Passenger> confirmedPassengers = new ArrayList<>();
    private final Deque<Passenger> waitingPassengers = new ArrayDeque<>();

    public TicketReservation() {
        this(DEFAULT_MAX_CONFIRMED_LIST_SIZE, DEFAULT_MAX_WAITING_LIST_SIZE);
    }

    public TicketReservation(int maxConfirmedListSize, int maxWaitingListSize) {
        this.maxConfirmedListSize = maxConfirmedListSize;
        this.maxWaitingListSize = maxWaitingListSize;
    }

    public boolean reserveFlight(String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        try {
            Passenger passenger = new Passenger(firstName, lastName, age, gender, travelClass, confirmationNumber);

            if (confirmedPassengers.size() < maxConfirmedListSize) {
                confirmedPassengers.add(passenger);
                return true;
            } else if (waitingPassengers.size() < maxWaitingListSize) {
                waitingPassengers.offer(passenger);
                return true;
            } else {
                return false; // Both confirmed and waiting lists are full
            }
        } catch (Exception e) {
            System.err.println("Error reserving flight: " + e.getMessage());
            return false; // Error occurred during reservation
        }
    }

    public boolean cancelFlight(String confirmationNumber) {
        try {
            Iterator<Passenger> confirmedIterator = confirmedPassengers.iterator();
            if (removePassenger(confirmedIterator, confirmationNumber)) {
                if (!waitingPassengers.isEmpty()) {
                    confirmedPassengers.add(waitingPassengers.poll());
                }
                return true; // Flight canceled successfully
            }

            Iterator<Passenger> waitingIterator = waitingPassengers.iterator();
            return removePassenger(waitingIterator, confirmationNumber);
        } catch (Exception e) {
            System.err.println("Error canceling flight: " + e.getMessage());
            return false; // Error occurred during cancellation
        }
    }

    private boolean removePassenger(Iterator<Passenger> iterator, String confirmationNumber) {
        while (iterator.hasNext()) {
            Passenger passenger = iterator.next();
            if (passenger.getConfirmationNumber().equals(confirmationNumber)) {
                iterator.remove();
                return true;
            }
        }
        return false; // Passenger not found
    }

    public List<Passenger> getConfirmedPassengers() {
        return new ArrayList<>(confirmedPassengers);
    }

    public Deque<Passenger> getWaitingPassengers() {
        return new ArrayDeque<>(waitingPassengers);
    }

    public int getMaxConfirmedListSize() {
        return maxConfirmedListSize;
    }

    public int getMaxWaitingListSize() {
        return maxWaitingListSize;
    }

    public static void main(String[] args) {
        TicketReservation reservationSystem = new TicketReservation();

        // Reserve some flights
        System.out.println("Reserving flights...");
        reservationSystem.reserveFlight("Ashish", "Raj", 22, "Male", "Business", "C001");
        reservationSystem.reserveFlight("Rishabh", "Gupta", 22, "Male", "Economy", "C002");
        reservationSystem.reserveFlight("Sindhu", "Sharma", 25, "Female", "Economy", "C003");
        reservationSystem.reserveFlight("Rajat", "Paliwal", 26, "Male", "Business", "C004");
        reservationSystem.reserveFlight("Satyam", "Gupta", 22, "Male", "Economy", "C005");
        reservationSystem.reserveFlight("Abhishek", "Aman", 27, "Male", "Business", "C006");

        // Cancel a flight
        System.out.println("\nCancelling a flight...");
        reservationSystem.cancelFlight("C002");

        // Reserve another flight
        System.out.println("\nReserving another flight...");
        reservationSystem.reserveFlight("Frank", "Wilson", 45, "Male", "Economy", "C007");

        // Display confirmed and waiting lists
        System.out.println("\nConfirmed Passengers:");
        for (Passenger passenger : reservationSystem.getConfirmedPassengers()) {
            System.out.println(passenger);
        }
        System.out.println("\nWaiting Passengers:");
        for (Passenger passenger : reservationSystem.getWaitingPassengers()) {
            System.out.println(passenger);
        }
    }
}
