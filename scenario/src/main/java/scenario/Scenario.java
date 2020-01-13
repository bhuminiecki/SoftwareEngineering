package scenario;

import java.util.UUID;
import java.util.ArrayList;

/**
 * Class contains a scenario.
 */
public class Scenario implements Visitable {
	/**
     * Object containing UUID of the scenario.
     * Used for distinguishing scenarios.
     */
    private UUID uuid;
	
	/**
     * String containing the title of the scenario.
     */
    private String title;
	
	/**
     * List of actors of the scenario.
     */
    private ArrayList<String> actors;
	
	/**
     * List of steps of the scenario.
     */
    private ArrayList<Step> steps;

    /**
     * Class constructor, assigns a random, unique UUID.
     */
    public Scenario() {
        super();
        this.uuid = UUID.randomUUID();
    }

    /**
     * Class constructor, assigns a random, unique UUID and initiates members using passed arguments.
     * @param title {String} containing the title of the scenario.
     * @param actors A {List} containing actors of the scenario.
     * @param steps A {List} containing steps of the scenario.
     */
    public Scenario(String title, ArrayList<String> actors, ArrayList<Step> steps) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.actors = actors;
        this.steps = steps;
    }

    /**
     * Accepts a visitor.
     * @param visitor {Visitor} to accept.
     */
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    /**
     * Getter for the Scenario UUID.
     * @return {UUID} of the Scenario.
     */
    public UUID getId() {
        return this.uuid;
    }

    /**
     * Sets the UUID of the Scenario.
     * @param uuid {UUID} to set.
     */
    public void setId(UUID uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter for the Scenario Title.
     * @return {String} Title of the Scenario.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the title of the Scenario.
     * @param title {String} title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter for the actors of the Scenario.
     * @return {List} of actyors.
     */
    public ArrayList<String> getActors() {
        return this.actors;
    }

    /**
     * Sets the actors of the Scenario.
     * @param actors {List} of actors to set.
     */
    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    /**
     * Getter for the Steps of the Scenario.
     * @return {List} of {Step} of the Scenario.
     */
    public ArrayList<Step> getSteps() {
        return this.steps;
    }

    /**
     * Sets the Steps of the Scenario.
     * @param steps {List} of {Step} to set.
     */
    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }
}