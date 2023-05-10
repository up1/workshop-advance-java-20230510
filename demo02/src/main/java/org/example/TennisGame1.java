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
        String[] scoreText = new String[]{"Love", "Fifteen", "Thirty", "Forty"};

        // Win
        if ((mScore1 >= 4 || mScore2 >= 4 ) && Math.abs(mScore1 - mScore2) >= 2 ) {
            int minusResult = mScore1 - mScore2;
            if (minusResult >= 2) return "Win for " + player1Name;
            return "Win for "+ player2Name;
        }

        // Advantage
        if ((mScore1 >= 4 || mScore2 >= 4) && Math.abs(mScore1 - mScore2) == 1) {
            int minusResult = mScore1 - mScore2;
            if (minusResult == 1) return "Advantage " + player1Name;
            return "Advantage " + player2Name;
        }

        if (isDeuce()) {
            return "Deuce"; // Early return
        }

        if (เสมอในเกมส์ปกติไหม()) {
            return scoreText[mScore1] + "-All";
        }

        return scoreText[mScore1] + "-" + scoreText[mScore2];
    }

    private boolean เสมอในเกมส์ปกติไหม() {
        return mScore1 == mScore2 && mScore1 <= 2;
    }

    private boolean isDeuce() {
        return mScore1 == mScore2 && mScore1 > 2;
    }
}
