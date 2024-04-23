package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest extends TestData {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;

    Burger burger;


    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient);
        assertFalse(burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        Ingredient elementToMove = burger.ingredients.get(1);
        burger.moveIngredient(1,0);
        assertEquals(burger.ingredients.get(0), elementToMove);
    }

    @Test
    public void getPriceTest() {

        Mockito.when(bun.getPrice()).thenReturn(TestData.BUN_PRICE);
        float price = bun.getPrice() * 2;
        burger.setBuns(bun);

        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        int i = 0;
        for (Ingredient ingr : burger.ingredients) {
            Mockito.when(ingr.getPrice()).thenReturn(TestData.INGREDIENT_PRICES[i]);
            price += burger.ingredients.get(i).getPrice();
            i++;
        }

        burger.getPrice();
        assertEquals(price, burger.getPrice(), 0.0001);
    }


    @Test
    public void getReceiptTest() {

        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(TestData.BUN_NAME);

        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)", bun.getName()));
        expectedReceipt.append(System.lineSeparator());
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);

        int i = 0;
        for (Ingredient ingr : burger.ingredients) {
            Mockito.when(ingr.getName()).thenReturn(TestData.INGREDIENT_NAMES[i]);
            Mockito.when(ingr.getType()).thenReturn(TestData.INGREDIENT_TYPES[i]);
            expectedReceipt.append(String.format("= %s %s =", ingr.getType().toString().toLowerCase(), ingr.getName()));
            expectedReceipt.append(System.lineSeparator());
            i++;
        }

        expectedReceipt.append(String.format("(==== %s ====)", bun.getName()));
        expectedReceipt.append(System.lineSeparator());
        expectedReceipt.append(String.format("%nPrice: %f", burger.getPrice()));
        expectedReceipt.append(System.lineSeparator());

        assertEquals(expectedReceipt.toString(), burger.getReceipt());
    }
}