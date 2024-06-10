package calculator.operators;

import calculator.evaluator.Operand;

/**
 * 6/10/24 @ 10:52
 *
 * @ Author : Guiran LIU
 * Description:
 */
public class rightPar extends Operator {
    @Override
    public int priority() {
        return 0;
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        return null;
    }

    @Override
    public String toString() {
        return ")";//important!!!
    }
}
