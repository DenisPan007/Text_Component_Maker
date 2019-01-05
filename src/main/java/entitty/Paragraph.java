package entitty;

import composite.Component;
import composite.Composite;

public class Paragraph extends Composite {
    @Override
    public String get(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append('\t');
        for (Component component:children) {
            strBuilder.append(component.get()).append(" ");
        }
        int length = strBuilder.length() - 1;
        strBuilder.setLength(length);
        return strBuilder.toString();
    }
}
