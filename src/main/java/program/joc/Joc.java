package program.joc;

import program.jucatori.ComputerPlayer;
import program.jucatori.HumanPlayer;
import program.jucatori.Player;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Joc {
    private List<Player> players;

    public Joc(int aiPlayers, List<String> realPlayerNames){
        players = new ArrayList<>();
        setPlayers(aiPlayers, realPlayerNames);
        System.out.println();

        startJoc();
        calculeazaScor();
        afiseazaScoruri();
        afiseazaCastigator();
    }

    private void afiseazaCastigator(){
        int scorCastigator = players.get(0).getScorFinal();
        String numeCastigator = players.get(0).getNume();
        for (int i = 1; i < players.size(); i++) {
            if (scorCastigator < players.get(i).getScorFinal()){
                scorCastigator = players.get(i).getScorFinal();
                numeCastigator = players.get(i).getNume();
            }
        }
        int numarCastigatori = 0;
        for (int i = 0; i < players.size(); i++) {
            if (scorCastigator == players.get(i).getScorFinal()){
                numarCastigatori++;
            }
        }
        if (numarCastigatori > 1){
            System.out.print("Castigatorii sunt ");
            for (int i = 0; i < players.size(); i++) {
                if (scorCastigator == players.get(i).getScorFinal()){
                    System.out.print(players.get(i).getNume() + " ");
                }
            }
            System.out.println("cu scorul de " + scorCastigator + " puncte.");
        }
        else{
            for (int i = 0; i < players.size(); i++) {
                if (scorCastigator == players.get(i).getScorFinal()){
                    System.out.println("Castigatorul jocului este " + players.get(i).getNume() + " cu scorul de " + scorCastigator + " puncte.");
                }
            }
        }

    }

    private void afiseazaScoruri(){
        for(Player player : players){
            System.out.println("\nTabela scor " + player.getNume());
            System.out.println(player.getScor());
        }
    }

    private void calculeazaScor(){
        for(Player player : players){
            player.calculeazaScor();
        }
    }

    private void joacaPrimele9Runde(){
        for (int i = 0; i < 9; i++) {
            System.out.println("\nIncepe Runda #" + (i + 1));
            for (int j = 0; j < players.size(); j++) {
                System.out.println("Este randul lui " + players.get(j).getNume());
                int popiceDaramate1 = players.get(j).roll(10);
                players.get(j).addFirstBall(popiceDaramate1);
                if(popiceDaramate1 == 10){
                    System.out.println(players.get(j).getNume() + " a dat STRIKE!");
                }
                else{
                    System.out.println(players.get(j).getNume() + " a daramat " + popiceDaramate1 + " popice.");
                    int popiceDaramate2 = players.get(j).roll(10 - popiceDaramate1);
                    players.get(j).addSecondBall(popiceDaramate2);
                    if (popiceDaramate1 + popiceDaramate2 == 10){
                        System.out.println(players.get(j).getNume() + " a dat SPARE!");
                    }
                    else{
                        System.out.println(players.get(j).getNume() + " a daramat " + popiceDaramate2 + " popice.");
                    }
                }
            }
        }
    }

    /**
     Posibilitati ultima runda:
     strike strike strike
     strike strike  0-9
     strike  0-9   spare
     strike  0-9    0-9
     0-9   spare strike
     0-9   spare   0-9
     0-9	0-9
     */
    private void joacaUltimaRunda(){
        System.out.println("\nIncepe ultima runda");
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Este randul lui " + players.get(i).getNume());
            int popiceDaramate1 = players.get(i).roll(10);
            players.get(i).addLastBall(popiceDaramate1);
            if (popiceDaramate1 == 10){
                System.out.println(players.get(i).getNume() + " a dat STRIKE!");
                int popiceDaramate2 = players.get(i).roll(10);
                players.get(i).addLastBall(popiceDaramate2);
                if (popiceDaramate2 == 10){
                    System.out.println(players.get(i).getNume() + " a dat STRIKE!");
                    int popiceDaramate3 = players.get(i).roll(10);
                    players.get(i).addLastBall(popiceDaramate3);
                    if (popiceDaramate3 == 10){
                        System.out.println(players.get(i).getNume() + " a dat STRIKE!");
                    }
                    else{
                        System.out.println(players.get(i).getNume() + " a daramat " + popiceDaramate3 + " popice.");
                    }
                }else{
                    System.out.println(players.get(i).getNume() + " a daramat " + popiceDaramate2 + " popice.");
                    int popiceDaramate3 = players.get(i).roll(10);
                    players.get(i).addLastBall(popiceDaramate3);
                    if (popiceDaramate2 + popiceDaramate3 == 10){
                        System.out.println(players.get(i).getNume() + " a dat SPARE!");
                    }
                    else{
                        System.out.println(players.get(i).getNume() + " a daramat " + popiceDaramate3 + " popice.");
                    }
                }
            }
            else {
                System.out.println(players.get(i).getNume() + " a daramat " + popiceDaramate1 + " popice.");
                int popiceDaramate2 = players.get(i).roll(10 - popiceDaramate1);
                players.get(i).addLastBall(popiceDaramate2);
                if (popiceDaramate1 + popiceDaramate2 == 10){
                    System.out.println(players.get(i).getNume() + " a dat SPARE!");
                    int popiceDaramate3 = players.get(i).roll(10);
                    players.get(i).addLastBall(popiceDaramate3);
                    if (popiceDaramate3 == 10){
                        System.out.println(players.get(i).getNume() + " a dat STRIKE!");
                    }
                    else{
                        System.out.println(players.get(i).getNume() + " a daramat " + popiceDaramate3 + " popice.");
                    }
                }
                else{
                    System.out.println(players.get(i).getNume() + " a daramat " + popiceDaramate2 + " popice.");
                }
            }
        }
    }

    private void startJoc(){
        joacaPrimele9Runde();
        joacaUltimaRunda();
    }

    private void setPlayers(int aiPlayers, List<String> realPlayerNames){
        for (int i = 0; i < aiPlayers; i++) {
            players.add(new ComputerPlayer("Ai #" + (i + 1)));
        }
        for (String realPlayerName : realPlayerNames) {
            players.add(new HumanPlayer(realPlayerName));
        }
        Collections.shuffle(players);
    }
}
