package servise;

import servise.interpreter.ToReverseNotation;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ExpressionToReverseNotationTest {

    @Test
    public void reverse() {
        String expression = "(8^5)|1";
        List<String> expextedReverse = Arrays.asList("8","5","^","1","|");
        ToReverseNotation toReverseNotation = new ToReverseNotation();
        List<String> reverse = toReverseNotation.reverse(expression);
        assertEquals(expextedReverse,reverse);
    }
}