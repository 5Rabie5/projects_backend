package at.nacs.ex6;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Word {
    @Getter
    @Value("${word.text}")
    private String text;
}
