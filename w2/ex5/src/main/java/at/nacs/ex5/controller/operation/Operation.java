package at.nacs.ex5.controller.operation;


import at.nacs.ex5.model.Expression;

public interface Operation {
     Boolean matches( Expression expression);
     Double apply(Expression expression);
}
