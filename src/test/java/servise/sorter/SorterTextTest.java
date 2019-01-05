package servise.sorter;

import composite.Component;
import composite.Composite;
import entitty.FullText;
import entitty.Paragraph;
import entitty.Sentence;
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
        Comparator<Composite> comp= new ComporatorBySentenceAmount();
        Sorter sorter = new SorterText() ;
        Sentence s1 = new Sentence();
        Sentence s2 = new Sentence();
        Sentence s3 = new Sentence();
        Sentence s4 = new Sentence();
        Sentence s5 = new Sentence();
        Sentence s6 = new Sentence();
        Sentence s7 = new Sentence();
        Sentence s8 = new Sentence();
        Paragraph p1 = new Paragraph();
        Paragraph p2 = new Paragraph();
        Paragraph p3 = new Paragraph();
        Paragraph p4 = new Paragraph();
        FullText t1 = new FullText();
        FullText tExpected = new FullText();
        p1.add(s1,s2,s3);
        p2.add(s4,s5);
        p3.add(s6);
        p4.add(s7,s8);
        t1.add(p1,p2,p3,p4);
        tExpected.add(p3,p2,p4,p1);
        Component component = sorter.sort(t1,comp);
        assertEquals(tExpected, component);
    }
}