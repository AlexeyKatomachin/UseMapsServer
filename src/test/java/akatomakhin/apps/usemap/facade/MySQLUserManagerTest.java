package akatomakhin.apps.usemap.facade;


import akatomakhin.apps.usemap.entity.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MySQLUserManagerTest {

    @Autowired
    private UserManagerInterface userManager;

    private User user(){
        User user = new User();
        user.setGmail("gjgjgjgk");
        user.setState("all");
        user.setName("Mane");
        return user;
    }

    private User newUser(){
        User newUser = new User();
        newUser.setName("Lomov");
        newUser.setGmail("lomov@mail.ru");
        newUser.setState("medium");
        return newUser;
    }

    @Test
    public void createUserTest(){
        User user = user();
        userManager.create(user);
        user.setId(userManager.getUserId(user()));
        assertEquals(user.getGmail(),userManager.getUser(user.getId()).getGmail());
        assertEquals(user.getName(),userManager.getUser(user.getId()).getName());
        assertEquals(user.getState(),userManager.getUser(user.getId()).getState());
        assertEquals(user.getId(),userManager.getUser(user.getId()).getId());
    }

    @Test
    public void updateUserTest(){
        User newUser = newUser();
        userManager.create(user());
        newUser.setId(userManager.getUserId(user()));
        userManager.update(newUser,newUser.getId());
        assertEquals(newUser.getGmail(),userManager.getUser(newUser.getId()).getGmail());
        assertEquals(newUser.getName(),userManager.getUser(newUser.getId()).getName());
        assertEquals(newUser.getState(),userManager.getUser(newUser.getId()).getState());
        assertEquals(newUser.getId(),userManager.getUser(newUser.getId()).getId());
    }

    @Test
    public void getUserTest(){
        User newUser = newUser();
        newUser.setId(userManager.getUserId(newUser));
        assertEquals(newUser.getGmail(),userManager.getUser(newUser.getId()).getGmail());
        assertEquals(newUser.getName(),userManager.getUser(newUser.getId()).getName());
        assertEquals(newUser.getState(),userManager.getUser(newUser.getId()).getState());
        assertEquals(newUser.getId(),userManager.getUser(newUser.getId()).getId());
    }

    @Test
    public void getAllUsersTest(){
        for (User user: userManager.getAllUsers()) {
            assertNotNull(user);
        }
    }

    @Test
    public void deleteUserTest(){
        userManager.deleteUser(userManager.getUserId(newUser()));
        userManager.deleteUser(userManager.getUserId(user()));
    }

}
