package org.example;

import java.util.Objects;

/*
1 Set
6+ game
6-0
0-6

game 1
0-0 => Love-All
1-0 => Fifteen-Love   15 => 30 => 40 => Game
2-0 = Thirty-Love
3-0 = Forty-Love
4-0 = Player A win

1-0

game 2
0-0 => Love-All
0-1 => Love-Fifteen
1-1 => Fifteen-All
2-2 => Thirty-All
3-2 => Forty-Thirty
3-3 => Forty-Forty => Deuce
3-4 => B Advantage
4-4 => Deuce
5-4 => A Advantage
6-4 => Player A win

2-0

 */

public class TennisGame1 implements TennisGame {

    private int mScore1 = 0;
    private int mScore2 = 0;
    private final String player1Name;
    private final String player2Name;
    private TennisRule[] rules;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;

        initRules();
    }

    private void initRules() {
        rules = new TennisRule[]{
                new WinnerRule(player1Name, player2Name),
                new AdvantageRule(player1Name, player2Name),
                new DeuceRule(),
                new AllRule(),
                new DefaultRule()
        };
    }

    public String getScore() {
        for (TennisRule rule : rules) {
            if (rule.check(mScore1, mScore2)) {
                return rule.getResult(mScore1, mScore2);
            }
        }
        throw new RuntimeException("Invalid rule !!");
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, this.player1Name)) {
            mScore1++;
        } else if (Objects.equals(playerName, this.player2Name)) {
            mScore2++;
        }
    }
}
