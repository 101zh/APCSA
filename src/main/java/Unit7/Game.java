package Unit7;

// Have to get rid of package statement

public class Game {
  public static void play(GameWheel g) {
    int totalMoney = 0;
    String infoStr = "";
    String color = "";
    boolean sameColor = true;

    Slice[] slices = new Slice[3];
    for (int i = 0; i < 3; i++) {
      slices[i] = g.spinWheel();
      totalMoney += slices[i].getPrizeAmount();
      infoStr += "Spin " + (i + 1) + " - " + slices[i].toString() + "\n";
      if (color.length() == 0) {
        color = slices[i].getColor();
      } else if (!color.equals(slices[i].getColor())) {
        sameColor = false;
      }
    }

    if (sameColor) {
      totalMoney *= 2;
      infoStr += "Three " + color + "s = double your money!";
    }

    System.out.println("Total prize money: $" + totalMoney + "\n");
    System.out.println(infoStr);

  }
}
