package calculator;

import calculator.annotation.Calculator;
import calculator.handler.CalculatorHandler;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("number1 = 1000, number2 = 2000\nВиберіть арифметичну дію:");
        String arithmeticAction = scanner.nextLine();
        try {
            if (!(arithmeticAction.equals("+") || arithmeticAction.equals("-") || arithmeticAction.equals("*") || arithmeticAction.equals("/")))
                throw new NoSuchArithmeticOperationException("Нема такої арифметичної дії");
        } catch (NoSuchArithmeticOperationException e) {
            System.err.println(e.getMessage());
        }
        CalculatorHandler calculatorHandler = new CalculatorHandler();
        Class<?> cl = CalculatorHandler.class;
        try {
            switch (arithmeticAction) {
                case "+" -> {
                    Method method = cl.getMethod("sum", int.class, int.class);
                    Calculator calculatorSum = method.getAnnotation(Calculator.class);
                    calculatorHandler.sum(calculatorSum.number1(), calculatorSum.number2());
                }
                case "-" -> {
                    Method method = cl.getMethod("sub", int.class, int.class);
                    Calculator calculatorSum = method.getAnnotation(Calculator.class);
                    calculatorHandler.sub(calculatorSum.number1(), calculatorSum.number2());
                }
                case "*" -> {
                    Method method = cl.getMethod("mul", int.class, int.class);
                    Calculator calculatorSum = method.getAnnotation(Calculator.class);
                    calculatorHandler.mul(calculatorSum.number1(), calculatorSum.number2());
                }
                case "/" -> {
                    Method method = cl.getMethod("div", int.class, int.class);
                    Calculator calculatorSum = method.getAnnotation(Calculator.class);
                    calculatorHandler.div(calculatorSum.number1(), calculatorSum.number2());
                }
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
