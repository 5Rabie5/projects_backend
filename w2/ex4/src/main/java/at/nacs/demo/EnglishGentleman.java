package at.nacs.demo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@RequiredArgsConstructor
public class EnglishGentleman {
    private final Lighter lighter;
    private final Monocle monocle;

    @Getter
    private boolean read;
    @Getter
    private boolean smoke;

    public void smoke(Cigar cigar) throws CigarWasNotLitException {
        lighter.light(cigar);
        cigar.smoke();
        smoke=true;
    }

    public void read(Newspaper newspaper) {
        monocle.read(newspaper);
        read=true;
    }

    public boolean hadAGoodDay() {
        return smoke && read;
    }
}
