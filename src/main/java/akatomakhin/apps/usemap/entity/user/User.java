package akatomakhin.apps.usemap.entity.user;

public class User {
    /* mandatory data*/
    private String name;
    private String state;
    private String gmail;
    private int id;

    /* setters and getters */
    public void setName (String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setState (String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public void setGmail(String gmail){
        this.gmail = gmail;
    }

    public String getGmail(){
        return  gmail;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
