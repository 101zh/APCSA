package Unit9;

// Have to get rid of package statement

public class SpecialityCoffee extends Coffee {
    String flavor;

    public SpecialityCoffee() {
        super();
        this.flavor = "vanilla";
    }

    public SpecialityCoffee(String size, String type, String flavor) {
        this(size, false, 1, type, flavor);
    }

    public SpecialityCoffee(String size, boolean isSkinny, int shots, String type, String flavor) {
        super(size, isSkinny, shots, type);
        this.flavor = flavor;
    }

    @Override
    public String toString() {
        return super.toString() + " with " + flavor;
    }

    @Override
    public int getPrice() {
        int price = super.getPrice();

        if (this.getSize().equals("extra large") || this.getSize().equals("large")) {
            price += 50;
        } else {
            price += 30;
        }

        return price;
    }

}
