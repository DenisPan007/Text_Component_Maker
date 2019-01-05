package entitty;

import servise.composite.Component;
import servise.composite.Composite;

public class FullText extends Composite {
    @Override
    public String getString() {
        StringBuilder strBuilder = new StringBuilder();
        for (Component component : children) {
            strBuilder.append(component.getString()).append('\n');
        }
        return strBuilder.toString();
    }

}
