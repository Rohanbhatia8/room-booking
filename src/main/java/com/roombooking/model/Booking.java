package com.roombooking.model;

import com.roombooking.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

   // @ManyToOne
   // @JoinColumn(name = "customer_id")
   // private Customer customer;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    public void setRoom(Room room) {

    }

    public void setStartTime(LocalDateTime startTime) {

    }

    public void setEndTime(LocalDateTime endTime) {

    }

    public Customer getCustomer() {
        return null;
    }

    public String getStartDate() {
        return null;
    }

    public String getEndDate() {
        return null;
    }

    // Constructors, getters, and setters

    // Other attributes and methods
}

