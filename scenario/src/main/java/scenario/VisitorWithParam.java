package scenario;

/*
    Visitor interface
*/

public interface VisitorWithParam extends Visitor {
    public void visitWithParam(Scenario scenario, Integer param);
}