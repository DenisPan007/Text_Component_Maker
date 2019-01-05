package entitty;

import composite.Component;
import composite.Composite;

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
