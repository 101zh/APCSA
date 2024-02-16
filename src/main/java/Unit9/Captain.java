package Unit9;

// Have to get rid of package statement

public class Captain extends UltimatePlayer {
    private boolean type;

    public Captain(String firstName, String lastName, String position, boolean type) {
        super(firstName, lastName, position);
        this.type = type;
    }

    @Override
    public int throwDisc(int pow) {
        return (int) (super.throwDisc(pow) * 1.25);
    }

    @Override
    public String toString() {
        String typeName;

        if (type) {
            typeName = "offense";
        } else {
            typeName = "defense";
        }

        return super.toString() + "\n" +
                "   Captain: " + typeName;
    }

}
