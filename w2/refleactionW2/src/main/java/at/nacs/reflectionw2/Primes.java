package at.nacs.reflectionw2;

import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class Primes {

    public Boolean isPrime(Integer number) {

        return IntStream.rangeClosed(1, number)
                .mapToObj(e -> number % e)
                .filter(e -> e.equals(0))
                .count() == 2;
    }
}
