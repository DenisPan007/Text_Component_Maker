package interpreter;

public class ExpressionAnd implements Expression {
    public void interpret(Context context) {
        context.pushValue((context.popValue() & context.popValue()));
    }
}
