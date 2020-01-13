package scenario;

import java.util.ArrayList;

public class StepsWithGivenWordVisitor implements VisitorWithStringParam {

    public ArrayList<String> stepsWithWord;

    public void visit(Scenario scenario) {
        return;
    }

    public void visitWithStringParam(Scenario scenario, String word) {
        Step tempStep = new Step("STEPS WITH WORD: ", scenario.getSteps());
        this.stepsWithWord = stepsWithWordRecursive(tempStep, word);
    }

    public ArrayList<String> stepsWithWordRecursive(Step step, String word) {

        ArrayList<String> steps = new ArrayList<String>();

        if ( step.getContent().contains(word) ) {
            steps.add(step.getContent());
        }         

        for (Integer i = 0; i < step.getSteps().size(); i++) {
            steps.addAll( stepsWithWordRecursive(step.getSteps().get(i), word));
        }

        return steps;
    }     
}