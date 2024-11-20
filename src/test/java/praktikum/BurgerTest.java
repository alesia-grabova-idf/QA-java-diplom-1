package praktikum;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class BurgerTest {

  private Burger burger;
  private Bun mockBun;
  private Ingredient mockIngredient1;
  private Ingredient mockIngredient2;

  @Before
  public void setUp() {
    burger = new Burger();
    mockBun = mock(Bun.class);
    mockIngredient1 = mock(Ingredient.class);
    mockIngredient2 = mock(Ingredient.class);

    when(mockBun.getPrice()).thenReturn(100.0f);
    when(mockIngredient1.getPrice()).thenReturn(50.0f);
    when(mockIngredient2.getPrice()).thenReturn(75.0f);

    burger.setBuns(mockBun);
    burger.addIngredient(mockIngredient1);
    burger.addIngredient(mockIngredient2);
  }

  @Test
  public void getPriceTest() {
    float expectedPrice = 100.0f * 2 + 50.0f + 75.0f;
    assertEquals(expectedPrice, burger.getPrice(), 0.01);
  }

  @Test
  public void getReceiptTest() {
    String receipt = burger.getReceipt();
    assertTrue(receipt.contains("(===="));
    assertTrue(receipt.contains("Price"));
  }
}
