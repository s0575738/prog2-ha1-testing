package prog2.ha1.testing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display correct number after pressing digit keys")
    void testDigitInput() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(4);
        calc.pressDigitKey(2);

        String expected = "42";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after adding two positive numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        String expected = "4";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //TODO hier weitere Tests erstellen
    // First green test
    @Test
    @DisplayName("should display result after multiplying two numbers")
    void calculatorIsAbleToMultiply() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(5);
        calc.pressEqualsKey();
        assertEquals("25", calc.readScreen());
    }
    // First red test
    @Test
    @DisplayName("should be able to display the result of adding two negative numbers")
    void calculatorCanAddTwoNegativeNumbers() {
        Calculator calc = new Calculator();
        calc.pressNegativeKey();
        calc.pressDigitKey(4);
        System.out.println(calc.readScreen());
        calc.pressBinaryOperationKey("+");
        calc.pressNegativeKey();
        calc.pressDigitKey(3);
        calc.pressEqualsKey();
        System.out.println(calc.readScreen());
        assertEquals("-7", calc.readScreen());
    }
    // Second red test
    @Test
    @DisplayName("should display the result after you have done the operation and then deleted a digit")
    void calculatorAbleToUseClearKey() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressClearKey();
        calc.pressDigitKey(5);
        calc.pressEqualsKey();
        System.out.println(calc.readScreen());
        assertEquals("1", calc.readScreen());
    }
}

