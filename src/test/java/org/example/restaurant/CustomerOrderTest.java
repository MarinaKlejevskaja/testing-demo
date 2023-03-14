package org.example.restaurant;

import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerOrderTest {

    @Mock
    BreakfastWaiter breakfastWaiter;
    @Mock
    DinnerWaiter dinnerWaiter;
    @InjectMocks
    CustomerOrder customerOrder;


   @Test
   public void vegetarianBreakfast_shouldReturnCorrectMenu_whenCalled() {
        when(breakfastWaiter.getVegetarianMenu()).thenReturn(Arrays.asList("Apple", "Beans", "Hash brown", "Toast"));
        List<String> actual = customerOrder.vegetarianBreakfast();
        List<String> expected = Arrays.asList("Apple", "Beans", "Hash brown", "Toast");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void meatBreakfast_shouldReturnCorrectMenu_whenCalled() {
        when(breakfastWaiter.getMeatMenu()).thenReturn(Arrays.asList("Apple", "Sausages", "Bacon", "Toast"));
        List<String> actual = customerOrder.meatBreakfast();
        List<String> expected = Arrays.asList("Apple", "Sausages", "Bacon", "Toast");
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void vegetarianDinner_shouldReturnCorrectMenu_whenCalled() {
        when(dinnerWaiter.getVegetarianMenu()).thenReturn(Arrays.asList("Garlic bread", "Vegetable Lasagne", "Chocolate Brownie"));
        List<String> actual = customerOrder.vegetarianDinner();
        List<String> expected = Arrays.asList("Garlic bread", "Vegetable Lasagne", "Chocolate Brownie");
        assertThat(actual).isEqualTo(expected);
    }
    @Test
    public void meatDinner_shouldReturnCorrectMenu_whenCalled() {
        when(dinnerWaiter.getMeatMenu()).thenReturn(Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding"));
        List<String> actual = customerOrder.meatDinner();
        List<String> expected = Arrays.asList("Calamari", "Roast Chicken", "Sticky toffee pudding");
        assertThat(actual).isEqualTo(expected);
    }
}