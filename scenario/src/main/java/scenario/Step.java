package main.java.scenario;

import java.util.ArrayList;

public class Step {

    private String content;
    private ArrayList<Step> steps;

    public Step() {
        super();
    }

    public Integer countStepsRecursive() {
        Integer res = 0;
        for (Integer i = 0; i < this.steps.size(); i++) {
            res += this.steps.get(i).countStepsRecursive();
        }
        return res + this.steps.size();
    }

    public ArrayList<String> stepsWithoutActorRecursive(ArrayList<String> actors) {

        Boolean stars_with_actor_flag = false;

        for (Integer i = 0; i < actors.size(); i++) {
            if ( this.getContent().startsWith(actors.get(i)) ) {
                stars_with_actor_flag = true;
            }
        }

        ArrayList<String> steps = new ArrayList<String>();

        if ( !stars_with_actor_flag ) {
            steps.add(this.getContent());
        }

        for (Integer i = 0; i < this.steps.size(); i++) {
            steps.addAll( this.steps.get(i).stepsWithoutActorRecursive(actors) );
        }

        return steps;
    }

    public Step(String content, ArrayList<Step> steps) {
        this.content = content;
        this.steps = steps;
    }

    public ArrayList<Step> getSteps() {
        return this.steps;
    }

    public String getContent() {
        return content;
    }
    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    public void getContent(String content) {
        this.content = content;
    }
}