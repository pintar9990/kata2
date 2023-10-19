package software.ulpgc.kata2;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = TsvFilePersonLoader.with("hw_25000.tsv").load();
        Map<String, Integer> histogram = new HeightHistogramCalculator(people).calculate();
        for (String key : histogram.keySet().stream().toList()){
            System.out.println(key + " " + histogram.get(key));
        }

        MeanCalculator meanCalculator = new MeanCalculator();
        Map<String, Double> meanValues = meanCalculator.calculate(people);

        System.out.println("Media de Altura: " + meanValues.get("height"));
        System.out.println("Media de Peso: " + meanValues.get("weight"));
    }
}
