package scenario;

/*
    Visitor interface
*/

public interface VisitorWithStringParam extends Visitor {
    public void visitWithStringParam(Scenario scenario, String param);
}