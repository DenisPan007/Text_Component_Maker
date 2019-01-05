package interpreter;

public class ExpressionOr implements Expression{
    public void interpret(Context context) {
        context.pushValue((context.popValue() | context.popValue()));
    }
}
