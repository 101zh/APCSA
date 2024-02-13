package Unit9;

// Have to get rid of package statement

public class DoubleCone extends Cone {

    private String flavor2;
    public String topping;

    public DoubleCone(String f, boolean w) {
        this(f, f, w);
    }

    public DoubleCone(String f1, String f2, boolean w) {
        super(f1, w);
        this.flavor2 = f2;
        this.addTopping("");;
    }

    @Override
    public void setFlavor(String f) {
        this.setFlavor(f, f);
    }

    public void setFlavor(String f1, String f2) {
        super.setFlavor(f1);
        this.flavor2 = f2;
    }

    public void addTopping(String t) {
        this.topping = t;
    }

    @Override
    public String toString() {
        String s = "double " + super.toString();
        if (super.getFlavor().equals(flavor2)) {
            s += " x2";
        } else {
            s += " and " + flavor2;
        }

        if (!topping.equals("")) {
            s += " with " + topping;
        }

        return s;
    }
}
