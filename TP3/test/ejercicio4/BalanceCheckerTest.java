package ejercicio4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by federicodonnarumma on 8/26/15.
 */
public class BalanceCheckerTest {

    private BalanceChecker instance = new BalanceChecker();
    @Test
    public void testIsBalanced() throws Exception {
        assertTrue(instance.isBalanced("{}"));
        assertTrue(instance.isBalanced("[]"));
        assertTrue(instance.isBalanced("()"));
        assertTrue(instance.isBalanced("[()]"));
        assertTrue(instance.isBalanced("{()}"));
        assertTrue(instance.isBalanced("{[()]}"));
        assertFalse(instance.isBalanced("{[()}"));
    }
}