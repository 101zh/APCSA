package Unit7;

// Have to get rid of package statement

import java.util.ArrayList;

public class GameWheel {
  private ArrayList<Slice> slices; // List of slices making up the wheel
  private int currentPos; // Position of currently selected slice on wheel

  /*
   * Returns string representation of GameWheel with each numbered slice
   * on a new line
   */
  public String toString() {
    String str = "";
    for (int i = 0; i < 20; i++) {
      str += i + " - " + getSlice(i) + "\n";
    }
    return str;
  }

  /*
   * Randomizes the positions of the slices that are in the wheel, but without
   * changing the pattern of the colors
   */
  public void scramble() {
    ArrayList<Slice> evenSlices = new ArrayList<>();
    ArrayList<Slice> oddSlices = new ArrayList<>();
    ArrayList<Slice> blackSlices = new ArrayList<>();

    // Separate slices into different arrays
    for (int i = 0; i < slices.size(); i++) {
      if (i % 5 == 0) {
        blackSlices.add(getSlice(i));
      } else if (i % 2 == 0) {
        evenSlices.add(getSlice(i));
      } else {
        oddSlices.add(getSlice(i));
      }
    }

    // Randomize inside arrays (does 10 times)
    for (int i = 0; i < 10; i++) {
      int swapIndex1 = (int) (Math.random() * evenSlices.size());
      int swapIndex2 = (int) (Math.random() * evenSlices.size());
      int blackSwapIndex1 = (int) (Math.random() * blackSlices.size());
      int blackSwapIndex2 = (int) (Math.random() * blackSlices.size());

      Slice temp = evenSlices.get(swapIndex1);
      evenSlices.set(swapIndex1, evenSlices.get(swapIndex2));
      evenSlices.set(swapIndex2, temp);

      temp = oddSlices.get(swapIndex2);
      oddSlices.set(swapIndex2, oddSlices.get(swapIndex1));
      oddSlices.set(swapIndex1, temp);

      temp = blackSlices.get(blackSwapIndex1);
      blackSlices.set(blackSwapIndex1, blackSlices.get(blackSwapIndex2));
      blackSlices.set(blackSwapIndex2, temp);

    }

    constructWheelFromSlices(blackSlices, evenSlices, oddSlices);

  }

  /*
   * Sorts the positions of the slices that are in the wheel by prize amount,
   * but without changing the pattern of the colors.
   */
  public void sort() {
    ArrayList<Slice> evenSlices = new ArrayList<>();
    ArrayList<Slice> oddSlices = new ArrayList<>();
    ArrayList<Slice> blackSlices = new ArrayList<>();

    // Separate slices into different arrays
    for (int i = 0; i < 20; i++) {
      if (i % 5 == 0) {
        blackSlices.add(getSlice(i));
      } else if (i % 2 == 0) {
        evenSlices.add(getSlice(i));
      } else {
        oddSlices.add(getSlice(i));
      }
    }    

    // Sort even and odd slices
    for (int i = 0; i < evenSlices.size(); i++) {
      int evenMIndex = i;
      int oddMIndex = i;
      for (int j = i; j < evenSlices.size(); j++) {
        if (evenSlices.get(j).getPrizeAmount() < evenSlices.get(evenMIndex).getPrizeAmount()) {
          evenMIndex = j;
        }
        if (oddSlices.get(j).getPrizeAmount() < oddSlices.get(oddMIndex).getPrizeAmount()) {
          oddMIndex = j;
        }
      }

      Slice temp = evenSlices.get(i);
      evenSlices.set(i, evenSlices.get(evenMIndex));
      evenSlices.set(evenMIndex, temp);

      temp = oddSlices.get(i);
      oddSlices.set(i, oddSlices.get(oddMIndex));
      oddSlices.set(oddMIndex, temp);
    }

    // Sort black slices
    for (int i = 0; i < blackSlices.size(); i++) {
      int mINdex = i;
      for (int j = i; j < blackSlices.size(); j++) {
        if (blackSlices.get(j).getPrizeAmount() < blackSlices.get(mINdex).getPrizeAmount()) {
          mINdex = j;
        }
      }

      Slice temp = blackSlices.get(i);
      blackSlices.set(i, blackSlices.get(mINdex));
      blackSlices.set(mINdex, temp);
    }

    constructWheelFromSlices(blackSlices, evenSlices, oddSlices);

  }

  private void constructWheelFromSlices(ArrayList<Slice> blackSlices, ArrayList<Slice> evenSlices,
      ArrayList<Slice> oddSlices) {
    for (int i = 0; i < slices.size(); i++) {
      if (i % 5 == 0) {
        slices.set(i, blackSlices.remove(0));
      } else if (i % 2 == 0) {
        slices.set(i, evenSlices.remove(0));
      } else {
        slices.set(i, oddSlices.remove(0));
      }
    }
  }

  /* COMPLETED METHODS - YOU DO NOT NEED TO CHANGE THESE */

  /*
   * Creates a wheel with 20 preset slices
   */
  public GameWheel() {
    this(getStandardPrizes());
  }

  /*
   * Creates a wheel with 20 slices, using values from array parameter
   */
  public GameWheel(int[] prizes) {
    currentPos = 0;
    slices = new ArrayList<Slice>();
    for (int i = 0; i < 20; i++) {
      int pa = 0;
      String col = "blue";
      if (i < prizes.length)
        pa = prizes[i];
      if (i % 5 == 0)
        col = "black";
      else if (i % 2 == 1)
        col = "red";
      slices.add(new Slice(col, pa));
    }
  }

  /*
   * Spins the wheel by so that a different slice is selected. Returns that
   * slice (Note: the 10 slices following the current slice are more likely to
   * be returned than the other 10).
   */
  public Slice spinWheel() {
    // spin power between range of 1-50 (inclusive)
    int power = (int) (Math.random() * 50 + 1);
    int newPos = (currentPos + power) % slices.size();
    currentPos = newPos;
    return slices.get(currentPos);
  }

  public Slice getSlice(int i) {
    int sliceNum = i;
    if (i < 0 || i > 19)
      sliceNum = 0;
    return slices.get(sliceNum);
  }

  // Makes an array with a standard list of prizes
  private static int[] getStandardPrizes() {
    int[] arr = new int[20];
    for (int i = 0; i < 20; i++) {
      if (i % 5 == 0)
        arr[i] = i * 1000;
      else if (i % 2 == 1)
        arr[i] = i * 100;
      else
        arr[i] = i * 200;
    }
    return arr;
  }
}
