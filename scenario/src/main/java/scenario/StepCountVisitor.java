package scenario;


/**
 * Visitor class for counting steps in a scenario
 */
public class StepCountVisitor implements Visitor {

    /**
     * Counter of steps
     */
    public Integer stepCount;

    /**
     * Visit method implementation, visists scenario and counts it's steps
     * @param scenario Scenario to visit.
     */
    public void visit(Scenario scenario) {
        Step tempStep = new Step(null, scenario.getSteps());
        this.stepCount = stepCount(tempStep);
    }

    /**
     * Method for counting substeps of a step
     * @param step Step to count substeps
     * @return ammount of steps in a scenario
     */
    public Integer stepCount(Step step) {

        Integer res = 0;
        for (Integer i = 0; i < step.getSteps().size(); i++) {
            res += stepCount(step.getSteps().get(i));
        }
        return res + step.getSteps().size();

    }     
}
