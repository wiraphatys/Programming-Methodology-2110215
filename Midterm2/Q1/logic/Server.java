package logic;

import java.util.ArrayList;

public class Server {
    // field
    private String name;
    private User owner;
    private ArrayList<Channel> channelList;
    private ArrayList<User> memberList;

    // constructor
    public Server(String name, User owner, TemplateType template) {
        setOwner(owner);
        setMemberList(new ArrayList<>());
        setChannelList(new ArrayList<>());
        setName(name);

        memberList.add(owner);
        owner.addJoinedServersList(this);

        // Add a channel based on the specified template
        Channel defaultChannel = null;
        switch (template) {
            case BASIC:
                defaultChannel = addChannel(owner, "general");
                break;
            case GAMING:
                defaultChannel = addChannel(owner, "gaming");
                break;
            case STUDY:
                defaultChannel = addChannel(owner, "homework-help");
                break;
            default:
                // Handle unsupported template types or provide a default channel
                break;
        }
    }


    // method

    public Channel addChannel(User user, String channelName) {
        if (user.equals(owner)) {
            Channel newChannel = new Channel(channelName);
            channelList.add(newChannel);
            return newChannel;
        } else {
            return null;
        }
    }

    public User addUser(User user) {
        for (User existUser : memberList) {
            if (existUser.equals(user)) {
                return null;
            }
        }
        memberList.add(user);
        user.addJoinedServersList(this);

        return user;
    }

    public boolean kickUser(User kicker, User kicked) throws Exception {
        if (!kicker.equals(owner)) {
            throw new Exception();
        } else {
            if (!memberList.contains(kicked) || kicked.equals(owner)) {
                return false;
            }
            kicked.getJoinedServersList().remove(this);
            memberList.remove(kicked);
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            this.name = owner.getName() + " home";
        } else {
            this.name = name;
        }
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<Channel> getChannelList() {
        return channelList;
    }

    public void setChannelList(ArrayList<Channel> channelList) {
        this.channelList = channelList;
    }

    public ArrayList<User> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<User> memberList) {
        this.memberList = memberList;
    }

    public boolean isMemberInServer(User currentUser) {
        return memberList.contains(currentUser);
    }
}
