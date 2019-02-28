package at.nacs.ex5.controller.operation;


import at.nacs.ex5.model.Expression;
import org.springframework.stereotype.Component;

@Component
public class Division implements Operation {


    @Override
    public Boolean matches(Expression expression) {

        return  "/".equals(expression.getSymbol());
    }

    @Override
    public Double apply(Expression expression) {
        return expression.getNumber1()/expression.getNumber2();
    }
}
