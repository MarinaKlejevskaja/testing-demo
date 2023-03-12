package org.example.hotel;

import java.util.List;

public class BookingManager {

    private final Hotel hotel;

    public BookingManager(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean checkRoomAvailability(String roomName) {

        List<String> roomsAvailable = hotel.fetchAvailableRooms();
        return roomsAvailable.contains(roomName);
    }

}