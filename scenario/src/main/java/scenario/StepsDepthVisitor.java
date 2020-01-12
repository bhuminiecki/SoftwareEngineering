package scenario;

import java.util.ArrayList;

public class StepsDepthVisitor implements VisitorWithParam {

    public Step stepsWithDepth;

    public void visit(Scenario scenario) {
        return;
    }

    public void visitWithParam(Scenario scenario, Integer depth) {
        this.stepsWithDepth = stepsWithDepthRecursive(
            new Step("STEPS WITH DEPTH: ", scenario.getSteps()), 
            depth);
    }

    public Step stepsWithDepthRecursive(Step step, Integer depth) {
        
        Step temp = new Step(step.getContent(), new ArrayList<Step>());

        if(depth == 0) {
            return temp;
        }

        ArrayList<Step> tempSteps = new ArrayList<Step>();
        for (Integer i = 0; i < step.getSteps().size(); i++) {
            tempSteps = temp.getSteps();
            tempSteps.add(
                stepsWithDepthRecursive(step.getSteps().get(i), depth - 1)
            );
            temp.setSteps(tempSteps);
        }


        return temp;
    }     
}



