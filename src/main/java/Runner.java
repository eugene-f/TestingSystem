import com.frolov.testing.entity.Platform;
import com.frolov.testing.factory.PlatformFactory;
import org.boon.Boon;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Testing System");
        Platform platform = PlatformFactory.createPlatform();
        System.out.println(Boon.toPrettyJsonWithTypes(platform));
    }

}