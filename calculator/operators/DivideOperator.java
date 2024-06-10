package calculator.operators;

import calculator.evaluator.Operand;

import java.util.zip.ZipException;

/**
 * 6/8/24 @ 22:02
 *
 * @ Author : Guiran LIU
 * Description:
 */
public class DivideOperator extends Operator {
    @Override
    public int priority() {
        return 2;
    }

    @Override
    public Operand execute(Operand operandOne, Operand operandTwo) {
        int v1 = operandOne.getValue();
        int v2 = operandTwo.getValue();
        int result = v1 / v2;
//        if(v2 == 0){
//            throw new ArithmeticException();
//        }
        return new Operand(result);
    }
}
