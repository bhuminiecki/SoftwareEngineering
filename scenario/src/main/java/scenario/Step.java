package main.java.scenario;

import java.util.ArrayList;

/**
 * Class containing a Step.
 */
public class Step {

    private String content;
    private ArrayList<Step> steps;

    /**
     * Construct for the class.
     */
    public Step() {
        super();
    }

    /**
     * Recursive method for counting the steps inside steps.
     * @return {Integer} ammount of steps.
     */
    public Integer countStepsRecursive() {
        Integer res = 0;
        for (Integer i = 0; i < this.steps.size(); i++) {
            res += this.steps.get(i).countStepsRecursive();
        }
        return res + this.steps.size();
    }

    /**
     * Recursive method for getting steps wihtout actors from inside steps.
     * @param actors {List} of actors in the scenario.
     * @return {List} of steps without actors.
     */
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

    /**
     * Constructor for the class, intiates members with value of parameters.
     * @param content {String} containing the content of the Step.
     * @param steps {List} of steps that the Step contains.
     */
    public Step(String content, ArrayList<Step> steps) {
        this.content = content;
        this.steps = steps;
    }

    /**
     * Getter for the Steps of the Step
     * @return {List} of {Step} of the Step.
     */
    public ArrayList<Step> getSteps() {
        return this.steps;
    }

    /**
     * Getter for the {String} content of the Step.
     * @return {String} step content.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the Steps of the Step.
     * @param steps {List} of {Step} to set.
     */
    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }

    /**
     * Sets the content of the Step.
     * @param content {String} to set.
     */
    public void setContent(String content) {
        this.content = content;
    }
}