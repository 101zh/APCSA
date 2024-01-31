package Unit8;

// Have to get rid of package statement

public class TemperatureMonth {

    private double[][] temperatures;

    public TemperatureMonth(double[][] t) {
        temperatures = t;
    }

    public double[] getMaxTempWeekly() {
        double[] week = new double[temperatures.length];

        for (int w = 0; w < week.length; w++) {
            double max = temperatures[w][0];
            for (int d = 1; d < temperatures[w].length; d++) {
                if (temperatures[w][d] > max) {
                    max = temperatures[w][d];
                }
            }
            week[w] = max;
        }

        return week;
    }

    public double[] getMinTempWeekly() {
        double[] week = new double[temperatures.length];

        for (int w = 0; w < week.length; w++) {
            double min = temperatures[w][0];
            for (int d = 1; d < temperatures[w].length; d++) {
                if (temperatures[w][d] < min) {
                    min = temperatures[w][d];
                }
            }
            week[w] = min;
        }

        return week;
    }

    public double getRange() {
        double[] mins = getMinTempWeekly();
        double[] maxes = getMaxTempWeekly();

        double min = mins[0];
        double max = maxes[0];

        for (int w = 1; w < mins.length && w < maxes.length; w++) {
            if (mins[w] < min) {
                min = mins[w];
            }
            if (maxes[w] > max) {
                max = maxes[w];
            }
        }

        return max - min;
    }

    public double getCertainTemp(int week, int day) {
        return temperatures[week][day];
    }

}
