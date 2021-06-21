package abstractclass;

public abstract class Employee {
    private String firstName;
    private final String lastName;
    private final String sSN; //social Security Number

    //constructor
    public Employee(String fName, String lName, String sSN) {
        this.firstName = fName;
        this.lastName = lName;
        this.sSN = sSN;
    }

    //getter & setter
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    //get Last Name
    public String getLastName() {
        return lastName;
    }

    //get SSN
    public String getsSN() {
        return sSN;
    }

    @Override
    public String toString() {
        return String.format("Herr/Frau %s %s with social Security Number %s", this.getFirstName(), this.getLastName(), this.getsSN());
    }
     public double compareTo(Employee e){
        return this.earning() - e.earning();
     }
    public abstract double earning();
}
