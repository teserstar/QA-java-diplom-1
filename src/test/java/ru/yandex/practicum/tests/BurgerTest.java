package ru.yandex.practicum.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void addIngredientCallsWithCorrectParameter() {
        burger.addIngredient(ingredient);
        Mockito.verify(burger).addIngredient(ingredient);
    }

    @Test
    public void addIngredientCallsMultipleTimesWithParameter() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.verify(burger, Mockito.times(2)).addIngredient(ingredient);
    }

    @Test
    public void removeIngredientCallsWithCorrectParameter() {
        burger.removeIngredient(1);
        Mockito.verify(burger).removeIngredient(1);
    }

    @Test
    public void removeIngredientCallsMultipleTimesWithParameter() {
        burger.removeIngredient(0);
        burger.removeIngredient(0);
        Mockito.verify(burger, Mockito.times(2)).removeIngredient(0);
    }

    @Test
    public void moveIngredientCallsWithCorrectParameter() {
        burger.moveIngredient(1, 0);
        Mockito.verify(burger).moveIngredient(1, 0);
    }

    @Test
    public void moveIngredientCallsMultipleTimesWithParameter() {
        burger.moveIngredient(1, 0);
        burger.moveIngredient(1, 0);
        Mockito.verify(burger, Mockito.times(2)).moveIngredient(1, 0);
    }

    @Test
    public void getPriceReturnsCorrectValue() {
        Mockito.when(burger.getPrice()).thenReturn(125f);
        assertEquals("The burger should have a default price", 125f, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptReturnsCorrectValues() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn("Сдобная");
        Mockito.when(ingredient.getName()).thenReturn("Курица");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        String expectedReceipt = burger.getReceipt();
        assertTrue("The burger receipt should have the bun name", expectedReceipt.contains("Сдобная"));
        assertTrue("The burger receipt should have the ingredient name", expectedReceipt.contains("Курица"));
        assertTrue("The burger receipt should have the price field", expectedReceipt.contains("Price"));
    }
}
