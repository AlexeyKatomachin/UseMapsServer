package akatomakhin.apps.usemap.dao.MySQL;

import akatomakhin.apps.usemap.dao.UserRepositoryInterface;
import akatomakhin.apps.usemap.entity.connection.db.hibernate.entity.UserEntity;
import akatomakhin.apps.usemap.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@EnableTransactionManagement
public  class MySQLUserManager {

    private UserRepositoryInterface userRepositoryInterface;

    @Autowired
    public MySQLUserManager(UserRepositoryInterface userRepositoryInterface){
        this.userRepositoryInterface = userRepositoryInterface;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void createUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUser(user);
        userRepositoryInterface.save(userEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(User user, int userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUser(user);
        userEntity.setId(userId);
        userRepositoryInterface.save(userEntity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteUser(int userID) {
        userRepositoryInterface.delete(userID);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public User getUser(int userID) {
        UserEntity userEntity = userRepositoryInterface.findOne(userID);
        User user = new User();
        user.setName(userEntity.getName());
        user.setState(userEntity.getState());
        user.setGmail(userEntity.getGmail());
        user.setId(userEntity.getId());
        return user;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public int getUserID(User user) {
        int userId = 0;
        ArrayList<UserEntity> userEntities = (ArrayList<UserEntity>) userRepositoryInterface.findAll();
        for (UserEntity userEntity: userEntities ) {
            if(userEntity.getGmail().equals(user.getGmail()))
                userId = userEntity.getId();
        }
        return userId;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> getAllUsers() {
        ArrayList<UserEntity> userEntities = (ArrayList<UserEntity>) userRepositoryInterface.findAll();
        ArrayList<User> allUsers = new ArrayList<User>();
        for (UserEntity userEntity: userEntities ) {
            allUsers.add(userEntity.getUser());
        }
        return allUsers;
    }
}
