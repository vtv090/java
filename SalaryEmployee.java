package abstractclass;

public class SalaryEmployee extends Employee {

    private double weeklySalary;

    //constructor
    public SalaryEmployee(String fName, String lName, String sSN, double weeklySalary) {
        super(fName, lName, sSN);
        this.weeklySalary = weeklySalary;
    }

    //set Method for Weekly salary
    public void setWeeklySalary(double wSalary) {
        this.weeklySalary = wSalary;
    }

    //get weekly salary
    public double getWeeklySalary() {
        return this.weeklySalary;
    }

    @Override
    public String toString() {
        return "-->Salaried Employee: " + super.toString() + "\nWeekly salary: " + this.getWeeklySalary()
                + "-> Total earned: " + this.earning();
    }

    @Override
    public double earning() {
        return this.getWeeklySalary();
    }
}
