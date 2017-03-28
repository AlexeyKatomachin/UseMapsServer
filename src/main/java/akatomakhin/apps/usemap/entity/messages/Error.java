package akatomakhin.apps.usemap.entity.messages;

import akatomakhin.apps.usemap.entity.messages.message.Message;

public class Error {
    /* mandatory data*/
    private Message error;

    /* setters and getters */
    public void setError (Message error){
        this.error = error;
    }

    public Message getError(){
        return error;
    }

}
