package entitty;

import composite.Component;
import composite.Composite;

public class Sentence extends Composite {
    @Override
    public String get(){
        StringBuilder strBuilder = new StringBuilder();
        for (Component component:children) {
            strBuilder.append(component.get()).append(" ");
        }
        int length = strBuilder.length() - 1;
        strBuilder.setLength(length);
        strBuilder.append(".");
        return strBuilder.toString();
    }
}
