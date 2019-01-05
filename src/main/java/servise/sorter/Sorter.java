package servise.sorter;

import servise.composite.Component;
import servise.composite.Composite;
import exeption.NotValidArgumentException;

import java.util.Comparator;

public interface Sorter {
    Component sort(Composite composite, Comparator<Composite> comparator) throws NotValidArgumentException;
}
