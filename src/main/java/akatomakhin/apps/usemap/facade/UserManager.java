package akatomakhin.apps.usemap.facade;

import akatomakhin.apps.usemap.dao.MySQL.MySQLUserManager;
import akatomakhin.apps.usemap.entity.messages.message.Message;
import akatomakhin.apps.usemap.entity.messages.message.entity.MessageEntity;
import akatomakhin.apps.usemap.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserManagerInterface{

    private MySQLUserManager mySQLUserManager;

    @Autowired
    public UserManager( MySQLUserManager mySQLUserManager) {
        this.mySQLUserManager = mySQLUserManager;
    }



    @Override
    public Message create(User user) {
        mySQLUserManager.createUser(user);
        MessageEntity messageEntity = new MessageEntity();
        Message message = new Message();
        int userId = mySQLUserManager.getUserID(user);
        if(userId == 0){
            messageEntity.setDomain("Create user Error");
            messageEntity.setMessage("User wasn't create. Your gmail isn't correct");
            messageEntity.setReason("Create user Error");
            message.setErrors(messageEntity);
            message.setCode(400);
            message.setMessage("Request Error");
            return message;
        }
        else{
            message.setCode(200);
            return message;
        }
    }

    @Override
    public Message update(User user, int userId) {
        mySQLUserManager.update(user,userId);
        MessageEntity messageEntity = new MessageEntity();
        Message message = new Message();
        if (user.getGmail().equals(mySQLUserManager.getUser(userId).getGmail())){
            message.setCode(200);
            return message;
        }else{
            messageEntity.setDomain("Update user Error");
            messageEntity.setMessage("User wasn't create. Your ID isn't correct");
            messageEntity.setReason("Update user Error");
            message.setErrors(messageEntity);
            message.setCode(400);
            message.setMessage("Request Error");
            return message;
        }
    }

    @Override
    public Message deleteUser(int userId) {
        mySQLUserManager.deleteUser(userId);
        boolean flagIsDead = true;
        MessageEntity messageEntity = new MessageEntity();
        Message message = new Message();
        for (User user: mySQLUserManager.getAllUsers()) {
            if(user.getId() == userId){
                flagIsDead = false;
            }
        }
        if (flagIsDead == true){
            message.setCode(200);
            return message;
        }else{
            messageEntity.setDomain("Delete user Error");
            messageEntity.setMessage("User wasn't delete. Your ID isn't correct");
            messageEntity.setReason("Delete user Error");
            message.setErrors(messageEntity);
            message.setCode(400);
            message.setMessage("Request Error");
            return message;
        }
    }

    @Override
    public int getUserId(User user) {
        return mySQLUserManager.getUserID(user);
    }

    @Override
    public User getUser(int userID) {
        return mySQLUserManager.getUser(userID);
    }

    @Override
    public List<User> getAllUsers() {
        return mySQLUserManager.getAllUsers();
    }

}
