package program.jucatori;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;


class PlayerTest {

    private Player player;

    @BeforeEach
    public void setup(){
        player = new ComputerPlayer("Test");
    }

    @Test
    @DisplayName("Adauga lovitura Strike")
    void adaugaLovituraStrike(){
        player.addFirstBall(10);
        try {
            Field field1 = player.getClass().getSuperclass().getDeclaredField("firstBall");
            Field field2 = player.getClass().getSuperclass().getDeclaredField("secondBall");
            Field field3 = player.getClass().getSuperclass().getDeclaredField("bonusCount");

            field1.setAccessible(true);
            field2.setAccessible(true);
            field3.setAccessible(true);

            List<Integer> firstBall = (List<Integer>) field1.get(player);
            List<Integer> secondBall = (List<Integer>) field2.get(player);
            List<Integer> bonusCount = (List<Integer>) field3.get(player);

            Assertions.assertEquals(1, firstBall.size());
            Assertions.assertEquals(10, firstBall.get(0));

            Assertions.assertEquals(1, secondBall.size());
            Assertions.assertEquals(0, secondBall.get(0));

            Assertions.assertEquals(1, bonusCount.size());
            Assertions.assertEquals(2, bonusCount.get(0));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Adauga lovitura Spare")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void adaugaLovituraSpare(int lovitura1){
        int lovitura2 = 10 - lovitura1;
        player.addFirstBall(lovitura1);
        player.addSecondBall(lovitura2);

        try {
            Field field1 = player.getClass().getSuperclass().getDeclaredField("firstBall");
            Field field2 = player.getClass().getSuperclass().getDeclaredField("secondBall");
            Field field3 = player.getClass().getSuperclass().getDeclaredField("bonusCount");

            field1.setAccessible(true);
            field2.setAccessible(true);
            field3.setAccessible(true);

            List<Integer> firstBall = (List<Integer>) field1.get(player);
            List<Integer> secondBall = (List<Integer>) field2.get(player);
            List<Integer> bonusCount = (List<Integer>) field3.get(player);

            Assertions.assertEquals(1, firstBall.size());
            Assertions.assertEquals(lovitura1, firstBall.get(0));

            Assertions.assertEquals(1, secondBall.size());
            Assertions.assertEquals(lovitura2, secondBall.get(0));

            Assertions.assertEquals(1, bonusCount.size());
            Assertions.assertEquals(1, bonusCount.get(0));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("Adauga lovitura Normala")
    @RepeatedTest(value = 20)
    void adaugaLovituraNormala(){
        Random r = new Random();
        int lovitura1 = r.nextInt(10);
        int lovitura2 = r.nextInt(10 - lovitura1);

        player.addFirstBall(lovitura1);
        player.addSecondBall(lovitura2);

        try {
            Field field1 = player.getClass().getSuperclass().getDeclaredField("firstBall");
            Field field2 = player.getClass().getSuperclass().getDeclaredField("secondBall");
            Field field3 = player.getClass().getSuperclass().getDeclaredField("bonusCount");

            field1.setAccessible(true);
            field2.setAccessible(true);
            field3.setAccessible(true);

            List<Integer> firstBall = (List<Integer>) field1.get(player);
            List<Integer> secondBall = (List<Integer>) field2.get(player);
            List<Integer> bonusCount = (List<Integer>) field3.get(player);

            Assertions.assertEquals(1, firstBall.size());
            Assertions.assertEquals(lovitura1, firstBall.get(0));

            Assertions.assertEquals(1, secondBall.size());
            Assertions.assertEquals(lovitura2, secondBall.get(0));

            Assertions.assertEquals(1, bonusCount.size());
            Assertions.assertEquals(0, bonusCount.get(0));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}