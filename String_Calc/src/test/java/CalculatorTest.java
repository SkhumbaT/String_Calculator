import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void StringContainingOneNumber() throws Exception {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void StringContainingTwoNumbers() throws Exception {
        assertEquals(2, Calculator.add("1,1"));
    }

    @Test
    public void StringContainingMultipleNumbers() throws Exception {
        assertEquals(10, Calculator.add("1,2,3,4"));
    }

    @Test
    public void StringNumbersSeperatedByNewlineAndCommas() throws Exception {
        assertEquals (6, Calculator.add ("1\n2,3"));
    }

    @Test
    public void StringHandleDifferentDelimeter() throws Exception {
        assertEquals(3, Calculator.add("//;\n1;2"));
    }

    @Test
    public void StringHandleDifferentDelimeters4() throws Exception {
        assertEquals(3, Calculator.add("//4\n142"));
    }

    @Test
    public void StringWithNegNumbers() throws Exception{
        try {
            assertEquals(4, Calculator.add("-1,-2,3,4"));
        }
        catch (Exception e) {
            assertEquals("Negatives not allowed: -1,-2", e);
        }
    }

    @Test
    public void NumbersAbove1000AreIgnored() throws Exception {
        assertEquals(3, Calculator.add("1000,1,2"));
    }

    @Test
    public void DifferentDelimeterOfAnyLength() throws Exception {
        assertEquals(3, Calculator.add("//;;%;;\n1;2"));
    }

    @Test
    public void InvalidNumberFormat() throws Exception {
            assertEquals (3, Calculator.add ("//;\n1000;1;2;"));
    }
}