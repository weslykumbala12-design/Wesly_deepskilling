public class Main {

    public static void main(String[] args) {

        EmployeeArray company = new EmployeeArray(10);

        company.addEmployee(new Employee(101, "John", "Manager", 60000));
        company.addEmployee(new Employee(102, "Alice", "Developer", 50000));
        company.addEmployee(new Employee(103, "David", "Tester", 45000));

        company.traverseEmployees();

        company.searchEmployee(102);

        company.deleteEmployee(101);

        company.traverseEmployees();
    }
}