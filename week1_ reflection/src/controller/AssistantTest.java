package controller;

import model.Fruit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AssistantTest {

    @Test
    void getFruitNameTest() {
      String fruitName =   Assistant.getFruitList("files/test.txt").get(0).getName();
        String expected = "Banana";
        Assertions.assertEquals(expected,fruitName);
    }
    @Test
    void getFruitAmountTest() {
        Long fruitAmount =   Assistant.getFruitList("files/test.txt").get(0).getAmount();
        int expected = 1;
        Assertions.assertEquals(expected,fruitAmount);
    }
}