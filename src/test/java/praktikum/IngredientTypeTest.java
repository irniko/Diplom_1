package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    Ingredient ingredient;
    IngredientType type;

    public IngredientTypeTest(IngredientType type) {
        this.type = type;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(type, TestData.INGREDIENT_NAMES[0], TestData.INGREDIENT_PRICES[0]);
    }

    @Parameterized.Parameters(name = "Тип ингредиента: {0}")
    public static Object[][] getIngredientType() {
        return new Object[][] {
                {IngredientType.FILLING},
                {IngredientType.SAUCE},
        };
    }

    @Test
    public void getType() {
        Assert.assertEquals(type, ingredient.getType());
    }

}