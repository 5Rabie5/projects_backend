import controller.Assistant;
import model.Fruit;
import view.FruitCounter;

import java.util.List;

public class FruitShopApp {
    public static void main(String[] args) {

        String filePath = "files/delivery.txt";
        List<Fruit> fruits = Assistant.getFruitList(filePath);
        FruitCounter.display(fruits);
    }
}
