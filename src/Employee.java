public class Employee {

    private final String firstName;
    private final String middleName;
    private final String lastName;
    private int department;
    private double salary;
    private int id;
    private static int countId;

    public Employee(String firstName, String middleName, String lastName, int department, double salary) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        if (department < 1 || department > 5) throw new IllegalArgumentException("Номер отдела должен быть от 1 до 5");
        this.department = department;
        if (salary <= 0) throw new IllegalArgumentException("Значение зарплаты должна быть больше нуля!");
        this.salary = salary;
        this.id = ++countId;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Ф.И.О: " + this.lastName + " " + firstName + " " + middleName + ", ID: " + this.id +
                ", отдел: " + this.department + ", зарплата: " + this.salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
