package me.sapphir0v.calculator;

import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

    public String greeting() {
        return "Добро пожаловать в калькулятор";
    }

    public String calculate(String action, int num1, int num2) {
        int result;
        action = calcSign(action);
        switch (action) {
            case "/" -> {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new IllegalArgumentException("Деление на ноль недопустимо.");
                }
            }
            case "+" -> result = num1 + num2;
            case "*" -> result = num1 * num2;
            case "-" -> result = num1 - num2;
            default -> throw new IllegalArgumentException("Неизвестная операция: " + action);
        }
        return num1 + " " + action + " " + num2 + " = " + result;
    }

    private String calcSign(String sign) {
        return switch (sign) {
            case "plus" -> "+";
            case "minus" -> "-";
            case "multiply" -> "*";
            case "divide" -> "/";
            default -> "?";
        };
    }
}
