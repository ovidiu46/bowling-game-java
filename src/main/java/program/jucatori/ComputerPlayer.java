package program.jucatori;

import java.util.Random;

public class ComputerPlayer extends Player{
    private Random random;

    public ComputerPlayer(String nume) {
        super(nume);
        random = new Random();
    }

    @Override
    public int roll(int popiceRamase) {
        return random.nextInt(popiceRamase + 1);
    }
}
