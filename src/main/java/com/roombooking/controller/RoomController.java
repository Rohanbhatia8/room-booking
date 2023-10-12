package com.roombooking.controller;

import com.roombooking.model.Booking;
import com.roombooking.dto.CreateRoomRequestResponse;
import com.roombooking.model.Room;
import com.roombooking.service.BookingService;
import com.roombooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingService bookingService;


    // Endpoint to get all available rooms for a given date and time range
    @GetMapping("/test")
    public ResponseEntity<String> getAvailableRooms() {

        return new ResponseEntity<>("UP", HttpStatus.OK);
    }

    // Endpoint to get all available rooms for a given date and time range
    @GetMapping("/available")
    public ResponseEntity<List<Room>> getAvailableRooms(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime) {

        List<Room> availableRooms = roomService.findAvailableRooms(startTime, endTime);

        return new ResponseEntity<>(availableRooms, HttpStatus.OK);
    }
    // Endpoint to book a room
    @PostMapping("/create")
    public ResponseEntity<CreateRoomRequestResponse> createRoom(@RequestBody CreateRoomRequestResponse createRoomRequest) {
        CreateRoomRequestResponse room = roomService.createRoom(createRoomRequest);
        return new ResponseEntity<>(room, HttpStatus.OK);

    }
    // Endpoint to book a room
    @PostMapping("/book")
    public ResponseEntity<String> bookRoom(@RequestBody BookingRequest bookingRequest) {
        Room room = roomService.findById(bookingRequest.getRoomId());

        if (room == null) {
            return new ResponseEntity<>("Room not found", HttpStatus.NOT_FOUND);
        }

        LocalDateTime startTime = bookingRequest.getstartTime();
        LocalDateTime endTime = bookingRequest.getendTime();

        // Check if the room is available for the requested time range
        if (!roomService.isRoomAvailable(room, startTime, endTime)) {
            return new ResponseEntity<>("Room is not available for the requested time range", HttpStatus.CONFLICT);
        }

        // Create a booking
        Booking booking = new Booking();
        booking.setRoom(room);
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);

      //  bookingService.createBooking(booking);

        return new ResponseEntity<>("Room booked successfully", HttpStatus.CREATED);
    }
}
