package scenario;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
 
import java.util.Arrays;
 
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, WebApplicationContext.class})
@WebAppConfiguration
public class ScenarioControllerTest {
 
    private MockMvc mockMvc;
 
    @Autowired
    private ScenarioController scenarioMock;
 
    //Add WebApplicationContext field here
 
    //The setUp() method is omitted.
<<<<<<< HEAD
 
    @Test
    public void shouldReturn200() throws Exception {
  
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
 
<<<<<<< HEAD:scenario/src/test/java/ScenarioControllerTest.java
=======
        verifyNoMoreInteractions(scenarioMock);
>>>>>>> e3c4b474f6a7f539b614369c8bfecbf97c87e319:scenario/src/test/java/scenario/ScenarioControllerTest.java
    }
=======
>>>>>>> 43718b3f79fb1a02f09d2cc3aaffb607c71ee467
}