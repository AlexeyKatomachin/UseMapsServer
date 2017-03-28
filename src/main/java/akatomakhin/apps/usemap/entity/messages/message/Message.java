package akatomakhin.apps.usemap.entity.messages.message;

import akatomakhin.apps.usemap.entity.messages.message.entity.MessageEntity;

import java.util.ArrayList;
import java.util.List;

public class Message {
    /* mandatory data*/
    private List<MessageEntity> errors = new ArrayList<MessageEntity>();
    private int code;
    private String message;

    /* setters and getters*/
    public void setErrors(MessageEntity error){
        errors.add(error);
    }

    public List<MessageEntity> getErrors(){
        return errors;
    }

    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
 }
