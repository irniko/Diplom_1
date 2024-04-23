package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, TestData.INGREDIENT_NAMES[0], TestData.INGREDIENT_PRICES[0]);
    }

    @Test
    public void getPriceTest() {
        assertEquals(TestData.INGREDIENT_PRICES[0], ingredient.getPrice(), 0.0001);
    }

    @Test
    public void getNameTest() {
        assertEquals(TestData.INGREDIENT_NAMES[0], ingredient.getName());
    }
}