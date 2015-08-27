package exercise2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by federicodonnarumma on 8/27/15.
 */
public class EvenCounterTest {

    private EvenCounter instance = new EvenCounter();

    @Test
    public void testEven() {
        List numbers = new ArrayList<Integer>();
        numbers.add(22222);
        numbers.add(123456);
        numbers.add(353535);
        assertEquals(instance.getHighestEvenCount(numbers), 22222);
    }

}