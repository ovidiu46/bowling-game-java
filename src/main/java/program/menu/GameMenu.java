package program.menu;

import exceptii.NumarIntrodusException;
import program.joc.Joc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameMenu {
    private int aiPlayers;

    private List<String> realPlayerNames;

    public GameMenu(){
        realPlayerNames = new ArrayList<>();
        setPlayers();
        new Joc(aiPlayers, realPlayerNames);
    }

    private void setPlayers(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                try{
                    System.out.println("Introduceti numarul de jucatori reali: ");
                    String line = bufferedReader.readLine();
                    try{
                        int realPlayers = Integer.parseInt(line);
                        for (int i = 0; i < realPlayers; i++){
                            System.out.println("Nume jucator real #" + (i + 1) + ": ");
                            String nume = bufferedReader.readLine();
                            realPlayerNames.add(nume);
                        }
                        break;
                    }catch(Exception e) {
                        throw new NumarIntrodusException();
                    }
                }catch (NumarIntrodusException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (true){
                try{
                    System.out.println("Introduceti numarul de jucatori controlati de sistem: ");
                    String line = bufferedReader.readLine();
                    try{
                        aiPlayers = Integer.parseInt(line);
                        break;
                    }catch(Exception e) {
                        throw new NumarIntrodusException();
                    }
                }catch (NumarIntrodusException e) {
                    System.out.println(e.getMessage());
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
