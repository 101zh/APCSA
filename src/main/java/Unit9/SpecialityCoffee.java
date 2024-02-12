package Unit9;

// Have to get rid of package statement

public class SpecialityCoffee extends Coffee {
    String flavor;

    public SpecialityCoffee() {
        super();
        flavor = "vanilla";
    }

    public SpecialityCoffee(String size, String type, String flavor) {
        super(size, false, 1, type);
        this.flavor = flavor;
    }

    public SpecialityCoffee(String size, boolean isSkinny, int shots, String type, String flavor) {
        super(size, isSkinny, shots, type);
        this.flavor = flavor;
    }

    public String toString() {
        return super.toString() + " with " + flavor;
    }

}
