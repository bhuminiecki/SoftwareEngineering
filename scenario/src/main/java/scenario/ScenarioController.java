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

@RestController
public class ScenarioController {

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