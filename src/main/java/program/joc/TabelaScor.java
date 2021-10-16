package program.joc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public final class TabelaScor {

    private TabelaScor(){}

    public static void calculeazaScorFinal(List<Integer> firstBall, List<Integer> secondBall, List<Integer> bonusCount, List<Integer> score, List<Integer> lastBalls){
        for (int i = 0; i < firstBall.size(); i++) {
            int scorRunda = 0;
            if (i > 0){
                scorRunda += score.get(i - 1);
            }
            switch (bonusCount.get(i)){
                case 1:
                    if (i == firstBall.size() - 1){
                        scorRunda += lastBalls.get(0);
                    }
                    else {
                        scorRunda += firstBall.get(i + 1);
                    }
                    break;
                case 2:
                    if (i == firstBall.size() - 1){
                        scorRunda += lastBalls.get(0) + lastBalls.get(1);
                    }
                    else if (i == firstBall.size() - 2){
                        if (firstBall.get(i + 1) == 10){
                            scorRunda += firstBall.get(i + 1) + lastBalls.get(0);
                        }
                        else{
                            scorRunda += firstBall.get(i + 1) + secondBall.get(i + 1);
                        }
                    }
                    else{
                        if (firstBall.get(i + 1) == 10){
                            scorRunda += firstBall.get(i + 1) + firstBall.get(i + 2);
                        }
                        else{
                            scorRunda += firstBall.get(i + 1) + secondBall.get(i + 1);
                        }
                    }
            }
            scorRunda += firstBall.get(i);
            scorRunda += secondBall.get(i);
            score.add(scorRunda);
        }
        score.add(lastBalls.stream().mapToInt(x -> x).sum() + score.get(score.size() - 1));
    }

    public static String getRunde(List<Integer> firstBall, List<Integer> secondBall, List<Integer> lastBalls){
        StringBuilder rowBalls = new StringBuilder();
        for (int i = 0; i < firstBall.size(); i++) {
            rowBalls.append('|');
            //STRIKE?
            if (firstBall.get(i) < 10){
                rowBalls.append(firstBall.get(i));
                rowBalls.append(' ');
                if (i < secondBall.size()){
                    //SPARE?
                    if (firstBall.get(i) + secondBall.get(i) == 10){
                        rowBalls.append('/');
                    }else{
                        rowBalls.append(secondBall.get(i));
                    }
                }
                else{
                    rowBalls.append('_');
                }
            }
            else{
                rowBalls.append("10 ");
            }
        }
        int lovituriRamase = 9 - firstBall.size();
        for (int i = 0; i < lovituriRamase; i++) {
            rowBalls.append("|_ _");
        }

        rowBalls.append('|');
        for (int i = 0; i < lastBalls.size(); i++) {
            if (i != 0){
                rowBalls.append(' ');
            }
            if (lastBalls.get(i) == 10){
                rowBalls.append("10");
            }
            else if(i > 0 && lastBalls.get(i) + lastBalls.get(i - 1) == 10) {
                rowBalls.append("/");
            }
            else{
                rowBalls.append(lastBalls.get(i));
            }
        }
        for (int i = 0; i < 3 - lastBalls.size(); i++) {
            rowBalls.append(" _");
        }
        rowBalls.append('|');
        return rowBalls.toString();
    }

    public static void printScore(List<Optional<Integer>> score){
        StringBuilder scoreRow = new StringBuilder();
        for (int i = 0; i < score.size(); i++) {
            if (score.get(i).isPresent()){
                scoreRow.append(score.get(i).get());
            }
            else{
                scoreRow.append('?');
            }
            scoreRow.append("\t");
        }
        System.out.println(scoreRow);
    }

    public static String getScor(List<Integer> scor){
        return scor.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\t"));
    }
}
