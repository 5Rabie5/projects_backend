package at.nacs.ex5.model;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Expression {

    double number1;
    String symbol;
    double number2;
}
