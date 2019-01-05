package interpreter;

public class ExpressionNumber implements Expression{
    private int number;

    public ExpressionNumber(int number) {
        this.number = number;
    }
    public void interpret(Context context){
        context.pushValue(number);
    }
}
