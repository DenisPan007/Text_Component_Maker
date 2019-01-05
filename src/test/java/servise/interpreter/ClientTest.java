package servise.interpreter;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {

    @Test
    public void calculate() {
        String expression = "(8^5|1&2<<(2|5>>2&71))|1200";
        Client client = new Client(expression);
        int result = client.calculate();
        int  expectedValue = (8^5|1&2<<(2|5>>2&71))|1200 ;
        assertEquals(expectedValue ,result);
    }
}