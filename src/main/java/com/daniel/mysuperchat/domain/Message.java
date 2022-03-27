package com.daniel.mysuperchat.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Message implements Serializable {

    private UUID userId;
    private String userName;
    private String messageText;

    Date date = new Date();

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }


    public String getFormattedText(){
        return date.getHours() + ":" + date.getMinutes() + " " + userName + ": " + messageText;
    }


}

