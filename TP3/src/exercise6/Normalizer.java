package exercise6;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Normalizer {

    File file;
    private static DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    public Normalizer(String file) {
        this.file = new File(file);
    }

    public void normalize() throws IOException {
        Map<Integer, List<Double>> normalized = readIntegerListMap();
        writeIntegerListMap(normalized);
    }

    private void writeIntegerListMap(Map<Integer, List<Double>> normalized) throws IOException {
        File result = new File(this.file.getParentFile().getPath() + "/numbers_result.txt");
        Writer writer = new FileWriter(result);
        for (Map.Entry<Integer, List<Double>> entry : normalized.entrySet()) {
            writer.write(entry.getKey() + "\t" + getStringValue(entry.getValue()) + "\n");
        }
        writer.close();
    }

    private Map<Integer, List<Double>> readIntegerListMap() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Map<Integer, List<Double>> normalized = new HashMap<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            addToMap(normalized, line);
        }
        return normalized;
    }

    private String getStringValue(List<Double> numbers) {
        StringBuilder buffer = new StringBuilder();
        for (Double num : numbers) {
            buffer.append(decimalFormat.format(num.doubleValue())).append(" ");
        }
        return buffer.substring(0, buffer.length() - 1);
    }

    private void addToMap(Map<Integer, List<Double>> normalized, String line) {
        Map.Entry<Integer, List<Double>> entry = parseLine(line);
        if (!normalized.containsKey(entry.getKey())) {
            normalized.put(entry.getKey(), entry.getValue());
        } else {
            List<Double> oldValue = normalized.get(entry.getKey());
            if (variance(entry.getValue()) > variance(oldValue)) {
                normalized.put(entry.getKey(), entry.getValue());
            }
        }
    }

    private double variance(List<Double> numbers) {
        double total = 0;
        double standardDev;
        double quadVariance = 0;
        for (Double d : numbers) {
            total += d;
        }
        standardDev = total / numbers.size();

        for (Double num : numbers) {
            quadVariance = java.lang.Math.pow(num - standardDev, 2);
        }
        quadVariance = quadVariance / numbers.size();
        return Math.sqrt(quadVariance);
    }

    private Map.Entry<Integer, List<Double>> parseLine(String line) {
        String split[] = line.split("\t");
        Integer key = Integer.valueOf(split[0]);
        List<Double> value = parseValue(split[1]);
        return new AbstractMap.SimpleEntry<>(key, value);
    }

    private List<Double> parseValue(String value) {
        String values[] = value.split(" ");
        List<Double> parsed = new ArrayList<>();
        for (String s : values) {
            parsed.add(Double.valueOf(s));
        }
        return parsed;
    }

}
