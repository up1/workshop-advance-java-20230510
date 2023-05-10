package org.example;

public class AdvantageRule implements TennisRule {

    private final String player1Name;
    private final String player2Name;

    public AdvantageRule(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public boolean check(int mScore1, int mScore2) {
        return (mScore1 >= 4 || mScore2 >= 4) && Math.abs(mScore1 - mScore2) == 1;
    }

    public String getResult(int mScore1, int mScore2) {
        int minusResult = mScore1 - mScore2;
        if (minusResult == 1) return "Advantage " + player1Name;
        return "Advantage " + player2Name;
    }
}
