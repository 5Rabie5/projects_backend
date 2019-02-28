package at.nacs.ex5.controller;

import at.nacs.ex5.model.Expression;
import at.nacs.ex5.controller.operation.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
@Component
@RequiredArgsConstructor
public class Calculator {

    private final Set<Operation> operations;

    public Double calculate(Expression expressions){
       return operations.stream()
                .filter(e -> e.matches(expressions) )
                .map(e -> e.apply(expressions))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

}
