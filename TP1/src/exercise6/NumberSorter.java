package exercise6;

/**
 * Created by federicodonnarumma on 8/27/15.
 */
public class NumberSorter {

    public String sort(int x, int y, int z) {
        int temp;
        if (x > y) {
            temp = x;
            x = y;
            y = temp;
        }

        if (y > z) {
            temp = y;
            y = z;
            z = temp;
        }

        if (x > y) {
            temp = x;
            x = y;
            y = temp;
        }

        return x + ", " + y + ", " + z;
    }
}
