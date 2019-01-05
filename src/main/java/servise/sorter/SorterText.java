package servise.sorter;

import servise.composite.Component;
import servise.composite.Composite;
import entitty.FullText;
import exeption.NotValidArgumentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;


public class SorterText implements Sorter {
    private static final Logger LOGGER = LogManager.getLogger(SorterText.class);
    public Component sort(Composite composite, Comparator comparator) throws NotValidArgumentException {
        if (composite == null || comparator == null){
            LOGGER.error("Null argument found");
            throw new NotValidArgumentException("Null argument found");
        }
        ArrayList<Component> list = (ArrayList<Component>) composite.getChildren();
        list.sort(comparator);
        Composite resultComp = new FullText();
        resultComp.add(list);
        return  resultComp;
    }
}
