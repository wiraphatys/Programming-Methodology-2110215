package logic;

import java.util.ArrayList;

public class Channel {
    // field
    private String name;
    private ArrayList<Message> messageList;

    // constructor
    public Channel(String name) {
        this.messageList = new ArrayList<>();
        setName(name);
    }

    // method
    public void addMessage(Message message) {
        messageList.add(message);
    }

    public void setName(String name) {
        if (name.isBlank()) {
            this.name = "off-topic";
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getMessageCount() {
        return messageList.size();
    }

    public void setMessageList(ArrayList<Message> messageList) {
        this.messageList = messageList;
    }

    public ArrayList<Message> getMessageList() {
        return this.messageList;
    }
}
