package at.nacs.dutchman.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DeadMansChest {

    @Getter
    @Value("${deadMansChest.chest}")
    private String item;
}
