package Unit9;

// Have to get rid of package statement

public class Coach extends Person {
    String role;

    public Coach(String firstName, String lastName, String role) {
        super(firstName, lastName);
        this.role = role;
    }

    public String toString() {
        return super.toString() + "\n" +
                "   Role: " + role;
    }
}
