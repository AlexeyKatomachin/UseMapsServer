package akatomakhin.apps.usemap.entity.connection.db.hibernate.entity;

import akatomakhin.apps.usemap.entity.user.User;

import javax.persistence.*;


@Entity
@Table(name = "user", schema = "userdb")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "state")
    private String state;
    @Column(name = "gmail")
    private String gmail;


    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return  name;
    }

    public void setName(String name){
        this.name = name;
    }


    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }


    public String getGmail(){
        return gmail;
    }

    public void setGmail(String gmail){
        this.gmail = gmail;
    }

    public void setUser(User user){
        this.gmail = user.getGmail();
        this.state = user.getState();
        this.name = user.getName();
        this.id = user.getId();
    }

    public User getUser(){
        User user = new User();
        user.setName(name);
        user.setGmail(gmail);
        user.setState(state);
        user.setId(id);
        return user;
    }
}
