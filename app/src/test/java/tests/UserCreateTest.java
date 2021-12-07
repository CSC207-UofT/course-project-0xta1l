package tests;

import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.UseCases.UserCreate;
import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class UserCreateTest {

    ArrayList<String> genrelist = new ArrayList<>();

    HashMap<String, User> existingusers = new HashMap<>();

    @Test(timeout = 50)
    public void TestUserCreate1() {
        UserCreate usercreate = new UserCreate();
        ArrayList<String> interests = new ArrayList<>();
        interests.add("dessert");
        interests.add("chinese");
        User user = usercreate.userCreate("username1", "123", "Jo", 19,"hi", interests, existingusers, genrelist);
        assertNotNull(user);

    }

    @Test(timeout = 50)
    public void TestUserCreate2() {
        UserCreate usercreate = new UserCreate();
        ArrayList<String> interests = new ArrayList<>();
        interests.add("dessert");
        interests.add("chinese");
        User user = usercreate.userCreate("jj", "123", "Jo", 19,"hi", interests, existingusers, genrelist);
        assertNotNull(user);
    }
}
