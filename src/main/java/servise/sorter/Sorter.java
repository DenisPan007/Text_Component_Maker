package servise.sorter;

import composite.Component;
import composite.Composite;

import java.util.Comparator;

public interface Sorter {
    Component sort(Composite composite, Comparator<Composite> comparator);
}
