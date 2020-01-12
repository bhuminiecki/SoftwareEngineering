package scenario;

public class KeywordStepCountVisitor implements Visitor {

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
        for (Integer i = 0; i < step.getSteps().size(); i++) {
            String stepContent = step.getSteps().get(i).getContent();
            if( stepContent.startsWith("IF") ||
                stepContent.startsWith("ELSE") ||
                stepContent.startsWith("FOR EACH")) {
                res += 1;
            }
        }
        return res;
    }     
}



