package at.nacs.ex5.controller;

import at.nacs.ex5.model.Expression;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Expressions {

    public Expression from(String input) {
       List<String> list= Stream.of(input)
                .map(e -> e.split(" "))
                .flatMap(Stream::of)
                .collect(Collectors.toList());
       if (list.size()!=3){
           throw new java.lang.IllegalArgumentException();
       }
        return Expression.builder()
                .number1(Double.valueOf(list.get(0)))
                .number2(Double.valueOf(list.get(2)))
                .symbol(list.get(1))
                .build();
    }
}
