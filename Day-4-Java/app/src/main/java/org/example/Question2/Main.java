package org.example.Question2;

public class Main {
    public static void main(String[] args) {
        TicketReservation ticketReservation = new TicketReservation();

        System.out.println("Booking flights...");
        bookFlight(ticketReservation, "John", "Doe", 30, "Male", "economy", "C001");
        bookFlight(ticketReservation, "Jane", "Smith", 25, "Female", "business", "C002");
        bookFlight(ticketReservation, "Alice", "Johnson", 40, "Female", "economy", "C003");
        bookFlight(ticketReservation, "Bob", "Brown", 50, "Male", "economy", "C004");
        bookFlight(ticketReservation, "Charlie", "Davis", 35, "Male", "business", "C005");
        bookFlight(ticketReservation, "Eva", "Wilson", 27, "Female", "economy", "C006");
        bookFlight(ticketReservation, "Frank", "Miller", 45, "Male", "economy", "C007");
        bookFlight(ticketReservation, "Grace", "Taylor", 33, "Female", "economy", "C008");
        bookFlight(ticketReservation, "Henry", "Anderson", 28, "Male", "economy", "C009");
        bookFlight(ticketReservation, "Ivy", "Clark", 38, "Female", "economy", "C010");
        bookFlight(ticketReservation, "Zoe", "Roberts", 55, "Female", "economy", "C011");
        System.out.println();

        System.out.println("Current reservations:");
        displayReservations(ticketReservation);
        System.out.println();

        System.out.println("Canceling flight with confirmation number C005...");
        ticketReservation.cancel("C005");
        System.out.println();

        System.out.println("Updated reservations:");
        displayReservations(ticketReservation);
    }

    private static void bookFlight(TicketReservation ticketReservation, String firstName, String lastName, int age, String gender, String travelClass, String confirmationNumber) {
        boolean booked = ticketReservation.bookFlight(firstName, lastName, age, gender, travelClass, confirmationNumber);
        if (booked) {
            System.out.println("Flight booked successfully for " + firstName + " " + lastName + ", Confirmation Number: " + confirmationNumber);
        } else {
            System.out.println("Booking failed for " + firstName + " " + lastName + ", Confirmation Number: " + confirmationNumber);
        }
    }

    private static void displayReservations(TicketReservation ticketReservation) {
        System.out.println("Confirmed List:");
        for (Passenger passenger : ticketReservation.getConfirmedList()) {
            System.out.println(passenger);
        }
        System.out.println("Waiting List:");
        for (Passenger passenger : ticketReservation.getWaitingList()) {
            System.out.println(passenger);
        }
    }
}

