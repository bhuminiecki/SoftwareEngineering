package scenario;

/**
 *   Visitor interface
 **/

public interface Visitor {
    /**
     * Each visitor needs to implement visit method which visits selected scenario
     * @param scenario Scenario to visit.
     */
    public void visit(Scenario scenario);
}