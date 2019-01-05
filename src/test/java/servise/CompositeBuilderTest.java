package servise;


import composite.Component;
import exeption.ReadFileException;
import org.junit.Test;
import servise.parser.*;

import static org.junit.Assert.*;

public class CompositeBuilderTest {

    @Test
    public void build() throws ReadFileException {
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
        String expectedText = "\tIt has survived - not only (five) centuries, but also the leap into 52 electronic typesetting, remaining 0 essentially 0 unchanged. It was popularised in the 5 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. \n" +
                " It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using 79 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here, making it look like readable English. \n" +
                " It is a 1213 established fact that a reader will be of a page when looking at its layout.\n" +
                "\tBye.\n";
        textComp.get();
        assertEquals(expectedText, textComp.get());
    }
}