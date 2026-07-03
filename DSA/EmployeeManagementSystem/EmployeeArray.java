public class EmployeeArray {

    Employee[] employees;
    int size;

    public EmployeeArray(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {

        if (size == employees.length) {
            System.out.println("Array is Full.");
            return;
        }

        employees[size] = employee;
        size++;

        System.out.println("Employee Added Successfully.");
    }

    public void searchEmployee(int id) {

        for (int i = 0; i < size; i++) {

            if (employees[i].employeeId == id) {

                System.out.println("\nEmployee Found:");
                employees[i].display();
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }

    // Traverse Employees
    public void traverseEmployees() {

        System.out.println("\nEmployee Records");

        System.out.println("ID\tName\tPosition\tSalary");

        for (int i = 0; i < size; i++) {
            employees[i].display();
        }
    }

    public void deleteEmployee(int id) {

        for (int i = 0; i < size; i++) {

            if (employees[i].employeeId == id) {

                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                employees[size - 1] = null;
                size--;

                System.out.println("Employee Deleted Successfully.");
                return;
            }
        }

        System.out.println("Employee Not Found.");
    }
}