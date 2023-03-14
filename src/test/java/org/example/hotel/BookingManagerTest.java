package org.example.hotel;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookingManagerTest {

    @Mock
    Hotel hotel;
    @InjectMocks
    BookingManager bookingManager;

    @Test
    void checkRoomAvailability_shouldReturnTrue_whenRoomIsAvailable() {
        mockAvailableRoomsList();
        boolean actual = bookingManager.checkRoomAvailability("A");
        assertThat(actual).isTrue();
    }

    @Test
    void checkRoomAvailability_shouldReturnFalse_whenRoomIsNotInTheList() {
        mockAvailableRoomsList();
        boolean actual = bookingManager.checkRoomAvailability("B");
        assertThat(actual).isFalse();
    }

    @Test
    void checkRoomAvailability_shouldReturnFalse_whenNoAvailableRooms() {
        mockEmptyRoomsList();
        boolean actual = bookingManager.checkRoomAvailability("B");
        assertThat(actual).isFalse();
    }

    @Test
    void checkRoomAvailability_shouldBeCaseInsensitive() {
        mockAvailableRoomsList();
        boolean actual = bookingManager.checkRoomAvailability("a");
        assertThat(actual).isTrue();
    }


    @Test
    void checkRoomAvailability_shouldReturnFalse_whenHotelNotSet() {
        boolean actual = bookingManager.checkRoomAvailability("A");
        assertThat(actual).isFalse();
    }

    public void mockAvailableRoomsList() {
        when(hotel.fetchAvailableRooms()).thenReturn(Arrays.asList("A", "C"));
    }

    public void mockEmptyRoomsList() {
        when(hotel.fetchAvailableRooms()).thenReturn(Arrays.asList());
    }
}