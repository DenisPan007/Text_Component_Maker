package interpreter;

public class ExpressionRightShift implements  Expression {
    public void interpret(Context context) {
        int arg1 = context.popValue();
        int arg2 = context.popValue();
        int result = arg2 >> arg1;
        context.pushValue(result);
    }
}
