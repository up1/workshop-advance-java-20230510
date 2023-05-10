package org.example;

public class WinnerRule implements TennisRule {
    private final String player1Name;
    private final String player2Name;

    public WinnerRule(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public boolean check(int mScore1, int mScore2) {
        return (mScore1 >= 4 || mScore2 >= 4) && Math.abs(mScore1 - mScore2) >= 2;
    }

    public String getResult(int mScore1, int mScore2) {
        int minusResult = mScore1 - mScore2;
        if (minusResult >= 2) return "Win for " + player1Name;
        return "Win for "+ player2Name;
    }
}
