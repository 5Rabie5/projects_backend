package at.nacs.demo;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class Cigar {
    private boolean lit;

    public void smoke() throws CigarWasNotLitException {
        if (!lit) {
            throw new CigarWasNotLitException();
        }
    }
}
