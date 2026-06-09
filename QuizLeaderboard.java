import java.util.TreeSet;

public class QuizLeaderboard {

    public static void main(String[] args) {

        TreeSet<Integer> scores = new TreeSet<>();

        scores.add(250);
        scores.add(300);
        scores.add(200);
        scores.add(350);
        scores.add(280);

        System.out.println("Leaderboard");

        for(Integer score : scores.descendingSet()) {
            System.out.println(score);
        }
    }
}