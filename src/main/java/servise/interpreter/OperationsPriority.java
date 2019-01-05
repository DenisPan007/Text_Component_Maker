package servise.interpreter;

public class OperationsPriority {
    public int count(String str){
        switch (str){
            case ">>":
                return 1;
            case "<<":
                return 1;
            case "&":
                return 2;
            case "^":
                return 3;
            case "|":
                return 4;
            default:
                return Integer.MAX_VALUE;
        }

    }
}
