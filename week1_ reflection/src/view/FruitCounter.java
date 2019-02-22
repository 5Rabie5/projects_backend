package view;

import lombok.experimental.UtilityClass;
import model.Fruit;

import java.util.List;

@UtilityClass
public class FruitCounter {

    public void display(List<Fruit> list) {
        list.stream().map(e -> (e.getName() + " " + e.getAmount()))
                .forEach(System.out::println);
    }
}
