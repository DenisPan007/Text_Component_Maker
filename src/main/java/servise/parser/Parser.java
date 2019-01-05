package servise.parser;

import composite.Component;

import java.util.List;

public interface Parser {
    List<Component> parse(String text);
}
