package ru.yandex.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    private final float bunPrice;
    private final float meatPrice;

    public BurgerParameterizedTest(float bunPrice, float meatPrice) {
        this.bunPrice = bunPrice;
        this.meatPrice = meatPrice;
    }

    @Parameterized.Parameters(name = "Test data: {0} {1}")
    public static Object[][] getTestData() {

        return new Object[][] {
                {20f, 51f},
                {19.5f, 50.5f},
                {19.57f, 50.54f}
        };
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(meatPrice);
        float expectedPrice = 2 * bunPrice + meatPrice;
        assertEquals("The burger should have a stub price", expectedPrice, burger.getPrice(), 0);
    }
}
