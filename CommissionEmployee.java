package abstractclass;

public class CommissionEmployee extends Employee {
    private double grossSales;
    private double commissionRate;
    private double baseSalary;

    public CommissionEmployee(String fName, String lName, String sSN, double grossSale, double commissionRate, double bSalary) {
        super(fName, lName, sSN);
        this.commissionRate = commissionRate;
        this.grossSales = grossSale;
        this.baseSalary = bSalary;
    }

    //getter
    public double getGrossSales() {
        return this.grossSales;
    }

    //setter
    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    //getter
    public double getCommissionRate() {
        return this.commissionRate;
    }

    //setter
    public void setCommissionRate(double cRate) {
        this.commissionRate = cRate;
    }

    //getter
    public double getBaseSalary() {
        return this.baseSalary;
    }

    //setter
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        //if Commission Employee
        if (this.getBaseSalary() == 0) {
            return "-->commission employee: " + super.toString() + "\nWith gross Sales: " + this.getGrossSales() +
                    " and commission rate: " + this.getCommissionRate() + "-> Total earned: " + this.earning();
        } else {
            return "-->Base-Salaried commission employee: " + super.toString() + "\nWith gross Sales: " + this.getGrossSales() +
                    " and commission rate: " + this.getCommissionRate() + "\nBase Salary: " + this.getBaseSalary() +
                    "-> Total earned: " + this.earning();
        }
    }

    @Override
    public double earning() {
        return this.getGrossSales() * this.getCommissionRate() + this.getBaseSalary();
    }
}
