package calculator.evaluator;

/**
 * Operand class used to represent an operand
 * in a valid mathematical expression.
 */
public class Operand {
    private int value;

    /**
     * construct operand from string token.
     */
    public Operand(String token) {// covert token into int
        this.value = Integer.parseInt(token);
    }

    /**
     * construct operand from integer
     */
    public Operand(int value) {
        this.value = value;
    }

    /**
     * return value of operand
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Check to see if given token is a valid
     * operand.
     */
    public static boolean check(String token) {// check if it is a num
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Invalid token.Cannot convert into Integer");
            return false;
        }
    }

//    public static void main(String[] args) {
////        Operand operand = new Operand("c");
//        check("4123523");
//    }
}
