import com.frolov.testing.entity.Platform;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.factory.PlatformFactory;
import com.frolov.testing.factory.UserFactory;
import com.frolov.testing.jdbc.UserDao;
import org.boon.Boon;

import java.sql.SQLException;

public class Runner {

    public static Platform platform;

    public static void main(String[] args) {
//        System.out.println("Testing System");
//        platform = PlatformFactory.createPlatform();
//        System.out.println(Boon.toPrettyJsonWithTypes(platform));

        UserDao userDao = new UserDao();
        userDao.insert(UserFactory.createStudent());
        BaseUser user = userDao.findByEmail("Robbie_Marks@gmail.com");
        System.out.println(Boon.toPrettyJson(user));
    }

}
