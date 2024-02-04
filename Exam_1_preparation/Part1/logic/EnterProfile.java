package logic;

public class EnterProfile {
    // field
    private Person person;
    private int bodyTemperature;

    // constructor
    public EnterProfile(Person person, int bodyTemperature) {
        setPerson(person);
        setBodyTemperature(bodyTemperature);
    }

    // method
    public boolean hasFever() {
        return bodyTemperature >= 37;
    }

    public void setBodyTemperature(int bodyTemperature) {
        if (bodyTemperature < 35) bodyTemperature = 35;
        if (bodyTemperature > 42) bodyTemperature = 42;
        this.bodyTemperature = bodyTemperature;
    }

    public int getBodyTemperature() {
        return this.bodyTemperature;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return this.person;
    }
}
