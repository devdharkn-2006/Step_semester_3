package classes_and_objects_revision.assigment_problems;

class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Permanent employee: salary is known up front.
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Key idea: this(...) reuses the 3-arg constructor so setup logic isn't duplicated;
    // the intern flag is then flipped after the chained call returns.
    public Employee(String empId, String empName) {
        this(empId, empName, 0);
        this.isIntern = true;
    }

    void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class EmployeeProfile {
    public static void main(String[] args) {
        new Employee("E-101", "Divya", 65000).printProfile();
        new Employee("E-102", "Arjun").printProfile();
    }
}
