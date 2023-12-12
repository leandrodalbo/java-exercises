package org.example;

import org.junit.Test;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringCalculatorTest {
    StringCalculator calculator = new StringCalculator();

    @Test
    public void shouldSumSimpleScenarios() {
        assertThat(calculator.add("")).isEqualTo(0);
        assertThat(calculator.add("1")).isEqualTo(1);
        assertThat(calculator.add("1,2")).isEqualTo(3);
        assertThat(calculator.add("1,2\n3")).isEqualTo(6);
        assertThat(calculator.add("10,31\n31")).isEqualTo(72);
    }

    @Test
    public void shouldSumWithCustomDelimiters() {
        assertThat(calculator.add("//;\n1;2")).isEqualTo(3);
        assertThat(calculator.add("//;\n11;22")).isEqualTo(33);
        assertThat(calculator.add("//;\n11;22,22")).isEqualTo(55);

    }

    @Test
    public void shouldThrowExceptionWithNegativeValues() {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> calculator.add("2,-4,3,-5"))
                .withMessage("Negatives not allowed [-4, -5]");
    }

    @Test
    public void shouldIgnoreGreaterThan1000Values() {
        assertThat(calculator.add("1001,2")).isEqualTo(2);
    }

    @Test
    public void delimitersCanHaveAnyLength() {
        assertThat(calculator.add("//[|||]\n1|||2|||3")).isEqualTo(6);
    }


    @Test
    public void willHandleMultipleDelimiters() {
        assertThat(calculator.add("//[|][%]\n1|2%3")).isEqualTo(6);
    }
}
