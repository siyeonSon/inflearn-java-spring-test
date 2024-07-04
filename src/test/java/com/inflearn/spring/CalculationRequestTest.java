package com.inflearn.spring;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculationRequestTest {

    @Test
    public void 유효한_숫자를_파싱할_수_있다() {
        // given
        String[] parts = new String[] {"2", "+", "3"};

        // when
        CalculationRequest calculationRequest = new CalculationRequest(parts);

        // then
        assertEquals(2, calculationRequest.getNum1());
        assertEquals("+", calculationRequest.getOperator());
        assertEquals(3, calculationRequest.getNum2());
    }

    @Test
    public void 세자리_숫자가_넘어가는_유효한_숫자를_파싱할_수_있다() {
        // given
        String[] parts = new String[] {"232", "+", "123"};

        // when
        CalculationRequest calculationRequest = new CalculationRequest(parts);

        // then
        assertEquals(232, calculationRequest.getNum1());
        assertEquals("+", calculationRequest.getOperator());
        assertEquals(123, calculationRequest.getNum2());
    }

    @Test
    public void 유효한_길이의_문자열이_아닌_경우_예외를_던진다() {
        // given
        String[] parts = new String[] {"2", "+"};

        // when & then
        assertThrows(BadRequestException.class,
                () -> new CalculationRequest(parts));
    }

    @Test
    public void 유효하지_않은_연산자가_들어온_경우_예외를_던진다() {
        // given
        String[] parts = new String[] {"2", "x", "3"};

        // when & then
        assertThrows(InvalidOperatorException.class,
                () -> new CalculationRequest(parts));
    }

    @Test
    public void 유효하지_않은_길이의_연산자가_들어온_경우_예외를_던진다() {
        // given
        String[] parts = new String[] {"2", "+-", "3"};

        // when & then
        assertThrows(InvalidOperatorException.class,
                () -> new CalculationRequest(parts));
    }
}