package praktikum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IngredientTest {

  @Test
  public void getTypeTest() {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Test Sauce", 50.0f);
    assertEquals(IngredientType.SAUCE, ingredient.getType());
  }

  @Test
  public void getNameTest() {
    Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Test Filling", 75.0f);
    assertEquals("Test Filling", ingredient.getName());
  }

  @Test
  public void getPriceTest() {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Test Sauce", 50.0f);
    assertEquals(50.0f, ingredient.getPrice(), 0.01);
  }
}
