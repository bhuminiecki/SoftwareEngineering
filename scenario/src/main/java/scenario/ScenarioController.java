package scenario;

import java.util.*;
import java.io.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST controller of the scenario.
 * Exposes REST endpoints of the application.
 */
@RestController
public class ScenarioController {
	/**
     * Logger object used to create a simple logging facade.
     */
    private Logger logger; 

	/**
     * Class constructor, calls LoggerFactory and assigns returned value to the member: logger.
     */
    public ScenarioController () {
        this.logger = LoggerFactory.getLogger(ScenarioController.class);
    }

    /**
     * Endpoint for getting scenarios.
     * @param title {String} of the scenario.
     * @return scenario to match the title or exception message in case no scenario is matched.
     */
    @GetMapping("/scenarios")
    public String getScenarioByTitle(@RequestParam(value="title", defaultValue="") String title) {
        for (int i = 0; i < Application.scenarios.size(); i++) {

            Scenario scenario = Application.scenarios.get(i);

            if ( scenario.getTitle().equals(title) ) {
                
                ObjectMapper mapper = new ObjectMapper();
                
                try {
                    
                    return mapper.writeValueAsString(scenario);

                } catch ( IOException e ) {

                    e.printStackTrace();
                    logger.error("Unable to return the scenario");
                    return "Unable to return the scenario";
                }
            }
        }
        logger.error("Unable to find scenario with that title");
        return "Unable to find scenario with that title";
    }

    /**
     * Endpoint for setting scenario.
     * @param json payload containing object data.
     */
    @PostMapping("/scenarios")
    public void addScenario(@RequestBody String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {

            Scenario scenario = objectMapper.readValue(json, Scenario.class);
            Application.scenarios.add( scenario );

        } catch ( IOException e ) {
            e.printStackTrace();
            return;
        }
    }

    /**
     * Endpoint for getting the ammount of steps in the scenario.
     * @param id {String} of the scenario to match.
     * @return {Integer} ammount of steps in the scenario or -1 in case no scenario is matched.
     */
    @GetMapping("/stepcount")
    public Integer getScenarioStepCountById(@RequestParam(value="id", defaultValue="") String id) {
        for (int i = 0; i < Application.scenarios.size(); i++) {

            Scenario scenario = Application.scenarios.get(i);

            if ( scenario.getId().toString().equals(id) ) {

                StepCountVisitor stepCountVisitor = new StepCountVisitor();
                stepCountVisitor.visit(scenario);
                
                return stepCountVisitor.stepCount;
            }  
        }
        return -1;
    }

    /**
     * Endpoint for getting the ammount of steps starting with a keyword in the scenario.
     * @param id {String} of the scenario to match.
     * @return {Integer} amount of steps starting with a keyword in the scenario or -1 in case no scenario is matched.
     */
    @GetMapping("/keywordstepcount")
    public Integer getScenarioStepCountWithKeywordById(@RequestParam(value="id", defaultValue="") String id) {
        for (int i = 0; i < Application.scenarios.size(); i++) {

            Scenario scenario = Application.scenarios.get(i);

            if ( scenario.getId().toString().equals(id) ) {

                KeywordStepCountVisitor keywordStepCountVisitor = new KeywordStepCountVisitor();
                keywordStepCountVisitor.visit(scenario);

                return keywordStepCountVisitor.stepCount;
            }
        }
        return -1;
    }

    /**
     * Endpoint for getting steps containing a given word of a scenario.
     * @param id {String} of the scenario to match.
     * @param word {String} the word to search.
     * @return payload containing steps without actors or an exception message in case no steps are found or scenario is not matched.
     */
    @GetMapping("/stepswithword")
    public String getScenariosWithGivenWord(@RequestParam(value="id", defaultValue="") String id, @RequestParam(value="word", defaultValue="") String word) {
        for (int i = 0; i < Application.scenarios.size(); i++) {

            Scenario scenario = Application.scenarios.get(i);

            if ( scenario.getId().toString().equals(id) ) {


                ObjectMapper mapper = new ObjectMapper();

                try {

                    StepsWithGivenWordVisitor stepsWithGivenWordVisitor = new StepsWithGivenWordVisitor();
                    stepsWithGivenWordVisitor.visitWithStringParam(scenario, word);

                    return mapper.writeValueAsString( stepsWithGivenWordVisitor.stepsWithWord );

                } catch ( IOException e ) {

                    e.printStackTrace();
                    logger.error("Unable to return the steps");
                    return "Unable to return the steps";

                }
            }
        }
        logger.error("Unable to find the scenario");
        return "Unable to find the scenario";
    }

    /**
     * Endpoint for getting the steps of a scenario to a certain depth.
     * @param id {String} of the scenario to match.
     * @param depth {Integer} of the depth.
     * @return {String} payload containing steps to certain depth or an exception message in case no steps are found or scenario is not matched.
     */
    @GetMapping("/stepswithdepth")
    public String getScenarioStepsWithDepth(@RequestParam(value="id", defaultValue="") String id, @RequestParam(value="depth", defaultValue="") Integer depth) {
        for (int i = 0; i < Application.scenarios.size(); i++) {

            Scenario scenario = Application.scenarios.get(i);

            if ( scenario.getId().toString().equals(id) ) {


                ObjectMapper mapper = new ObjectMapper();

                try {

                    StepsDepthVisitor stepsDepthVisitor = new StepsDepthVisitor();
                    stepsDepthVisitor.visitWithIntegerParam(scenario, depth);

                    return mapper.writeValueAsString( stepsDepthVisitor.stepsWithDepth );

                } catch ( IOException e ) {

                    e.printStackTrace();
                    logger.error("Unable to return the steps");
                    return "Unable to return the steps";

                }
            }
        }
        logger.error("Unable to find the scenario");
        return "Unable to find the scenario";
    }

    /**
     * Endpoint for getting steps without actors of a scenario.
     * @param id {String} of the scenario to match.
     * @return payload containing steps without actors or an exception message in case no steps are found or scenario is not matched.
     */
    @GetMapping("/nonactorsteps")
    public String getScenariosWithoutActor(@RequestParam(value="id", defaultValue="") String id) {
        for (int i = 0; i < Application.scenarios.size(); i++) {

            Scenario scenario = Application.scenarios.get(i);

            if ( scenario.getId().toString().equals(id) ) {
                

                ObjectMapper mapper = new ObjectMapper();
                
                try {
                    
                    StepsWithoutActorsVisitor stepsWithoutActorsVisitor = new StepsWithoutActorsVisitor();
                    stepsWithoutActorsVisitor.visit(scenario);

                    return mapper.writeValueAsString( stepsWithoutActorsVisitor.stepsWithoutActor );

                } catch ( IOException e ) {

                    e.printStackTrace();
                    logger.error("Unable to return the steps");
                    return "Unable to return the steps";

                }
            }  
        }
        logger.error("Unable to find the scenario");
        return "Unable to find the scenario";
    }

	/**
     * Endpoint for getting numerated steps of a scenario.
     * @param id {String} of the scenario to match.
     * @return {String} containing numerated steps of a scenario.
     */
    @GetMapping("/numerate")
    public String numerateSteps(@RequestParam(value="id", defaultValue="") String id) {
        for (int i = 0; i < Application.scenarios.size(); i++) {
            Scenario scenario = Application.scenarios.get(i);

            if ( scenario.getId().toString().equals(id) ) {

                NumerationVisitor numerationVisitor = new NumerationVisitor();
                numerationVisitor.visit(scenario);
                
                return numerationVisitor.numerated;
            }  
        }
        return "";
    }

}