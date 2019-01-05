package entitty;

import composite.Component;
import composite.Composite;

public class Sentence extends Composite {
    @Override
    public String getString(){
        StringBuilder strBuilder = new StringBuilder();
        for (Component component:children) {
            strBuilder.append(component.getString()).append(" ");
        }
        int length = strBuilder.length() - 1;
        strBuilder.setLength(length);
        strBuilder.append(".");
        return strBuilder.toString();
    }
}
