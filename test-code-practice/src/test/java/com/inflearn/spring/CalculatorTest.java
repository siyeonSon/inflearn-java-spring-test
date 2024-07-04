package com.inflearn.spring;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    public void 덧셈_연산을_할_수_있다() {
        // given
        long num1 = 2;
        String operator = "+";
        long num2 = 3;
        Calculator calculator = new Calculator();

        // when
        long result = calculator.calculate(num1, operator, num2);

        // then
        assertEquals(5, result);  // junit assertion
        assertThat(result).isEqualTo(5);  // assertj assertion
    }

    @Test
    public void 뺄셈_연산을_할_수_있다() {
        // given
        long num1 = 5;
        String operator = "-";
        long num2 = 3;
        Calculator calculator = new Calculator();

        // when
        long result = calculator.calculate(num1, operator, num2);

        // then
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 곱셈_연산을_할_수_있다() {
        // given
        long num1 = 5;
        String operator = "*";
        long num2 = 3;
        Calculator calculator = new Calculator();

        // when
        long result = calculator.calculate(num1, operator, num2);

        // then
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void 나눗셈_연산을_할_수_있다() {
        // given
        long num1 = 10;
        String operator = "/";
        long num2 = 2;
        Calculator calculator = new Calculator();

        // when
        long result = calculator.calculate(num1, operator, num2);

        // then
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 잘못된_연산자가_들어오면_예외가_발생한다() {
        // given
        long num1 = 10;
        String operator = "x";
        long num2 = 2;
        Calculator calculator = new Calculator();

        // when
        Throwable thrown = catchThrowable(() -> calculator.calculate(num1, operator, num2));

        // then
        assertThat(thrown).isInstanceOf(InvalidOperatorException.class);
    }

}