package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest extends TestData {

    Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(TestData.BUN_NAME, TestData.BUN_PRICE);
    }

    @Test
    public void getName() {
        assertEquals(TestData.BUN_NAME, bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(TestData.BUN_PRICE, bun.getPrice(), 0.0001);
    }
}