package Unit9;

// Have to get rid of package statement

import java.util.ArrayList;

public class UltimateTeam {
    ArrayList<UltimatePlayer> players;
    ArrayList<Coach> coaches;

    UltimateTeam(ArrayList<UltimatePlayer> players, ArrayList<Coach> coaches) {
        this.players = players;
        this.coaches = coaches;
    }

    public String getCutters() {
        String cutters = "";
        for (UltimatePlayer player : players) {
            if (player.getPosition().equals("cutter")) {
                cutters += player.toString() + "\n";
            }
        }

        return cutters;
    }

    public String getHandlers() {
        String handlers = "";
        for (UltimatePlayer player : players) {
            if (player.getPosition().equals("handler")) {
                handlers += player.toString() + "\n";
            }
        }

        return handlers;
    }

    @Override
    public String toString() {
        String team = "COACHES\n";

        for (Coach coach : coaches) {
            team += coach.toString() + "\n";
        }
        team += "\nPLAYERS\n";
        for (UltimatePlayer player : players) {
            team += player.toString() + "\n";
        }

        return team;
    }
}
