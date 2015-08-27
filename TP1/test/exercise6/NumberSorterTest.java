package exercise6;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by federicodonnarumma on 8/27/15.
 */
public class NumberSorterTest {

    private NumberSorter instance = new NumberSorter();

    @Test
    public void sort() {
        assertEquals("7, 9, 10", instance.sort(10, 7, 9));
    }
}