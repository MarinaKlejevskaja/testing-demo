package org.example.hotel;

import java.util.List;

public class BookingManager {

    private final Hotel hotel;

    public BookingManager(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean checkRoomAvailability(String roomName) {

        if (roomName == null || roomName.trim().isEmpty()) {
            return false;
        }

        List<String> roomsAvailable = hotel.fetchAvailableRooms();
        for (String room : roomsAvailable) {
            if (room.equalsIgnoreCase(roomName)) {
                return true;
            }
        }
        return false;
    }
}