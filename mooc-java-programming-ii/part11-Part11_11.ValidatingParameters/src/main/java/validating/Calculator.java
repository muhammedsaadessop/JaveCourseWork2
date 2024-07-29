package validating;

public class Calculator {

    public int factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial only works with non-negative numbers.");
        }
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public int binomialCoefficent(int setSize, int subsetSize) {
        if (setSize < 0 || subsetSize < 0 || subsetSize > setSize) {
            throw new IllegalArgumentException("Parameters must be non-negative and subsetSize must not exceed setSize.");
        }
        return factorial(setSize) / (factorial(subsetSize) * factorial(setSize - subsetSize));
    }
}
