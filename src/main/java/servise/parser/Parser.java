package servise.parser;

import servise.composite.Component;

import java.util.List;

public interface Parser {
    List<Component> parse(String text);
}
