package praktikum;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientTest {

  private final IngredientType type;
  private final  String name;
  private final float price;

  public IngredientTest(IngredientType type, String name, float price) {
    this.type = type;
    this.name = name;
    this.price = price;
  }

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        { IngredientType.SAUCE, "Test Sauce", 50.0f },
        { IngredientType.FILLING, "Test Filling", 75.0f },
        { IngredientType.SAUCE, "Spicy Sauce", 60.0f }
    });
  }

  @Test
  public void getTypeTest() {
    Ingredient ingredient = new Ingredient(type, name, price);
    assertEquals(type, ingredient.getType());
  }

  @Test
  public void getNameTest() {
    Ingredient ingredient = new Ingredient(type, name, price);
    assertEquals(name, ingredient.getName());
  }

  @Test
  public void getPriceTest() {
    Ingredient ingredient = new Ingredient(type, name, price);
    assertEquals(price, ingredient.getPrice(), 0.01);
  }
}
