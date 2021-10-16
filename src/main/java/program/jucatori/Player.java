package program.jucatori;

import program.joc.TabelaScor;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private final String nume;
    private final List<Integer> firstBall;
    private final List<Integer> secondBall;
    private final List<Integer> bonusCount;
    private final List<Integer> score;
    private final List<Integer> lastBalls;

    public Player(String nume) {
        this.nume = nume;
        firstBall = new ArrayList<>();
        secondBall = new ArrayList<>();
        bonusCount = new ArrayList<>();
        score = new ArrayList<>();
        lastBalls = new ArrayList<>();
    }

    public abstract int roll(int popiceRamase);

    public void addFirstBall(int popiceDaramate){
        firstBall.add(popiceDaramate);
        if (popiceDaramate == 10){
            bonusCount.add(2);
            secondBall.add(0);
        }
    }

    public void addSecondBall(int popiceDaramate) {
        secondBall.add(popiceDaramate);
        if (firstBall.get(firstBall.size() - 1) + popiceDaramate == 10){
            bonusCount.add(1);
        }
        else {
            bonusCount.add(0);
        }
    }

    public void calculeazaScor(){
        TabelaScor.calculeazaScorFinal(firstBall, secondBall, bonusCount, score, lastBalls);
    }

    public String getNume() {
        return nume;
    }

    public void addLastBall(int popiceDaramate) {
        lastBalls.add(popiceDaramate);
    }

    public String getScor() {
        StringBuilder scor = new StringBuilder();
        scor.append(TabelaScor.getRunde(firstBall, secondBall, lastBalls));
        scor.append("\n");
        scor.append(TabelaScor.getScor(score));
        return scor.toString();
    }

    public int getScorFinal(){
        return score.get(score.size() - 1);
    }
}
