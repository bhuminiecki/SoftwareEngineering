package main.java.scenario;

import java.util.*;
import java.io.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.scenario.Application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller of the scenario.
 * Exposes REST endpoints of the application.
 */
@RestController
public class ScenarioController {

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
                    return "Unable to return the scenario";

                }
            }
        }
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
    public Integer getScenarioStepsById(@RequestParam(value="id", defaultValue="") String id) {
        for (int i = 0; i < Application.scenarios.size(); i++) {

            Scenario scenario = Application.scenarios.get(i);

            if ( scenario.getId().toString().equals(id) ) {
                return scenario.countSteps();
            }  
        }
        return -1;
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

                    return mapper.writeValueAsString( scenario.stepsWithoutActor() );

                } catch ( IOException e ) {

                    e.printStackTrace();
                    return "Unable to return the steps";

                }
            }  
        }
        return "Unable to find the scenario";
    }
}