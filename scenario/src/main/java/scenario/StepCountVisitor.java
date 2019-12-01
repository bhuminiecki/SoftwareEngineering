package scenario;

public class StepCountVisitor implements Visitor {

    public Integer stepCount;

    public void visit(Scenario scenario) {
        Step tempStep = new Step(null, scenario.getSteps());
        this.stepCount = stepCount(tempStep);
    }

    public Integer stepCount(Step step) {

        Integer res = 0;
        for (Integer i = 0; i < step.getSteps().size(); i++) {
            res += stepCount(step.getSteps().get(i));
        }
        return res + step.getSteps().size();

    }     
}



