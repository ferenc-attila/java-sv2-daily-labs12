package day02;

import java.util.ArrayList;
import java.util.List;

public class MathAlgorithms {

    public int greatestCommonDivisor(int firstNumber, int secondNumber) {
        validateNumbers(Math.abs(firstNumber), Math.abs(secondNumber));
        firstNumber = Math.abs(firstNumber);
        secondNumber = Math.abs(secondNumber);
        List<Integer> divisorsOfFirstNumber = addDivisors(firstNumber);
        List<Integer> divisorsOfSecondNumber = addDivisors(secondNumber);
        List<Integer> commonDivisors = commonDivisors(divisorsOfFirstNumber, divisorsOfSecondNumber);
        return getGreatestDivisor(commonDivisors);
    }

    private int getGreatestDivisor(List<Integer> commonDivisors) {
        int greatestDivisor = 1;
        for (int i = 0; i < commonDivisors.size(); i++) {
            if (commonDivisors.get(i) > greatestDivisor) {
                greatestDivisor = commonDivisors.get(i);
            }
        }
        return greatestDivisor;
    }

    private List<Integer> commonDivisors(List<Integer> divisorsOfFirstNumber, List<Integer> divisorsOfSecondNumber) {
        List<Integer> commonDivisors = new ArrayList<>();
        for (int i = 0; i < divisorsOfFirstNumber.size(); i++) {
            for (int j = 0; j < divisorsOfSecondNumber.size(); j++) {
                if (divisorsOfFirstNumber.get(i) == divisorsOfSecondNumber.get(j)) {
                    commonDivisors.add(divisorsOfFirstNumber.get(i));
                }
            }
        }
        return commonDivisors;
    }

    private List<Integer> addDivisors(int number) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    private void validateNumbers(int firstNumber, int secondNumber) {
        if (firstNumber == 0 || secondNumber == 0) {
            throw new IllegalArgumentException("None of the numbers can be zero!");
        }
    }

    public int greatestCommonDivisorSimpler(int firstNumber, int secondNumber) {
        validateNumbers(firstNumber, secondNumber);
        firstNumber = Math.abs(firstNumber);
        secondNumber = Math.abs(secondNumber);
        int greatestCommonDivisor = 1;
        for (int i = 2; i <= firstNumber && i <= secondNumber; i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                greatestCommonDivisor = i;
            }
        }
        return greatestCommonDivisor;
    }

    public int greatestCommonDivisorEuclides(int firstNumber, int secondNumber) {
        validateNumbers(firstNumber, secondNumber);
        firstNumber = Math.abs(firstNumber);
        secondNumber = Math.abs(secondNumber);
        while (firstNumber != secondNumber) {
            if (firstNumber > secondNumber) {
                firstNumber -= secondNumber;
            } else {
                secondNumber -= firstNumber;
            }
        }
        return firstNumber;
    }
}
