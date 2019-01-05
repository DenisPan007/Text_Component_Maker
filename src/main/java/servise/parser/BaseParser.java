package servise.parser;


public abstract class BaseParser implements Parser {
    protected Parser next;

    public BaseParser setNext(BaseParser next) {
        this.next = next;
        return  next;
    }
}
