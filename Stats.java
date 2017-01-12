import javax.swing.*;

public class Stats {

    private String playerName;
    private int difficulty;
    private int score;

    public Stats() {
        playerName = inputName();
        difficulty = inputDifficulty();
        score = 0;
    }

    public void reset(){
        playerName = inputName();
        difficulty = inputDifficulty();
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int increase){
        score += increase;
    }

    private String inputName() {
        return JOptionPane.showInputDialog("please enter your name");
    }

    private int inputDifficulty() {
        String ans = JOptionPane.showInputDialog("please enter the difficulty level, it should be an integer within 1~5");
        boolean test = false;
        if (ans!= null)
        test = ans.matches("[0-9]+");
        int result = 0;
        if (test){
            result = Integer.parseInt(ans);
        }

        if (result == 1 || result == 2 || result == 3 || result == 4 || result == 5) {
            return result;
        } else return inputDifficulty();

    }

    public String getPlayerName() {
        return playerName;
    }

    public int getDifficulty() {
        return difficulty;
    }
}
