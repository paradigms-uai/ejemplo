package exercise6;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class NormalizerTest {

    private Normalizer instance = new Normalizer(this.getClass().getResource("numbers.txt").getFile());

    @Test
    public void testVariance() throws IOException {
        instance.normalize();
        Scanner scanner = new Scanner(new File(this.getClass().getResource("numbers_result.txt").getFile()));
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();
        assertEquals("1\t1.00 100.00 45.00 1000.00", firstLine);
        assertEquals("2\t2.00 3.00 7.00 8.00", secondLine);
        assertFalse(scanner.hasNext());
    }
}