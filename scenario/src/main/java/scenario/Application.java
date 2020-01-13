package scenario;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class handles the execution.
 */
@SpringBootApplication
public class Application {
	/**
     * A list of scenarios processed by the application.
     */
    public static ArrayList<Scenario> scenarios = new ArrayList<Scenario>();

    /**
     * Main function.
     * @param args parameters for the execution.
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
