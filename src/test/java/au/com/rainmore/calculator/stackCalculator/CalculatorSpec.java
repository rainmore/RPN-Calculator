package au.com.rainmore.calculator.stackCalculator;

import static org.junit.Assert.*;

import au.com.rainmore.calculator.expression.Symbol;
import au.com.rainmore.calculator.expression.Value;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorSpec {

    private CalculatorRender render = new CalculatorRender();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testPush() {

        Calculator calculator = new Calculator();
        calculator.push(new Value("5"));

        assertFalse(calculator.getStack().isEmpty());
        assertEquals(1, calculator.getStack().size());
        assertEquals("5", render.render(calculator));
    }

    @Test
    public void testClear() {

        Calculator calculator = new Calculator();
        calculator
                .push(new Value("5"))
                .push(new Value("2"))
                .clear()
        ;

        assertTrue(calculator.getStack().isEmpty());
        assertEquals("", render.render(calculator));
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParametersAdd1() {
        Calculator calculator = new Calculator();

        calculator.push(Symbol.ADD);
        assertEquals("", render.render(calculator));
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParametersAdd2() {
        Calculator calculator = new Calculator();


        calculator
                .push(new Value("5"))
                .push(Symbol.ADD);
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParametersSubtract1() {
        Calculator calculator = new Calculator();

        calculator.push(Symbol.SUBTRACT);
        assertEquals("", render.render(calculator));
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParametersSubtract2() {
        Calculator calculator = new Calculator();


        calculator
                .push(new Value("5"))
                .push(Symbol.SUBTRACT);
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParametersMultiple1() {
        Calculator calculator = new Calculator();

        calculator.push(Symbol.MULTIPLE);
        assertEquals("", render.render(calculator));
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParametersMultiple2() {
        Calculator calculator = new Calculator();


        calculator
                .push(new Value("5"))
                .push(Symbol.MULTIPLE);
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParametersDivide1() {
        Calculator calculator = new Calculator();

        calculator.push(Symbol.DIVIDE);
        assertEquals("", render.render(calculator));
    }

    @Test(expected = InsufficientParametersException.class)
    public void testInsufficientParametersDivide2() {
        Calculator calculator = new Calculator();

        calculator
                .push(new Value("5"))
                .push(Symbol.DIVIDE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsufficientParametersDivide3() {
        Calculator calculator = new Calculator();

        calculator
                .push(new Value("5"))
                .push(new Value("0"))
                .push(Symbol.DIVIDE);
    }


    @Test
    public void test1() {
        Calculator calculator = new Calculator();

        calculator.push(new Value("5"));
        calculator.push(new Value("2"));

        assertEquals("5 2", render.render(calculator));
    }

    @Test
    public void test2() {
        // TODO
    }

    @Test
    public void test3() {
        Calculator calculator = new Calculator();

        calculator.push(new Value("5"))
            .push(new Value("2"))
            .push(Symbol.SUBTRACT)
        ;

        assertEquals("3", render.render(calculator));

        calculator.push(new Value("3"))
            .push(Symbol.SUBTRACT);

        assertEquals("0", render.render(calculator));

        calculator.clear();

        assertEquals("", render.render(calculator));
    }

    @Test
    public void test4() {
        Calculator calculator = new Calculator();

        calculator.push(new Value("5"))
                .push(new Value("4"))
                .push(new Value("3"))
                .push(new Value("2"))
        ;

        assertEquals("5 4 3 2", render.render(calculator));

        calculator.undo();

        assertEquals("5 4 3", render.render(calculator));

        calculator.undo();

        assertEquals("5 4", render.render(calculator));

        calculator.push(Symbol.MULTIPLE);

        assertEquals("20", render.render(calculator));

        calculator.push(new Value("5"))
            .push(Symbol.MULTIPLE);

        assertEquals("100", render.render(calculator));

        calculator.undo();

        assertEquals("20 5", render.render(calculator));
    }

    @Test
    public void test5() {
        Calculator calculator = new Calculator();

        calculator.push(new Value("7"))
                .push(new Value("12"))
                .push(new Value("2"))
                .push(Symbol.DIVIDE)
        ;

        assertEquals("7 6", render.render(calculator));

        calculator.push(Symbol.MULTIPLE);

        assertEquals("42", render.render(calculator));

        calculator.push(new Value("4"))
            .push(Symbol.DIVIDE);

        assertEquals("10.5", render.render(calculator));
    }

    @Test
    public void test6() {
        Calculator calculator = new Calculator();

        calculator.push(new Value("1"))
            .push(new Value("2"))
            .push(new Value("3"))
            .push(new Value("4"))
            .push(new Value("5"))
        ;

        assertEquals("1 2 3 4 5", render.render(calculator));

        calculator.push(Symbol.MULTIPLE);

        assertEquals("1 2 3 20", render.render(calculator));

        calculator.clear()
            .push(new Value("3"))
            .push(new Value("4"))
            .push(Symbol.SUBTRACT)
        ;

        assertEquals("-1", render.render(calculator));
    }

    @Test
    public void test7() {
        Calculator calculator = new Calculator();

        calculator.push(new Value("1"))
            .push(new Value("2"))
            .push(new Value("3"))
            .push(new Value("4"))
            .push(new Value("5"))
        ;

        assertEquals("1 2 3 4 5", render.render(calculator));

        calculator.push(Symbol.MULTIPLE)
            .push(Symbol.MULTIPLE)
            .push(Symbol.MULTIPLE)
            .push(Symbol.MULTIPLE)
        ;

        assertEquals("120", render.render(calculator));
    }

    @Test
    public void test8() throws InsufficientParametersException {
        Calculator calculator = new Calculator();

        thrown.expect(InsufficientParametersException.class);

        calculator
            .push(new Value("1"))
            .push(new Value("2"))
            .push(new Value("3"))
            .push(Symbol.MULTIPLE)
            .push(new Value("5"))
            .push(Symbol.ADD)
            .push(Symbol.MULTIPLE)
            .push(Symbol.MULTIPLE)
            .push(new Value("6"))
            .push(new Value("5"))
        ;

        assertEquals("11", render.render(calculator));
        
    }

}
