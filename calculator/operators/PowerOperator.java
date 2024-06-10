package calculator.operators;

import calculator.evaluator.Operand;

/**
 * 6/8/24 @ 22:03
 *
 * @ Author : Guiran LIU
 * Description:
 */
public class PowerOperator extends Operator {
    @Override
    public int priority() {
        return 3;
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        int v1 = operandOne.getValue();
        int v2 = operandTwo.getValue();
        int result = (int) Math.pow(v1, v2);
        return new Operand(result);
    }
}
