import Entities.User;
import Entities.UserSecurity;
import UseCases.UserCreate;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserCreateTest {

    UserSecurity usersecurity = new UserSecurity();
    User user1 = new User();
    User user2 = new User();

    @Before
    public void setUp() throws Exception {
        user1.setUsername("James");
        user1.setPassword("123");
        user2.setUsername("Arpi");
        user2.setPassword("456");
        usersecurity.addUser(user1);
        usersecurity.addUser(user2);
    }

    @Test(timeout = 50)
    public void TestUserCreate1() {
        UserCreate usercreate = new UserCreate();
        ArrayList<String> interests = new ArrayList<String>();
        interests.add("dessert");
        interests.add("chinese");
        boolean value = usercreate.userCreate(usersecurity, "Jo", 19, "123",
                "James", "hi", interests);
        assertFalse(value);
    }

    @Test(timeout = 50)
    public void TestUserCreate2() {
        UserCreate usercreate = new UserCreate();
        ArrayList<String> interests = new ArrayList<String>();
        interests.add("dessert");
        interests.add("chinese");
        boolean value = usercreate.userCreate(usersecurity, "Jo", 19, "123", "jj",
                "hi", interests);
        assertTrue(value);
    }
}
