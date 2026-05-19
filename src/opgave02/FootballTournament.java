package opgave02;

import java.util.*;

public class FootballTournament extends Tournament{

    public FootballTournament(String name) {
        super(name);
    }

    @Override
    int getHomeTeamPoints(Match match) {
        return calcPoints(match.getHomeTeamGoals(), match.getAwayTeamGoals());
    }

    @Override
    int getAwayTeamPoints(Match match) {
        return calcPoints(match.getAwayTeamGoals(), match.getHomeTeamGoals());
    }

    private int calcPoints(int goals1, int goals2) {
        if (goals1 > goals2) {
            return 3;
        }
        if (goals1 < goals2) {
            return 0;
        }
        return 1;

    }
}
