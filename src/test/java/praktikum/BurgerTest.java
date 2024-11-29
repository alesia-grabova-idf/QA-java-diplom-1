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

  private String bunName;
  private float bunPrice;
  private String ingredient1Name;
  private String ingredient2Name;
  private IngredientType ingredient1Type;
  private IngredientType ingredient2Type;
  private float ingredient1Price;
  private float ingredient2Price;

  @Before
  public void setUp() {

    bunName = "black bun";
    bunPrice = 100.0f;
    ingredient1Name = "Test Sauce";
    ingredient2Name = "Test Filling";
    ingredient1Type = IngredientType.SAUCE;
    ingredient2Type = IngredientType.FILLING;
    ingredient1Price = 50.0f;
    ingredient2Price = 75.0f;

    burger = new Burger();
    mockBun = mock(Bun.class);
    when(mockBun.getName()).thenReturn(bunName);
    when(mockBun.getPrice()).thenReturn(bunPrice);

    mockIngredient1 = mock(Ingredient.class);
    mockIngredient2 = mock(Ingredient.class);
    when(mockIngredient1.getPrice()).thenReturn(ingredient1Price);
    when(mockIngredient2.getPrice()).thenReturn(ingredient2Price);
    when(mockIngredient1.getName()).thenReturn(ingredient1Name);
    when(mockIngredient2.getName()).thenReturn(ingredient2Name);
    when(mockIngredient1.getType()).thenReturn(ingredient1Type);
    when(mockIngredient2.getType()).thenReturn(ingredient2Type);

    burger.setBuns(mockBun);
    burger.addIngredient(mockIngredient1);
    burger.addIngredient(mockIngredient2);
  }

  @Test
  public void getPriceTest() {
    float expectedPrice = bunPrice * 2 + ingredient1Price + ingredient2Price;
    assertEquals(expectedPrice, burger.getPrice(), 0.01);
  }

  @Test
  public void getReceiptTest() {

    String expectedReceipt = String.format(
        "(==== %s ====)\n" +
            "= %s %s =\n" +
            "= %s %s =\n" +
            "(==== %s ====)\n" +
            "\nPrice: %.6f\n",
        bunName, ingredient1Type.toString().toLowerCase(), ingredient1Name,
        ingredient2Type.toString().toLowerCase(), ingredient2Name, bunName,
        burger.getPrice()
    );

    String receipt = burger.getReceipt();

    assertEquals("Receipt format is incorrect", expectedReceipt, receipt);
  }
}
