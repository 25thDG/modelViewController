import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Puzzle {

    //Random int generator for the Game
    static List<Integer> randomIntegers() {
        List<Integer> rndomIntegers = new ArrayList<>();
        Random r = new Random();
        int i = 0;
        int nextInt = 1;
        while (i != 15) {
            nextInt = r.nextInt(1,16);
            if (!rndomIntegers.contains(nextInt)) {
                rndomIntegers.add(nextInt);
                i++;
            }
        }
        return rndomIntegers;
    }

}