package at.nacs.ex6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ShopTest {
    @Autowired
    Shop shop;

    @ParameterizedTest
    @CsvSource({"0,HarryPotter, 3",
            "2,TheLordoftheRings, 4",
            "1,TheFoundation, 2",})
    void getBooks(int index, String title, Integer copies) {
        Assertions.assertTrue(shop.getBooks().keySet().contains(title));
        Assertions.assertTrue(shop.getBooks().values().contains(copies));


    }

}