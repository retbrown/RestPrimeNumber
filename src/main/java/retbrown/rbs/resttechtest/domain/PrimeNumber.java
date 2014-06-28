package retbrown.rbs.resttechtest.domain;

import java.util.List;

public class PrimeNumber {
    private String initial;
    private List<Integer> primes;

    public PrimeNumber(String initial, List<Integer> primes) {
        this.initial = initial;
        this.primes = primes;
    }

    public String getInitial() {
        return initial;
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
