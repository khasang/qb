import io.khasang.qb.entity.User;
import org.junit.*;

public class UserServiceTest {
    @Test
    public void selectUserById() {
        User user = UserService.getUserById(2);
        Assert.assertEquals("Петров", user.getName());
    }

}
