package retbrown.rbs.resttechtest.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Primes")
public class PrimeNumber {
    @XmlElement
    private String initial;
    @XmlElement
    private List<Integer> primes;

    public PrimeNumber() {
        this.initial = "0";
        this.primes = new ArrayList<Integer>();
    }

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
