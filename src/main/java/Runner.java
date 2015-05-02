import com.frolov.testing.dao.*;
import com.frolov.testing.entity.Platform;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.factory.PlatformFactory;
import org.boon.Boon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);
    public static Platform platform;

    public static void main(String[] args) {
        createPlatformEmulation();
//        testDao();
        showLoggerConfig();
    }

    private static void showLoggerConfig() {
        System.out.println("logger.isTraceEnabled(): " + logger.isTraceEnabled());
        System.out.println("logger.isDebugEnabled(): " + logger.isDebugEnabled());
        System.out.println("logger.isInfoEnabled(): " + logger.isInfoEnabled());
        System.out.println("logger.isWarnEnabled(): " + logger.isWarnEnabled());
        System.out.println("logger.isErrorEnabled(): " + logger.isErrorEnabled());
    }

    private static void testDao() {
        DaoFactory instance = DaoFactory.getInstance(DaoFactory.Type.Jdbc);
        JdbcUserDao jdbcUserDao = instance.create(JdbcUserDao.class);
        jdbcUserDao.setConnection(jdbcUserDao.getConnection());
        BaseUser byEmail = jdbcUserDao.findByEmail("Ethan_Nash@gmail.com");
        System.out.println(Boon.toPrettyJson(byEmail));
    }

    private static void createPlatformEmulation() {
        System.out.println("Testing System");
        platform = PlatformFactory.createPlatform();
        System.out.println(Boon.toPrettyJsonWithTypes(platform));
        logger.info("Platform Emulated");
    }

}
