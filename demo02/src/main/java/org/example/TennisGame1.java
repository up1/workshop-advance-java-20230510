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

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, this.player1Name)) {
            mScore1++;
        } else if (Objects.equals(playerName, this.player2Name)) {
            mScore2++;
        }
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        int tempScore;

        if (isDeuce()) {
            return "Deuce";
        }

        if (เสมอในเกมส์ปกติไหม()) {
            String[] scoreText = new String[]{"Love", "Fifteen", "Thirty"};
            return scoreText[mScore1] + "-All";
        }

        if (mScore1 >= 4 || mScore2 >= 4) {
            int minusResult = mScore1 - mScore2;
            if (minusResult == 1) score = new StringBuilder("Advantage player1");
            else if (minusResult == -1) score = new StringBuilder("Advantage player2");
            else if (minusResult >= 2) score = new StringBuilder("Win for player1");
            else score = new StringBuilder("Win for player2");
        } else {
            for (int i = 1; i < 3; i++) {
                if (i == 1) tempScore = mScore1;
                else {
                    score.append("-");
                    tempScore = mScore2;
                }
                switch (tempScore) {
                    case 0 -> score.append("Love");
                    case 1 -> score.append("Fifteen");
                    case 2 -> score.append("Thirty");
                    case 3 -> score.append("Forty");
                }
            }
        }
        return score.toString();
    }

    private boolean เสมอในเกมส์ปกติไหม() {
        return mScore1 == mScore2 && mScore1 <= 2;
    }

    private boolean isDeuce() {
        return mScore1 == mScore2 && mScore1 > 2;
    }
}
