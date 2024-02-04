package logic;

public class Janitor extends Employee {
    // field
    public String area;

    // constructor
    public Janitor(String name, int id, String area) {
        super(name, id, 15);
        setArea(area);
    }

    // method
    public int computeSalary() {
        return BackEndAPI.calculateMonthlySalary(getBaseSalary(), getBonus(), 30);
    }

    public String getDescription() {
        return BackEndAPI.getJanitorDescription(getId(), getName(), getArea(), getBonus());
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
