import java.util.Objects;

public class SoccerPlayer {

    private final int number;
    private final String firstName;
    private final String lastName;
    private final String position;

    public SoccerPlayer(int number, String firstName, String lastName, String position) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPosition() {
        return position;
    }

    // here we override the super-class's ".equals" method in order to pass SoccerPlayer values to determine equality
    // this is to override the default "reference equality" behavior so that we can indicate player by their values.
    // If our list is all Megan Rapinoes, the .remove method only removes the first one.
    @Override
    public boolean equals(Object value) {
        // 1. check reference equality
        if (this == value) {
            return true;
        }
        // 2. Are they the same type?
        if (value == null || getClass() != value.getClass()) {
            return false;
        }

        // The types are the same. It's safe to cast value as a SoccerPlayer.
        SoccerPlayer other = (SoccerPlayer) value;
        // 3. check jersey number
        if (number != other.number) {
            return false;
        }
        // 4. check first name
        // Objects.equals is a utility method that checks equality, including null checks.
        // It makes our code a little clearer.
        if (!Objects.equals(firstName, other.firstName)) {
            return false;
        }

        // 5. check last name
        if (!Objects.equals(lastName, other.lastName)) {
            return false;
        }

        // 6. check position
        if (!Objects.equals(position, other.position)) {
            return false;
        }

        // 7. We made it! These objects are equal.
        return true;
    }

}
