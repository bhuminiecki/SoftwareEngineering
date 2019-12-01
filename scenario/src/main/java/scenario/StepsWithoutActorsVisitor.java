package scenario;

import java.util.ArrayList;

public class StepsWithoutActorsVisitor implements Visitor {

    public ArrayList<String> stepsWithoutActor;

    public void visit(Scenario scenario) {
        Step tempStep = new Step("STEPS WITHOUT ACTOR: ", scenario.getSteps());
        this.stepsWithoutActor = stepsWithoutActorRecursive(scenario.getActors(), tempStep);
    }

    public ArrayList<String> stepsWithoutActorRecursive(ArrayList<String> actors, Step step) {

        Boolean stars_with_actor_flag = false;

        for (Integer i = 0; i < actors.size(); i++) {
            if ( step.getContent().startsWith(actors.get(i)) ) {
                stars_with_actor_flag = true;
            }
        }

        ArrayList<String> steps = new ArrayList<String>();

        if ( !stars_with_actor_flag ) {
            steps.add(step.getContent());
        }

        for (Integer i = 0; i < step.getSteps().size(); i++) {
            steps.addAll( stepsWithoutActorRecursive(actors, step.getSteps().get(i)) );
        }

        return steps;
    }     
}