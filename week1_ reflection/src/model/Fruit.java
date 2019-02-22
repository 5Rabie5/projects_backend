package model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Fruit {
    private String name;
    private Long amount;

}
