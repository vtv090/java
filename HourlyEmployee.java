package abstractclass;

public class HourlyEmployee extends Employee {
    private double wage; //wage per hour
    private int hours; //hours worked for week

    public HourlyEmployee(String fName, String lName, String sSN, double wage, int hours) {
        super(fName, lName, sSN);
        this.hours = hours;
        this.wage = wage;
    }

    //set Wage
    public void setWage(double wage) {
        this.wage = wage;
    }

    //get wage
    public double getWage() {
        return this.wage;
    }

    //set hours
    public void setHours(int hour) {
        this.hours = hour;
    }

    //get hours
    public int getHours() {
        return this.hours;
    }

    @Override
    public String toString() {
        return "-->Hourly Employee: " + super.toString() + "\nHourly Wage: " + this.getWage()
                + "\nWorked hours: " + this.getHours() + "-> Total earned: " + this.earning();
    }

    @Override
    public double earning() {
        if (this.getHours() <= 40)
            return this.getWage() * this.getHours();
        else
            return 40 * this.getWage() + (this.getWage() - 40) * getWage() * 1.5;
    }
}
