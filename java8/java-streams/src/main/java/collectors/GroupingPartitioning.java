package collectors;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by satish on 16/05/14.
 */
public class GroupingPartitioning {

    public static void main(String[] args) {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());

        //with classifier function T -> K
        Map<String, List<Locale>> countryLocales = locales.collect(Collectors.groupingBy(Locale::getCountry));

        System.out.println(countryLocales.get("CH"));

        locales = Stream.of(Locale.getAvailableLocales());

        Map<String, Long> countryCount = locales.collect(Collectors.groupingBy(Locale::getCountry, Collectors.counting()));

        System.out.println(countryCount);

        locales = Stream.of(Locale.getAvailableLocales());

        Map<Boolean, List<Locale>> engOrOtherLocal = locales.collect(Collectors.partitioningBy(l -> "en".equals(l.getLanguage())));
        System.out.println("English locales: " + engOrOtherLocal.get(true));
    }
}
