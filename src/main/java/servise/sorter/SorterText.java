package servise.sorter;

import composite.Component;
import composite.Composite;
import entitty.FullText;

import java.util.ArrayList;
import java.util.Comparator;


public class SorterText implements Sorter {
    public Component sort(Composite composite, Comparator comparator){
        ArrayList<Component> list = (ArrayList<Component>) composite.getChildren();
        list.sort(comparator);
        Composite resultComp = new FullText();
        resultComp.add(list);
        return  resultComp;
    }
}
