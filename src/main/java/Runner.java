import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.JdbcDaoFactory;
import com.frolov.testing.dao.JdbcUserDao;
import com.frolov.testing.dao.UserDao;
import com.frolov.testing.entity.Platform;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.factory.UserFactory;
import org.boon.Boon;

public class Runner {

    public static Platform platform;

    public static void main(String[] args) {
//        System.out.println("Testing System");
//        platform = PlatformFactory.createPlatform();
//        System.out.println(Boon.toPrettyJsonWithTypes(platform));

//        UserDao userDao = new UserDao();
//        userDao.insert(UserFactory.createStudent());
//        BaseUser user = userDao.findByEmail("Robbie_Marks@gmail.com");
//        System.out.println(Boon.toPrettyJson(user));

        UserDao UserDao = DaoFactory.getInstance().create(JdbcUserDao.class);
        UserDao.findById(137L);
    }

}
