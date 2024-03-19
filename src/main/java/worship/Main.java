package worship;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.nio.file.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.time.temporal.TemporalAdjusters.firstInMonth;

public class Main {
    public static void main(String[] args) {
        List<LocalDate> currentMonthSundays = getSundaysOfMonth(4, 2024);

        List<Musician> musicians = new ArrayList<>();
        try {
            musicians = createMusicians();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Roster jan2024Roster = new Roster("January", 2024);
    }

    private static List<Musician> createMusicians() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String data = readJsonFile();
        List<Musician> musicians = objectMapper.readValue(data, new TypeReference<>() {});
        musicians.forEach(System.out::println);

        return musicians;
    }

    private static String readJsonFile() throws IOException {
        Path path = Paths.get("src/main/java/worship/musicians.json");
        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining("\n"));
        lines.close();
        return data;
    }

    // less coupled - no need to supply the list of all sundays in the year
    // no need to store that many dates (as of rn)
    public static List<LocalDate> getSundaysOfMonth(int month, int year) {
        List<LocalDate> sundays = new ArrayList<>();
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);

        LocalDate sunday = firstDayOfMonth.with(firstInMonth(DayOfWeek.SUNDAY));

        do {
            sunday = sunday.plus(Period.ofDays(7));
        } while (sunday.getMonth() == firstDayOfMonth.getMonth());

        return sundays;
    }


    /*
    *
    * List of Sundays (checkboxes?) next to names
Check who is available each Sunday
Program checks who's available and what instruments
Checks who can worship lead
•	Check last week’s worship lead
•	Exclude last week's from list of available worship leaders for the month
•	Add worship leader if available and not last week’s leader
•	If worship leader not available, move to next in list
•	Repeat for next date
•	If no NEW worship leader available for that Sunday (due to not ticking they are available), then check if last week’s leader is available and add them in if available
o	Put warning that they need to be alerted that no other worship leader is available.

    *
    *
    *
    *
    *
    * */
}