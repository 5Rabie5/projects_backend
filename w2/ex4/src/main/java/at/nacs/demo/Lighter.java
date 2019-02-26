package at.nacs.demo;

import org.springframework.stereotype.Component;

@Component
public class Lighter {

    public void light(Cigar cigar) {
        cigar.setLit(true);
    }
}
