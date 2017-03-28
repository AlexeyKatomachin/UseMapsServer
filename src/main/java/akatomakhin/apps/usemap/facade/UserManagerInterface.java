package akatomakhin.apps.usemap.facade;

import akatomakhin.apps.usemap.entity.messages.message.Message;
import akatomakhin.apps.usemap.entity.user.User;

import java.util.List;

/**
 * Created by ${Alexey} on ${09.08.2016}.
 */
public interface UserManagerInterface {
    Message create (User user);
    Message update (User user, int userId);
    Message deleteUser(int userId);
    int getUserId(User user);
    User getUser(int userID);
    List<User> getAllUsers();
}
