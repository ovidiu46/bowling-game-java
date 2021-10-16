package program.jucatori;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class HumanPlayer extends Player{
    private Random random;

    public HumanPlayer(String nume) {
        super(nume);
        random = new Random();
    }

    @Override
    public int roll(int popiceRamase) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Apasa ENTER pentru a lovi...");
            bufferedReader.readLine();
            return random.nextInt(popiceRamase + 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
