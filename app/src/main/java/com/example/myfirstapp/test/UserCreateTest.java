import Entities.User;
import Entities.UserSecurity;
import UseCases.UserCreate;
import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserCreateTest {


    @Test(timeout = 50)
    public void TestUserCreate1() {
        UserCreate usercreate = new UserCreate();
        ArrayList<String> interests = new ArrayList<>();
        interests.add("dessert");
        interests.add("chinese");
        boolean value = usercreate.userCreate("Jo", 19, "123",
                "username1", "hi", interests);
        assertFalse(value);
    }

    @Test(timeout = 50)
    public void TestUserCreate2() {
        UserCreate usercreate = new UserCreate();
        ArrayList<String> interests = new ArrayList<>();
        interests.add("dessert");
        interests.add("chinese");
        boolean value = usercreate.userCreate("Jo", 19, "123", "jj",
                "hi", interests);
        assertTrue(value);
    }
}
