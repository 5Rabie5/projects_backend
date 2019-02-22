package controller;

import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import model.Fruit;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Log
@UtilityClass
public class Assistant {

    public List<Fruit> getFruitList(String filePath) {
        return FileReader.lines(filePath)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .map(toFruit())
                .collect(Collectors.toList());
    }

    private static Function<Map.Entry<String, Long>, Fruit> toFruit() {
        return e -> Fruit.builder().name(e.getKey()).amount(e.getValue()).build();
    }
}
