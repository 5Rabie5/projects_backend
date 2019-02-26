package at.nacs.ex3;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LegendaryCompass {

    private final CursedCoin cursedCoin;

    public String getMsg(){
        return cursedCoin.getClass().getSimpleName();

    }
}
