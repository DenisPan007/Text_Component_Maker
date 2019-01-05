package servise;

import servise.composite.Component;
import servise.composite.Composite;
import entitty.FullText;
import servise.parser.Parser;

public class CompositeBuilder {
    public Component build(String text, Parser chain) {
        ExpressionCounterInText expCount = new ExpressionCounterInText();
        text = expCount.count(text);
        Composite textComposite = new FullText();
        textComposite.add(chain.parse(text));
        return textComposite;
    }
}
