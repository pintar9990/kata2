package software.ulpgc.kata2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

public class HeightHistogramCalculator implements HistogramCalculator {
    private static final int BIN = 3;
    private final List<Person> people;

    public HeightHistogramCalculator(List<Person> people) {
        this.people = people;
    }

    @Override
    public Map<String, Integer> calculate() {
        Map<String, Integer> result = new HashMap<>();
        for (Person person : people) {
            String key = toBin(person.getHeight());
            result.put(key, result.getOrDefault(key,0)+1);
        }
        return result;
    }

    private String toBin(double height) {
        return low(height) + "-" + (high(height));
    }

    private int high(double height) {
        return low(height) + BIN;
    }

    private int low(double height) {
        return (int) (height / BIN) * BIN;
    }
}
