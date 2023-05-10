package org.example;

public class DeuceRule implements TennisRule {
    public DeuceRule(String s, String s1) {

    }

    @Override
    public boolean check(int mScore1, int mScore2) {
        return mScore1 == mScore2 && mScore1 > 2;
    }

    @Override
    public String getResult(int mScore1, int mScore2) {
        return "Deuce";
    }
}
