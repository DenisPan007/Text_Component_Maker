package servise.sorter;

import composite.Component;
import composite.Composite;
import org.junit.Test;
import servise.CompositeBuilder;
import servise.FileReaderService;
import servise.comporator.ComporatorBySentenceAmount;
import servise.parser.*;

import java.util.Comparator;

import static org.junit.Assert.*;

public class SorterTextTest {

    @Test
    public void sort() throws Exception {
        Sorter sorter = new SorterText() ;
        String filePath = "src/test/resources/testText.txt";
        FileReaderService reader = new FileReaderService();
        String initialText = String.join("\n",reader.readFile(filePath));
        CompositeBuilder builder = new CompositeBuilder();
        BaseParser p1 = new ParagraphParser();
        BaseParser p2 = new SentenceParser();
        BaseParser p3 = new WordParser();
        BaseParser p4 = new SymbolParser();
        p1.setNext(p2).setNext(p3).setNext(p4);
        Component textComp = builder.build(initialText,p1);
        Comparator<Composite> comp = new ComporatorBySentenceAmount();
        Composite composite = (Composite) textComp;
        Component component = sorter.sort(composite,comp);
    }
}