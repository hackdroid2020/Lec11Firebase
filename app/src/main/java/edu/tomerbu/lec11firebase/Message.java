package edu.tomerbu.lec11firebase;

public class Message {
    private String message;
    private String messageID;
    private String senderID;

    //for firebase:
    public Message() {
    }
    //for us:
    public Message(String message, String messageID, String senderID) {
        this.message = message;
        this.messageID = messageID;
        this.senderID = senderID;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessageID() {
        return messageID;
    }
    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }
    public String getSenderID() {
        return senderID;
    }
    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    //for us
    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                ", messageID='" + messageID + '\'' +
                ", senderID='" + senderID + '\'' +
                '}';
    }
}
