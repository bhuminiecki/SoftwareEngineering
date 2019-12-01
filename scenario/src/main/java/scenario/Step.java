package scenario;

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