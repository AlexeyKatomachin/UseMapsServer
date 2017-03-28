package akatomakhin.apps.usemap.entity.messages;

import akatomakhin.apps.usemap.entity.messages.message.Message;


public class Connect {
    /* mandatory data*/
    private Message connect;

    /* setters and getters */
    public void setConnect (Message connect){
        this.connect = connect;
    }

    public Message getConnect(){
        return connect;
    }
}
