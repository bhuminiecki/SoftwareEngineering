package scenario;

public class NumerationVisitor implements Visitor {

    public String numerated;

    public void visit(Scenario scenario) {
        Step tempStep = new Step("", scenario.getSteps());
        this.numerated = numerate(tempStep, "");
    }

    public String numerate(Step step, String prefix) {
        String res = prefix + step.getContent() + "\n";

        for (Integer i = 0; i < step.getSteps().size(); i++) {
            res += numerate( step.getSteps().get(i), prefix + Integer.toString(i + 1) + "." );
        }

        return res;

    }     
}



