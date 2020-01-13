package scenario;

/*
    Visitor interface
*/

public interface VisitorWithIntegerParam extends Visitor {
    public void visitWithIntegerParam(Scenario scenario, Integer param);
}