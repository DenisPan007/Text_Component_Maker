package servise.parser;

import composite.Component;
import entitty.Symbol;
import java.util.ArrayList;
import java.util.List;

public class SymbolParser extends BaseParser {
    private List<Component> list = new ArrayList<Component>();
    public List<Component> parse(String word){
        list.clear();
        char[] chars = word.toCharArray();
        for(char ch :chars){
            Symbol obj = new Symbol(ch);
            list.add(obj);
        }
        return list;
    }
}
