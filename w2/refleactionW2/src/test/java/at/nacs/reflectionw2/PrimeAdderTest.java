package at.nacs.reflectionw2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PrimeAdderTest {
    @Autowired
    Primes primes;

    @Autowired
    PrimeAdder primeAdder;

    @Test
    void isPrime() {
        assertTrue(primes.isPrime(7));
    }
    @Test
    void isNOtPrime() {
        assertFalse(primes.isPrime(8));
    }

    @Test
    void acculameter100PrimeNumber() {
        Integer result = primeAdder.acculameter(100);
        Integer expected = 24133;

        assertEquals(expected,result);
    }
    @Test
    void acculameter2PrimeNumber() {
        Integer result = primeAdder.acculameter(5);
        Integer expected = 5;

        assertEquals(expected,result);
    }
}