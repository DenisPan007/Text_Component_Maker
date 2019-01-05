package servise.parser;

import servise.composite.Component;
import entitty.Sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends BaseParser {
    private List<Component> list = new ArrayList<Component>();
    private static final String PATTERN_SENTENCE = "(\\t|\\s)?[^.!]*(\\.\\.\\.|\\.|!|\\?)";

    public List<Component> parse(String text) {
        list.clear();
        Pattern pattern = Pattern.compile(PATTERN_SENTENCE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            Sentence obj = new Sentence();
            String sentence = text.substring(start, end);
            char a = sentence.charAt(0);
            if (a == '\t' | a == ' ') {
                sentence = sentence.substring(1, sentence.length());
            }
            obj.add(next.parse(sentence));
            list.add(obj);
        }
        return list;
    }
}

