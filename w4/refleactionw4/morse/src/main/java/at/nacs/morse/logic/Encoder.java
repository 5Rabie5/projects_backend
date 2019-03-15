package at.nacs.morse.logic;

import at.nacs.morse.domain.MorseAlphabet;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Encoder {

    private final MorseAlphabet morseAlphabet;

    public String encode(String letter) {
        return morseAlphabet.getMorsealphabet().get(letter);
    }
}
