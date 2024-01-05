package worship;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        LocalDate startOf2024 = LocalDate.of(2024, 1, 1);
        LocalDate endOf2024 = LocalDate.of(2024, 12, 31);
        List<LocalDate> dates = startOf2024.datesUntil(endOf2024).toList();

        List<LocalDate> sundays = new ArrayList<>();
        for(LocalDate d : dates){
            if(d.getDayOfWeek().getValue() == 7){
                sundays.add(d);
            }
        }

        List<LocalDate> jan = getSundaysOfMonth(sundays, 1);
        jan.forEach(System.out::println);

        List<Musician> musicians = new ArrayList<>();
        try {
            musicians = createMusicians();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Roster jan2024Roster = new Roster();
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

    private static List<LocalDate> getSundaysOfMonth(List<LocalDate> sundays, int monthValue) {
        List<LocalDate> monthOfSundays = new ArrayList<>();
        for(LocalDate d : sundays){
            if(d.getMonth().getValue() == monthValue){
                monthOfSundays.add(d);
            }
        }
        return monthOfSundays;
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