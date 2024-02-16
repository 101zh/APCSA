package Unit9;

// Have to get rid of package statement

public class UltimatePlayer extends Person {
    private static int players = 1;
    private int jerseyNumber;
    private String position;

    public UltimatePlayer(String firstName, String lastName, String position) {
        super(firstName, lastName);
        if (!(position.equals("handler") || position.equals("cutter"))) {
            position = "handler";
        }

        this.position = position;
        this.jerseyNumber = players;
        players++;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public int throwDisc(int pow) {
        return super.throwDisc(pow) * 2;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "   Jersey #: " + jerseyNumber + "\n" +
                "   Position: " + getPosition();
    }

}
