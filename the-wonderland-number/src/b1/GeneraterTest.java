package b1;

import org.junit.jupiter.api.Test;

class GeneraterTest {
  Generater generater = new Generater();

  @Test
  void generate() {
    System.out.println(generater.generate());
  }


}