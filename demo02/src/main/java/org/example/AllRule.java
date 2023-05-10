package org.example;

public class AllRule implements TennisRule {
    String[] scoreText = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    public AllRule(String s, String s1) {

    }

    @Override
    public boolean check(int mScore1, int mScore2) {
        return mScore1 == mScore2 && mScore1 <= 2;
    }

    @Override
    public String getResult(int mScore1, int mScore2) {
        return scoreText[mScore1] + "-All";
    }
}
