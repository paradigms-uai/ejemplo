package exercise1;

import org.junit.Assert;
import org.junit.Test;

public class LineTest {

    private Line instance = new Line();

    @Test
    public void testBelongs() throws Exception {
        Assert.assertTrue("the point does not belongs to the line", this.instance.belongs(1, 10));
    }
}

