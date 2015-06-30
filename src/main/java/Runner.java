import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    public static void main(String[] args) {
        showLoggerConfiguration();
    }

    private static void showLoggerConfiguration() {
        System.out.println("LOGGER.isTraceEnabled(): " + LOGGER.isTraceEnabled());
        System.out.println("LOGGER.isDebugEnabled(): " + LOGGER.isDebugEnabled());
        System.out.println("LOGGER.isInfoEnabled(): " + LOGGER.isInfoEnabled());
        System.out.println("LOGGER.isWarnEnabled(): " + LOGGER.isWarnEnabled());
        System.out.println("LOGGER.isErrorEnabled(): " + LOGGER.isErrorEnabled());
    }

}
