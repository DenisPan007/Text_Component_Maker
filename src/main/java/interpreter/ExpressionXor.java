package interpreter;

public class ExpressionXor implements Expression {
    public void interpret(Context context) {
        context.pushValue((context.popValue() ^ context.popValue()));
    }
}
