package praktikum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BunTest {

  @Test
  public void getNameTest() {
    Bun bun = new Bun("Test Bun", 150.0f);
    assertEquals("Test Bun", bun.getName());
  }

  @Test
  public void getPriceTest() {
    Bun bun = new Bun("Test Bun", 150.0f);
    assertEquals(150.0f, bun.getPrice(), 0.01);
  }
}
