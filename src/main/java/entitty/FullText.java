package entitty;

import composite.Component;
import composite.Composite;

public class FullText extends Composite {
    @Override
    public String get() {
        StringBuilder strBuilder = new StringBuilder();
        for (Component component : children) {
            strBuilder.append(component.get()).append('\n');
        }
        return strBuilder.toString();
    }

}
