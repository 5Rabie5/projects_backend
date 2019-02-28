package at.nacs.reflectionw2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class PrimeAdder {
    final Primes primes;

    public int acculameter(Integer max) {
        return IntStream.iterate(0, n -> n + 1)
                .filter(primes::isPrime)
                .limit(max)
                .sum();
    }
}
