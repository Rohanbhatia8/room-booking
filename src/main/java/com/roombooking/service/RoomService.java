package com.roombooking.service;

import com.roombooking.dto.CreateRoomRequestResponse;
import com.roombooking.model.Room;
import com.roombooking.dao.RoomRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepo roomRepository;

    public RoomService(RoomRepo roomRepository) {
        this.roomRepository = roomRepository;
    }


    public List<Room> getAllRooms() {
        return (List<Room>) roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Long roomId) {
        return roomRepository.findById(Math.toIntExact(roomId));
    }

    public CreateRoomRequestResponse createRoom(CreateRoomRequestResponse createRoomRequest) {
        Room room = new Room();
        room.setName(createRoomRequest.getName());
        room.setCapacity(createRoomRequest.getCapacity());
        room.setDescription(createRoomRequest.getDescription());
        Room saved = roomRepository.save(room);
        createRoomRequest.setId(saved.getId());
        return createRoomRequest;
    }

    public Optional<Room> updateRoom(Long roomId, Room updatedRoom) {
        if (!roomRepository.existsById(Math.toIntExact(roomId))) {
            return Optional.empty(); // Room not found
        }
        updatedRoom.setId(roomId);
        return Optional.of(roomRepository.save(updatedRoom));
    }

    public boolean deleteRoom(Long roomId) {
        if (roomRepository.existsById(Math.toIntExact(roomId))) {
            roomRepository.deleteById(Math.toIntExact(roomId));
            return true;
        }
        return false; // Room not found
    }

    public List<Room> findAvailableRooms(LocalDateTime startTime, LocalDateTime endTime) {
        // Implement logic to find available rooms for a given time range
        // You can use the RoomRepository to query the database
        // ...
        return null; // Placeholder, replace with actual implementation
    }

    public boolean isRoomAvailable(Room room, LocalDateTime startTime, LocalDateTime endTime) {
        // Implement logic to check if a room is available for a given time range
        // You can use the BookingRepository to query existing bookings
        // ...
        return true; // Placeholder, replace with actual implementation
    }

    public Room findById(Object roomId) {
        return null;
    }
}

