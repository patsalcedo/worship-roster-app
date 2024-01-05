package worship;

import java.util.List;

public class Musician {
    private String firstName;
    private String lastName;
    private List<String> instruments;
    private Boolean worshipLeader; // had to change from isWorshipLeader for json parsing

    public Musician() {}

    public Musician(String firstName, String lastName, Boolean worshipLeader) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.worshipLeader = worshipLeader;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<String> instruments) {
        this.instruments = instruments;
    }

    public Boolean worshipLeader() {
        return worshipLeader;
    }

    public void setWorshipLeader(Boolean worshipLeader) {
        this.worshipLeader = worshipLeader;
    }

    @Override
    public String toString() {
        return "Musician{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", instruments=" + instruments +
                ", worshipLeader=" + worshipLeader +
                '}';
    }
}
