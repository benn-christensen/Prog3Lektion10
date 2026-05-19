package opgave02;

import java.util.*;

public abstract class Tournament {
    private String name;
    private List<Match> matches = new ArrayList<>();

    public void addMatch(Match match) {
        matches.add(match);
    }

    public Tournament(String name) {
        this.name = name;
    }

    public void printTable() {
        Map<Team, Integer> points = new HashMap<>();
        Map<Team, Integer> goalDifference = new HashMap<>();
        Set<Team> teams = new HashSet<>();

        for (Match match : matches) {
            teams.add(match.getHomeTeam());
            teams.add(match.getAwayTeam());

            int homeGoals = match.getHomeTeamGoals();
            int awayGoals = match.getAwayTeamGoals();
            points.put(match.getHomeTeam(),
                    points.getOrDefault(match.getHomeTeam(), 0)
                            + getHomeTeamPoints(match));
            points.put(match.getAwayTeam(),
                    points.getOrDefault(match.getAwayTeam(), 0) +
                            getAwayTeamPoints(match));

        }
        // 2. Sorter holdene
        List<Team> sortedTeams = new ArrayList<>(teams);
        sortedTeams.sort((t1, t2) -> {
            int p1 = points.getOrDefault(t1, 0);
            int p2 = points.getOrDefault(t2, 0);
            if (p1 != p2) return p2 - p1; // Flest point først

            int gd1 = goalDifference.getOrDefault(t1, 0);
            int gd2 = goalDifference.getOrDefault(t2, 0);
            return gd2 - gd1; // Bedste målscore som tie-breaker
        });

        // 3. Print tabellen
        System.out.println("Stilling i " + name + ":");
        System.out.printf("%-15s | %-6s | %-8s%n", "Hold", "Point", "Målscore");
        System.out.println("---------------------------------------");
        for (Team team : sortedTeams) {
            System.out.printf("%-15s | %-6d | %-8d%n",
                    team.getName(),
                    points.getOrDefault(team, 0),
                    goalDifference.getOrDefault(team, 0));
        }
    }

    abstract int getHomeTeamPoints(Match match);

    abstract int getAwayTeamPoints(Match match);
}
