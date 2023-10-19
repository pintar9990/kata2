package software.ulpgc.kata2;

import java.util.List;
import java.util.Map;

public class MeanCalculator {
    public Map<String, Double> calculate(List<Person> people) {
        return Map.of(
                "height", meanHeight(people),
                "weight", meanWeight(people)
        );
    }

    private double meanHeight(List<Person> people) {
        return people.stream().mapToDouble(Person::getHeight).average().orElse(0);
    }

    private double meanWeight(List<Person> people) {
        return people.stream().mapToDouble(Person::getWeight).average().orElse(0);
    }
}
