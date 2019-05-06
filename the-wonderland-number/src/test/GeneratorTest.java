package test;

import logic.Generator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class GeneratorTest {

  private final Generator generator = new Generator();
  @Test
  void generateWonderlandNumberTest() {
    int expected = 142857;
    Assertions.assertEquals(expected, generator.generate());
  }
  @Test
  void haveSameDigitsTest() {
    List<Integer> integers = Arrays.asList(234, 324, 432);
    Assertions.assertTrue(generator.haveSameDigits(integers));
  }

  @Test
  void haveNotSameDigitsTest() {
    List<Integer> integers = Arrays.asList(236, 354, 9432);
    Assertions.assertFalse(generator.haveSameDigits(integers));
  }

  @Test
  void sortNumberAscendingTest() {
    int actual = 456732;
    int expected = 234567;
    Assertions.assertEquals(expected, generator.sortNumberAscending(actual));
  }
}
//142857