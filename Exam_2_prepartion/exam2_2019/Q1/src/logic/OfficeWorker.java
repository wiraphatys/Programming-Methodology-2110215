package logic;

public class OfficeWorker extends Employee {
    // field
    private String department;

    // constructor
    public OfficeWorker(String name, int id, String department) {
        super(name, id, 30);
        setDepartment(department);
    }

    // method
    public int computeSalary() {
        return BackEndAPI.calculateMonthlySalary(getBaseSalary(), getBonus(), 20);
    }

    public String getDescription() {
        return BackEndAPI.getOfficeWorkerDescription(getId(), getName(), getDepartment(), getBonus());
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
