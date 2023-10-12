package com.roombooking.service;

import org.springframework.stereotype.Service;

@Service
public class BookingService {
//    private final BookingRepository bookingRepository;
//
//    @Autowired
//    public BookingService(BookingRepository bookingRepository) {
//        this.bookingRepository = bookingRepository;
//    }
//
//    public List<Booking> getAllBookings() {
//        return bookingRepository.findAll();
//    }
//
//    public Optional<Booking> getBookingById(Long bookingId) {
//        return bookingRepository.findById(bookingId);
//    }
//
//    public Booking createBooking(Booking booking) {
//        return bookingRepository.save(booking);
//    }
//
//    public Optional<Booking> updateBooking(Long bookingId, Booking updatedBooking) {
//        if (!bookingRepository.existsById(bookingId)) {
//            return Optional.empty(); // Booking not found
//        }
//        updatedBooking.setId(bookingId);
//        return Optional.of(bookingRepository.save(updatedBooking));
//    }
//
//    public boolean deleteBooking(Long bookingId) {
//        if (bookingRepository.existsById(bookingId)) {
//            bookingRepository.deleteById(bookingId);
//            return true;
//        }
//        return false; // Booking not found
//    }
}

