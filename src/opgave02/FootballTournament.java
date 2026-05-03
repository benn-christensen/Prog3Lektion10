package opgave02;

import java.util.*;

public class FootballTournament {
    private String name;
    private List<FootballMatch> matches = new ArrayList<>();

    public FootballTournament(String name) {
        this.name = name;
    }

    public void addMatch(FootballMatch match) {
        matches.add(match);
    }

    public void printTable() {
        Map<Team, Integer> points = new HashMap<>();
        Map<Team, Integer> goalDifference = new HashMap<>();
        Set<Team> teams = new HashSet<>();

        // 1. Beregn statistikker
        for (FootballMatch match : matches) {
            teams.add(match.getHomeTeam());
            teams.add(match.getAwayTeam());

            int homeGoals = match.getHomeTeamGoals();
            int awayGoals = match.getAwayTeamGoals();

            // Opdater målscore
            goalDifference.put(match.getHomeTeam(), goalDifference.getOrDefault(match.getHomeTeam(), 0) + (homeGoals - awayGoals));
            goalDifference.put(match.getAwayTeam(), goalDifference.getOrDefault(match.getAwayTeam(), 0) + (awayGoals - homeGoals));

            // Opdater point (3 for sejr, 1 for uafgjort)
            if (homeGoals > awayGoals) {
                points.put(match.getHomeTeam(), points.getOrDefault(match.getHomeTeam(), 0) + 3);
                points.put(match.getAwayTeam(), points.getOrDefault(match.getAwayTeam(), 0) + 0);
            } else if (homeGoals < awayGoals) {
                points.put(match.getAwayTeam(), points.getOrDefault(match.getAwayTeam(), 0) + 3);
                points.put(match.getHomeTeam(), points.getOrDefault(match.getHomeTeam(), 0) + 0);
            } else {
                points.put(match.getHomeTeam(), points.getOrDefault(match.getHomeTeam(), 0) + 1);
                points.put(match.getAwayTeam(), points.getOrDefault(match.getAwayTeam(), 0) + 1);
            }
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
}
