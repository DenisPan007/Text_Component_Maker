package servise.parser;

import servise.composite.Component;
import entitty.Paragraph;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends BaseParser {
    private List<Component> list = new ArrayList<Component>();
    private static final String PATTERN_PARAGRAPH = "\\t?[^\\t]*\\t";

    public List<Component> parse(String text) {
        Pattern pattern = Pattern.compile(PATTERN_PARAGRAPH);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            Paragraph obj = new Paragraph();
            String paragraph = text.substring(start, end);
            obj.add(next.parse(paragraph));
            list.add(obj);
        }
        return list;
    }
}