package entitty;

import composite.Component;

public class Symbol implements Component {
    private Character value;

    public Symbol(char value) {
        this.value = value;
    }

    public Symbol() {
    }
    public String getString(){
        return value.toString();
    }
}
