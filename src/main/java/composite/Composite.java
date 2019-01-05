package composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Composite implements Component {
    protected List<Component> children = new ArrayList<Component>();

    public void add(Component... components){
        List<Component> listComp = Arrays.asList(components);
        add(listComp);

    }
    public void add(List<Component> components){
        children.addAll(components);

    }
    public List<Component> getChildren(){
        return new ArrayList<>(children);
    }
    public void remove(Component component){
        children.remove(component);
    }
    public String getString(){
        StringBuilder strBuilder = new StringBuilder();
        for (Component component:children) {
            strBuilder.append(component.getString());
        }
        return strBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Composite)) return false;

        Composite composite = (Composite) o;

        return getChildren() != null ? getChildren().equals(composite.getChildren()) : composite.getChildren() == null;
    }

    @Override
    public int hashCode() {
        return getChildren() != null ? getChildren().hashCode() : 0;
    }
}
