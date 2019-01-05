package servise;

import interpreter.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionCounterInText {
    private static final String EXPRESSION_PATTERN = "\\(?\\d[\\d\\(\\)&\\>\\<\\|\\^]*";
    public String count(String initialText){
        String resultText = initialText;
        Pattern pattern = Pattern.compile(EXPRESSION_PATTERN);
        Matcher matcher = pattern.matcher(initialText);
        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            String exp = initialText.substring(start,end);
            Client client = new Client(exp);
            String result = client.calculate().toString();
            resultText = resultText.replace(exp,result);
        }
        return  resultText;
    }
}
