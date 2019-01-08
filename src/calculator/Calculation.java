package calculator;

public class Calculation {

    private final String number1;
    private final String number2;
    private final String operation;
    private String result;

    public Calculation(String number1, String number2, String operation) {
        this.number1 = number1;
        this.number2 = number2;
        this.operation = operation;
    }

    public String getResult() {
        return result;
    }

    public void compute() {
        int num1, num2;
        try {
            num1 = Integer.parseInt(number1);
        } catch (Exception e) {
            throw new RuntimeException("Number 1 is not a number");
        }
        try {
            num2 = Integer.parseInt(number2);
        } catch (Exception e) {
            throw new RuntimeException("Number 2 is not a number");
        }
        switch (operation) {
            case "+":
                result = Integer.toString(num1 + num2);
                break;
            case "-":
                result = Integer.toString(num1 - num2);
                break;
            case "*":
                result = Integer.toString(num1 * num2);
                break;
            case "/":
                if (num2 == 0) {
                    throw new RuntimeException("Number 2 must not be zero in division");
                }
                result = Integer.toString(num1 / num2);
                break;
            default:
                throw new RuntimeException("Operation invalid");
        }
    }
}
