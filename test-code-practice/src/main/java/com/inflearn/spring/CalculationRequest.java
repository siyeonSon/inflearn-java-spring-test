package com.inflearn.spring;

public class CalculationRequest {

    private final long num1;
    private final long num2;
    private final String operator;

    public CalculationRequest(String[] parts) {
        if(parts.length != 3) {
            throw new BadRequestException();
        }
        String operators = parts[1];
        if(operators.length() != 1 || isInvalidOperator(operators)) {
            throw new InvalidOperatorException();
        }

        this.num1 = Long.parseLong(parts[0]);
        this.num2 = Long.parseLong(parts[2]);
        this.operator = parts[1];
    }

    private boolean isInvalidOperator(String operators) {
        return !operators.equals("+") &&
                !operators.equals("-") &&
                !operators.equals("*") &&
                !operators.equals("/");
    }

    public long getNum1() {
        return num1;
    }

    public long getNum2() {
        return num2;
    }

    public String getOperator() {
        return operator;
    }

}
