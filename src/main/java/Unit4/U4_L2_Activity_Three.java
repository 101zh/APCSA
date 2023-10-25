package Unit4;

import java.util.Scanner;

public class U4_L2_Activity_Three {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int anotherLocation = 1;
        double largestLatitude = -90.0;
        double largestLongitude = -180.0;
        double smallestLatitude = 90.0;
        double smallestLongitude = 180.0;

        while (anotherLocation == 1) {
            System.out.println("Please enter the longitude:");
            double longitude = scanner.nextDouble();
            System.out.println("Please enter the latitude:");
            double latitude = scanner.nextDouble();

            boolean longitudeIsValid = -180.0 <= longitude && longitude <= 180.0;
            boolean latitudeIsValid = -90.0 <= latitude && latitude <= 90.0;

            if (longitudeIsValid && latitudeIsValid) {
                if (latitude > largestLatitude)
                    largestLatitude = latitude;
                if (latitude < smallestLatitude)
                    smallestLatitude = latitude;

                if (longitude > largestLongitude)
                    largestLongitude = longitude;
                if (longitude < smallestLongitude)
                    smallestLongitude = longitude;

            } else {
                System.out.println("Incorrect Latitude or Longitude ");
            }
            System.out.println("Would you like to enter another location?");

            anotherLocation = scanner.nextInt();
        }

        System.out.println("Farthest North: " + largestLatitude);
        System.out.println("Farthest South: " + smallestLatitude);
        System.out.println("Farthest East: " + largestLongitude);
        System.out.println("Farthest West: " + smallestLongitude);

        scanner.close();
    }
}
