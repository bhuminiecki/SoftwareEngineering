package main.java.scenario;

import java.util.UUID;
import java.util.ArrayList;

public class Scenario {

    private UUID uuid;
    private String title;
    private ArrayList<String> actors;
    private ArrayList<Step> steps;


    public Scenario() {
        super();
        this.uuid = UUID.randomUUID();
    }

    public Scenario(String title, ArrayList<String> actors, ArrayList<Step> steps) {
        this.uuid = UUID.randomUUID();
        this.title = title;
        this.actors = actors;
        this.steps = steps;
    }

    public ArrayList<String> stepsWithoutActor() {
        ArrayList<String> steps = new ArrayList<String>();

        for (Integer i = 0; i < this.steps.size(); i++) {
            steps.addAll(this.steps.get(i).stepsWithoutActorRecursive(this.actors));
        }

        return steps;
    }

    public Integer countSteps() {
        Integer res = 0;
        for (Integer i = 0; i < this.steps.size(); i++) {
            res += this.steps.get(i).countStepsRecursive();
        }
        return res + this.steps.size();
    }
    
    public UUID getId() {
        return this.uuid;
    }

    public void setId(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getActors() {
        return this.actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<Step> getSteps() {
        return this.steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }
}