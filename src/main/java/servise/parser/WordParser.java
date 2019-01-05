package servise.parser;

import servise.composite.Component;
import entitty.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends BaseParser {
    private List<Component> list = new ArrayList<Component>();
    private static final String PATTERN_WORD = "\\t?\\S*(\\s|\\.\\.\\.|\\.|!)";
    private static final String PATTERN_DELETE_DOTS = "[ ]|\\.|\\.\\.\\.|!";
    public List<Component> parse(String text) {
        list.clear();
        Pattern pattern = Pattern.compile(PATTERN_WORD);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            Word obj = new Word();
            String word = text.substring(start, end);
            word = word.replaceAll(PATTERN_DELETE_DOTS, "");
            obj.add(next.parse(word));
            list.add(obj);
        }
        return list;
    }
}