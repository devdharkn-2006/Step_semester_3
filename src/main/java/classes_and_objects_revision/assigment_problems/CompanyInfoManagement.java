package classes_and_objects_revision.assigment_problems;

class CompanyEmployee {
    String empName;
    double salary;
    // Key idea: company data is shared state, so it lives in static fields (one copy for all employees).
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    // Static methods have no "this", so they may only touch static members.
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class CompanyInfoManagement {
    public static void main(String[] args) {
        new CompanyEmployee("Divya", 65000);
        new CompanyEmployee("Arjun", 40000);
        new CompanyEmployee("Meera", 52000);
        CompanyEmployee.printCompanyInfo();
    }
}
