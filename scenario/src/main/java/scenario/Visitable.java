package scenario;

/**
 *    Visitable interface
 **/

public interface Visitable {
    /**
     * Each visitable object needs to implement accept method which takes the the visitor as argument.
     * @param visitor object visiting this class
     */
    public void accept(Visitor visitor);
}