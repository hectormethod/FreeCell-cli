import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: vwilson
 * Date: 10/26/13
 * Time: 9:16 PM
 */
public class StdRandom {
    public static Random random = new Random();

    public static int uniform(int i) {
        return random.nextInt(i);
    }
}
