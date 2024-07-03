import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class Employee {
    private int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "'}";
    }
}


class EmployeeCRUD {
    private List<Employee> employeeList;

    public EmployeeCRUD() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
        System.out.println("Employee added: " + employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public boolean updateEmployee(int id, String name, String department) {
        Employee employee = getEmployeeById(id);
        if (employee != null) {
            employee.setName(name);
            employee.setDepartment(department);
            System.out.println("Employee updated: " + employee);
            return true;
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.getId() == id) {
                iterator.remove();
                System.out.println("Employee deleted: " + employee);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeCRUD employeeCRUD = new EmployeeCRUD();

        Employee e1 = new Employee(101, "Phoebe", "Human Resource");
        Employee e2 = new Employee(102, "Monica", "Management");
        Employee e3 = new Employee(103, "Rachel", "Support");

        employeeCRUD.addEmployee(e1);
        employeeCRUD.addEmployee(e2);
        employeeCRUD.addEmployee(e3);

        System.out.println("All Employees: " + employeeCRUD.getAllEmployees());
        System.out.println("Get Employee by ID 102: " + employeeCRUD.getEmployeeById(102));

        employeeCRUD.updateEmployee(103, "Rachel Green", "Retail");

        employeeCRUD.deleteEmployee(102);

        System.out.println("All Employees after update and delete: " + employeeCRUD.getAllEmployees());
    }
}

