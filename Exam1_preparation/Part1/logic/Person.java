package logic;

public class Person {
    // field
    private String name;
    private int ID;

    // constructor
    public Person(String name, int ID) {
        this.name = name;
        this.ID = Math.max(1, ID);
    }

    // method
    public void setID(int ID) {
        ID = Math.max(1, ID);
        this.ID = ID;
    }

    public int getID() {
        return this.ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
