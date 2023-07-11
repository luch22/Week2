import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class cha2 {
    public static void main(String[] args) {

        javaItem v = new javaItem();
        List<javaItem> jvItem = v.processInputFile("..\\WEEK2\\test.csv");
        v.printUniqueValues(jvItem);
    }

    public static class javaItem {

        private String direction;
        private String year;
        private String date;
        private String day;
        private String Country;
        private String Commodity;
        private String TransportMode;
        private String Measure;
        private String Value;
        private String Cumulative;

        public javaItem(String direction, String year, String date, String day, String country, String commodity,
                String transportMode, String measure, String value, String cumulative) {
            this.direction = direction;
            this.year = year;
            this.date = date;
            this.day = day;
            Country = country;
            Commodity = commodity;
            TransportMode = transportMode;
            Measure = measure;
            Value = value;
            Cumulative = cumulative;
        }

        public javaItem() {
        }

        private void printUniqueValues(List<javaItem> itemList) {
            Set<String> uniqueDirections = new HashSet<>();
            Set<String> uniqueYears = new HashSet<>();
            Set<String> uniqueDates = new HashSet<>();
            Set<String> uniqueDays = new HashSet<>();
            Set<String> uniqueCountries = new HashSet<>();
            Set<String> uniqueCommodities = new HashSet<>();
            Set<String> uniqueTransportModes = new HashSet<>();
            Set<String> uniqueMeasures = new HashSet<>();
            Set<String> uniqueValues = new HashSet<>();
            Set<String> uniqueCumulatives = new HashSet<>();

            for (javaItem item : itemList) {
                uniqueDirections.add(item.direction);
                uniqueYears.add(item.year);
                uniqueDates.add(item.date);
                uniqueDays.add(item.day);
                uniqueCountries.add(item.Country);
                uniqueCommodities.add(item.Commodity);
                uniqueTransportModes.add(item.TransportMode);
                uniqueMeasures.add(item.Measure);
                uniqueValues.add(item.Value);
                uniqueCumulatives.add(item.Cumulative);
            }

            System.out.println("Unique Directions: " + uniqueDirections);
            System.out.println("Unique Years: " + uniqueYears);
            // // System.out.println("Unique Dates: " + uniqueDates);
            System.out.println("Unique Days: " + uniqueDays);
            System.out.println("Unique Countries: " + uniqueCountries);
            // System.out.println("Unique Commodities: " + uniqueCommodities);
            // System.out.println("Unique Transport Modes: " + uniqueTransportModes);
            System.out.println("Unique Measures: " + uniqueMeasures);
            // System.out.println("Unique Values: " + uniqueValues);
            // System.out.println("Unique Cumulatives: " + uniqueCumulatives);
        }

        private void printSpecificValues(List<javaItem> item, Map<String, String> specific) {

            for (String string : specific) {
                for (javaItem java : item) {

                }

            }

        }

        private List<javaItem> processInputFile(String inputFilePath) {

            List<javaItem> inputList = new ArrayList<javaItem>();
            try {
                File inputF = new File(inputFilePath);
                InputStream inputFS = new FileInputStream(inputF);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));

                inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
                br.close();

            } catch (IOException e) {
                // TODO: handle exception
            }

            return inputList;
        }

    }

    private static Function<String, javaItem> mapToItem = (line) -> {

        String[] p = line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
        javaItem item = new javaItem(p[0], p[1], p[2], p[3], p[4], p[5], p[6], p[7], p[8], p[9]);
        return item;
    };

}
