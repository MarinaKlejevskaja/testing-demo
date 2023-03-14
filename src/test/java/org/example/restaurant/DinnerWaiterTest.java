package org.example.restaurant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class DinnerWaiterTest {


    @InjectMocks
    DinnerWaiter dinnerWaiter;

    @Test
    public void getMeatMenu_shouldReturnCorrectMenu_whenCalled() {
        List<String> actual = dinnerWaiter.getMeatMenu();
        List<String> expected = Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getVegetarianMenu_shouldReturnCorrectMenu_whenCalled() {
        List<String> actual = dinnerWaiter.getVegetarianMenu();
        List<String> expected = Arrays.asList("Garlic bread", "Vegetable Lasagne", "Chocolate Brownie");
        assertThat(actual).isEqualTo(expected);
    }
}