package oop_classes_and_objects.assigment_problems;

// Key idea: unset instance fields get defaults: references null, numbers 0, boolean false.
class Employee {
    String empName;
    double salary;
    boolean permanent;
}

public class DefaultFieldValues {
    public static void main(String[] args) {
        Employee emp = new Employee(); // nothing assigned on purpose
        System.out.println("Name: " + emp.empName);
        System.out.println("Salary: " + emp.salary);
        System.out.println("Permanent: " + emp.permanent);
    }
}
