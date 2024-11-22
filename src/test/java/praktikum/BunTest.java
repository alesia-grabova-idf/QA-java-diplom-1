package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

  private final String name;
  private final float price;

  // Единственный публичный конструктор
  public BunTest(String name, float price) {
    this.name = name;
    this.price = price;
  }

  // Метод для предоставления параметров
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {"Test Bun", 150.0f},
        {"Cheese Bun", 200.0f},
        {"Whole Grain Bun", 180.5f}
    });
  }

  @Test
  public void getNameTest() {
    Bun bun = new Bun(name, price);
    assertEquals(name, bun.getName());
  }

  @Test
  public void getPriceTest() {
    Bun bun = new Bun(name, price);
    assertEquals(price, bun.getPrice(), 0.01);
  }
}

