package servise.comporator;

import composite.Component;
import composite.Composite;

import java.util.Comparator;
import java.util.List;

public class ComporatorBySentenceAmount implements Comparator<Composite> {
    public int compare(Composite c1, Composite c2){
        List<Component> list1 = c1.getChildren();
        List<Component> list2 = c2.getChildren();
        return list1.size() - list2.size();
    }
}
