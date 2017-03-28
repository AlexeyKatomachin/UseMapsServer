package akatomakhin.apps.usemap.entity.messages.message.entity;

public class MessageEntity {
    /* mandatory data*/
    private String domain;
    private String reason;
    private String message;

    /* setters and getters*/
    public void setDomain (String domain){
        this.domain = domain;
    }

    public String getDomain (){
        return domain;
    }

    public void setReason (String reason){
        this.reason = reason;
    }

    public String getReason(){
        return reason;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
