package program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import program.jucatori.ComputerPlayer;
import program.jucatori.Player;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TabelaScorTest {
    private Player player;

    @BeforeEach
    void setup(){
        player = new ComputerPlayer("Ai");
    }

    @Test
    @DisplayName("Scor Maxim Jucator")
    void calculeazaScorMaxim(){
        for (int i = 0; i < 9; i++) {
            player.addFirstBall(10);
        }
        for (int i = 0; i < 3; i++) {
            player.addLastBall(10);
        }
        player.calculeazaScor();
        Assertions.assertEquals(300, player.getScorFinal());
    }

    @Test
    @DisplayName("Scor Minim Jucator")
    void calculeazaScorMinim(){
        for (int i = 0; i < 9; i++) {
            player.addFirstBall(0);
            player.addSecondBall(0);
        }
        for (int i = 0; i < 2; i++) {
            player.addLastBall(0);
        }
        player.calculeazaScor();
        Assertions.assertEquals(0, player.getScorFinal());
    }

    @Test
    @DisplayName("Scor 1")
    void calculeazaScor1(){
        List<Integer> firstBalls = List.of(8, 5, 9, 10, 10, 5, 5, 6, 9);
        List<Integer> secondBalls = List.of(2, 4, 0, 5, 3, 3, 1);
        List<Integer> lastBalls = List.of(9, 1, 10);
        int j = 0;
        for (int i = 0; i < firstBalls.size(); i++) {
            player.addFirstBall(firstBalls.get(i));
            if (firstBalls.get(i) != 10){
                player.addSecondBall(secondBalls.get(j));
                j++;
            }
        }
        for(Integer ball : lastBalls){
            player.addLastBall(ball);
        }
        player.calculeazaScor();
        Assertions.assertEquals(149, player.getScorFinal());
    }

    @Test
    @DisplayName("Scor 2")
    void calculeazaScor2(){
        List<Integer> firstBalls = List.of(10, 4, 10, 10, 5, 0, 7, 6, 10);
        List<Integer> secondBalls = List.of(6, 5, 3, 3, 3);
        List<Integer> lastBalls = List.of(9, 0);
        int j = 0;
        for (int i = 0; i < firstBalls.size(); i++) {
            player.addFirstBall(firstBalls.get(i));
            if (firstBalls.get(i) != 10){
                player.addSecondBall(secondBalls.get(j));
                j++;
            }
        }
        for(Integer ball : lastBalls){
            player.addLastBall(ball);
        }
        player.calculeazaScor();
        Assertions.assertEquals(151, player.getScorFinal());
    }

    @Test
    @DisplayName("Scor 3")
    void calculeazaScor3(){
        List<Integer> firstBalls = List.of(10, 4, 10, 10, 5, 0, 7, 6, 10);
        List<Integer> secondBalls = List.of(6, 5, 3, 3, 3);
        List<Integer> lastBalls = List.of(9, 0);
        int j = 0;
        for (int i = 0; i < firstBalls.size(); i++) {
            player.addFirstBall(firstBalls.get(i));
            if (firstBalls.get(i) != 10){
                player.addSecondBall(secondBalls.get(j));
                j++;
            }
        }
        for(Integer ball : lastBalls){
            player.addLastBall(ball);
        }
        player.calculeazaScor();
        Assertions.assertEquals(151, player.getScorFinal());
    }

    @Test
    @DisplayName("Scor 4")
    void calculeazaScor4(){
        List<Integer> firstBalls = List.of(0, 1, 10, 5, 7, 6, 10, 10, 10);
        List<Integer> secondBalls = List.of(0, 9, 3, 3, 4);
        List<Integer> lastBalls = List.of(9, 1, 10);
        int j = 0;
        for (int i = 0; i < firstBalls.size(); i++) {
            player.addFirstBall(firstBalls.get(i));
            if (firstBalls.get(i) != 10){
                player.addSecondBall(secondBalls.get(j));
                j++;
            }
        }
        for(Integer ball : lastBalls){
            player.addLastBall(ball);
        }
        player.calculeazaScor();
        Assertions.assertEquals(181, player.getScorFinal());
    }
}