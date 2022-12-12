package ru.yandex.practicum.tests;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {

    @Test
    public void enumIngredientTypeSauceIsCorrectValue() {
        IngredientType ingredientTypeSauce = IngredientType.SAUCE;
        assertEquals("The value of ingredient type SAUCE is correct", IngredientType.valueOf("SAUCE"), ingredientTypeSauce);
    }

    @Test
    public void enumIngredientTypeFillingIsCorrectValue() {
        IngredientType ingredientTypeFilling = IngredientType.FILLING;
        assertEquals("The value of ingredient type FILLING is correct", IngredientType.valueOf("FILLING"), ingredientTypeFilling);
    }
}
