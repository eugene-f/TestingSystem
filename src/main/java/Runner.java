import com.frolov.testing.ConnectionPool;
import com.frolov.testing.dao.*;
import com.frolov.testing.dao.jdbc.dao.JdbcUserDao;
import com.frolov.testing.entity.Platform;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.factory.PlatformFactory;
import org.boon.Boon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class Runner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);
    public static Platform platform;

    public static void main(String[] args) {
        emulatePlatform();
        testJdbcDao();
        showLoggerConfiguration();
        testConnectionPool();
    }

    private static void showLoggerConfiguration() {
        System.out.println("logger.isTraceEnabled(): " + logger.isTraceEnabled());
        System.out.println("logger.isDebugEnabled(): " + logger.isDebugEnabled());
        System.out.println("logger.isInfoEnabled(): " + logger.isInfoEnabled());
        System.out.println("logger.isWarnEnabled(): " + logger.isWarnEnabled());
        System.out.println("logger.isErrorEnabled(): " + logger.isErrorEnabled());
    }

    private static void emulatePlatform() {
        System.out.println("Testing System");
        platform = PlatformFactory.createPlatform();
        System.out.println(Boon.toPrettyJsonWithTypes(platform));
        logger.info("Platform Emulated");
    }

    private static void testJdbcDao() {
        DaoFactory instance = DaoFactory.getInstance(DaoFactory.Type.Jdbc);
        JdbcUserDao jdbcUserDao = instance.create(JdbcUserDao.class);
        jdbcUserDao.setConnection(jdbcUserDao.getConnection());
        BaseUser byEmail = jdbcUserDao.findByEmail("Ethan_Nash@gmail.com");
        System.out.println(Boon.toPrettyJson(byEmail));
    }

    private static void testConnectionPool() {
        ConnectionPool instance1 = ConnectionPool.getInstance();
        ConnectionPool instance2 = ConnectionPool.getInstance();
        ConnectionPool instance3 = ConnectionPool.getInstance();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance3.hashCode());
        System.out.println(instance1.equals(instance3));

        try {
            instance1.getConnection().close();
            instance1.getConnection().close();
            instance1.getConnection().close();
            instance1.getConnection().close();
            instance1.getConnection().close();
            instance1.getConnection().close();
            instance1.getConnection().close();
            instance1.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
