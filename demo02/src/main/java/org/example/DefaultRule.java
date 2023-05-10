package org.example;

public class DefaultRule implements TennisRule {
    String[] scoreText = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
    public DefaultRule(String s, String s1) {

    }

    @Override
    public boolean check(int mScore1, int mScore2) {
        return true;
    }

    @Override
    public String getResult(int mScore1, int mScore2) {
        return scoreText[mScore1] + "-" + scoreText[mScore2];
    }
}
