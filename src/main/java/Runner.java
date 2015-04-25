import com.frolov.testing.dao.*;
import com.frolov.testing.entity.Platform;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.factory.PlatformFactory;
import org.boon.Boon;

public class Runner {

    public static Platform platform;

    public static void main(String[] args) {

//        System.out.println("Testing System");
//        platform = PlatformFactory.createPlatform();
//        System.out.println(Boon.toPrettyJsonWithTypes(platform));

        DaoFactory instance = DaoFactory.getInstance(DaoFactory.Type.Jdbc);
        JdbcUserDao jdbcUserDao = instance.create(JdbcUserDao.class);
        jdbcUserDao.setConnection(jdbcUserDao.getConnection());
        BaseUser byEmail = jdbcUserDao.findByEmail("Ethan_Nash@gmail.com");
        System.out.println(Boon.toPrettyJson(byEmail));

    }

}
