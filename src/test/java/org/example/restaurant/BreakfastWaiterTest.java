package org.example.restaurant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BreakfastWaiterTest {

    @InjectMocks
    BreakfastWaiter breakfastWaiter;

    @Test
    public void getMeatMenu_shouldReturnCorrectMenu_whenCalled() {
        List<String> actual = breakfastWaiter.getMeatMenu();
        List<String> expected = Arrays.asList("Apple", "Sausages", "Bacon", "Toast");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getVegetarianMenu_shouldReturnCorrectMenu_whenCalled() {
        List<String> actual = breakfastWaiter.getVegetarianMenu();
        List<String> expected = Arrays.asList("Apple", "Beans", "Hash brown", "Toast");
        assertThat(actual).isEqualTo(expected);
    }
}