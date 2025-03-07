import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        List<City> cityList = List.of(
                new City("New York", "New York", 8_000_000),
                new City("Los Angeles", "California", 3_800_000),
                new City("Chicago", "Illinois", 2_600_000),
                new City("Houston", "Texas", 2_300_000),
                new City("Phoenix", "Arizona", 1_700_000),
                new City("Philadelphia", "Pennsylvania", 1_600_000),
                new City("San Antonio", "Texas", 1_500_000),
                new City("San Diego", "California", 1_400_000),
                new City("Dallas", "Texas", 1_300_000),
                new City("Jacksonville", "Florida", 990_000),
                new City("Austin", "Texas", 980_000),
                new City("Fort Worth", "Texas", 979_000),
                new City("San Jose", "California", 970_000)
        );

        Map<String, Integer> stateToCityPopulation = cityList.stream().collect(
                Collectors.groupingBy(City::getState, Collectors.summingInt(City::getPopulation))
        );

        TreeMap<String, Integer> sortedStateToCityPopulation = new TreeMap<>(stateToCityPopulation);

        for (Map.Entry<String, Integer> stringIntegerEntry : sortedStateToCityPopulation.entrySet())
        {
            System.out.print(stringIntegerEntry.getKey() + " ");

            DecimalFormatSymbols symbols = new DecimalFormatSymbols();
            symbols.setGroupingSeparator('_');
            DecimalFormat decimalFormat = new DecimalFormat("#,###", symbols);
            String formattedNumber = decimalFormat.format(stringIntegerEntry.getValue());

            System.out.println(formattedNumber);
        }
    }
}