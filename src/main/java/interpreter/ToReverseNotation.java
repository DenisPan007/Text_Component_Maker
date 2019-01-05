package interpreter;

import interpreter.OperationsPriority;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToReverseNotation {
    private static final String DIGIT_PATTERN = "\\d+";
    private static final String OPERATOR_PATTERN = "<<|>>|\\||\\^|\\&|\\(|\\)";
    private static final String DIGIT_AND_OPERATOR_PATTERN = DIGIT_PATTERN + "|" + OPERATOR_PATTERN;

    private List<String> splitter(String expression){
        List<String> expressionList = new ArrayList<String>();
        Pattern pattern = Pattern.compile(DIGIT_AND_OPERATOR_PATTERN);
        Matcher matcher = pattern.matcher(expression);
        String buff;
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            buff = expression.substring(start,end);
            expressionList.add(buff);
        }
        return expressionList;
    }
    public List<String> reverse(String expression){
        OperationsPriority priority = new OperationsPriority();
        List<String> reverseExpressionList = new ArrayList<String>();
        Deque<String> stack = new ArrayDeque<String>();
        List<String> expressionList = splitter(expression);
        String buff;
        for (String str: expressionList) {
            if (str.matches(DIGIT_PATTERN)){
                reverseExpressionList.add(str);
            }
            else if (str.equals("(")){
                stack.push(str);
            }
            else if (str.equals(")")){
                buff = stack.pop();
                while(!buff.equals("(")&&!stack.isEmpty()){
                    reverseExpressionList.add(buff);
                    buff = stack.pop();
                }
            }
            else if (str.matches(OPERATOR_PATTERN)){
                while (!stack.isEmpty() && priority.count(str)>= priority.count(stack.peek())){
                    reverseExpressionList.add(stack.pop());
                }
                stack.push(str);

            }
        }
        reverseExpressionList.addAll(stack);
        return reverseExpressionList;
    }
}
