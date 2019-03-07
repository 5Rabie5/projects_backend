package at.nacs.ex6;

import lombok.Getter;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


import java.util.Map;

@Component
@ConfigurationProperties("things")
public class Shop {
    @Getter
    @Setter
    private Map<String,Integer> books;
}
