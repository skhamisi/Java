import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        
        Integer[] scores = {40, 60, 35, 20, 80, 110, 71};

        Arrays.sort(scores, Collections.reverseOrder());

        //scores.forEach(score -> System.out.println(score));
        int i = 1;
        for (int score : scores){
            System.out.println("Rank " + i + ": "+ score);
            i++; 
        }
    }
}
