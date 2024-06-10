package calculator.operators;

import calculator.evaluator.Operand;

/**
 * 6/10/24 @ 10:51
 *
 * @ Author : Guiran LIU
 * Description:
 */
public class leftPar extends Operator {
    @Override
    public int priority() {
        return 0;
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        return null;
    }
}
