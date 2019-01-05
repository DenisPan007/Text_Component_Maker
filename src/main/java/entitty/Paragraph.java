package entitty;

import servise.composite.Component;
import servise.composite.Composite;

public class Paragraph extends Composite {
    @Override
    public String getString(){
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append('\t');
        for (Component component:children) {
            strBuilder.append(component.getString()).append(" ");
        }
        int length = strBuilder.length() - 1;
        strBuilder.setLength(length);
        return strBuilder.toString();
    }
}
