package test;

import com.example.myfirstapp.main.Entities.User;
import com.example.myfirstapp.main.Entities.UserSecurity;
import com.example.myfirstapp.main.UseCases.UserCreate;

import java.util.ArrayList;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserCreateTest {


    @Test(timeout = 50)
    public void TestUserCreate1() {
        UserCreate usercreate = new UserCreate();
        ArrayList<String> interests = new ArrayList<>();
        interests.add("dessert");
        interests.add("chinese");
        boolean value = usercreate.userCreate("username1", "123",
                "Jo", 19,"hi", interests);
        assertFalse(value);
    }

    @Test(timeout = 50)
    public void TestUserCreate2() {
        UserCreate usercreate = new UserCreate();
        ArrayList<String> interests = new ArrayList<>();
        interests.add("dessert");
        interests.add("chinese");
        boolean value = usercreate.userCreate("jj", "123",
                "Jo", 19,"hi", interests);
        assertTrue(value);
    }
}
