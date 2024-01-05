package worship;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Roster {

    private Month month;
    private Integer year;
    private List<LocalDate> sundayDates;
    private List<SundaySetlist> sundaySetlistsOfTheMonth;

    public Roster(Month month, Integer year) {
        this.month = month;
        this.year = year;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public List<SundaySetlist> getSundaysSetlistsOfTheMonth() {
        return sundaySetlistsOfTheMonth;
    }

    public void setSundaysOfTheMonth(List<SundaySetlist> sundaySetlistsOfTheMonth) {
        this.sundaySetlistsOfTheMonth = sundaySetlistsOfTheMonth;
    }
}
