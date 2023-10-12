package com.roombooking;

import com.roombooking.model.Booking;
import com.roombooking.model.Room;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomBookingSystem {
    private List<Room> rooms;
    private List<Booking> bookings;
    private List<Customer> customers;

    public RoomBookingSystem(int numRooms) {
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        customers = new ArrayList<>();


        for (int i = 1; i <= numRooms; i++) {
            rooms.add(new Room());
        }
    }

    public boolean bookRoom(Customer customer, Room room, Date startDate, Date endDate) {
//        for (Room r : rooms) {
//            if ((room.getName() = room.getName()) && !r.isBooked()) {
//                Booking booking = new Booking();
//                bookings.add(booking);
//                room.book();
//                return true;
//            }
//        }
        return false;
    }

    public void printBookings() {
        for (Booking booking : bookings) {
            System.out.println("Booking ID: " + booking.hashCode());
            System.out.println("Customer: " + booking.getCustomer().getName());

            System.out.println("Start Date: " + booking.getStartDate());
            System.out.println("End Date: " + booking.getEndDate());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RoomBookingSystem bookingSystem = new RoomBookingSystem(5); // Create a system with 5 rooms


        Customer customer1 = new Customer(1, "Alice");
        Customer customer2 = new Customer(2, "Bob");


        bookingSystem.bookRoom(customer1, bookingSystem.rooms.get(0), new Date(), new Date());
        bookingSystem.bookRoom(customer2, bookingSystem.rooms.get(1), new Date(), new Date());


        bookingSystem.printBookings();
    }
}

