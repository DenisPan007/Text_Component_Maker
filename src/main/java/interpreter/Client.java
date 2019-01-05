package interpreter;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private ArrayList<Expression> listExpression;
    ToReverseNotation toReverseNotation = new ToReverseNotation();

    public Client(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);
    }

    private void parse(String expression) {
        List<String> expressionList = toReverseNotation.reverse(expression);
        for (String lexeme : expressionList) {
            if (lexeme.isEmpty()) {
                continue;
            }
            switch (lexeme) {
                case "|":
                    listExpression.add(new ExpressionOr());
                    break;
                case "^":
                    listExpression.add(new ExpressionXor());
                    break;
                case "&":
                    listExpression.add(new ExpressionAnd());
                    break;
                case ">>":
                    listExpression.add(new ExpressionRightShift());
                    break;
                case "<<":
                    listExpression.add(new ExpressionLeftShift());
                    break;
                default:
                    if (lexeme.matches("\\d+")) {
                        int value = Integer.valueOf(lexeme);
                        listExpression.add(new ExpressionNumber(value));
                    }
            }
        }
    }

    public Integer calculate() {
        Context context = new Context();
        for (Expression terminal : listExpression) {
            terminal.interpret(context);
        }
        return context.popValue();
    }
}