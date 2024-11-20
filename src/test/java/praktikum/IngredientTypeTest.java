package praktikum;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class IngredientTypeTest {

  @Test
  public void ingredientTypeNotNullTest() {
    assertNotNull(IngredientType.SAUCE);
    assertNotNull(IngredientType.FILLING);
  }
}
