import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class EmployeeJDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/company";
    private static final String USER = "root";
    private static final String PASSWORD = "garima@28";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addEmployee(Employee employee) {
        String sql = "INSERT INTO employee (id, name, department) VALUES (?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getDepartment());
            statement.executeUpdate();
            System.out.println("Employee added: " + employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employee";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                Employee employee = new Employee(id, name, department);
                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public Employee getEmployeeById(int id) {
        Employee employee = null;
        String sql = "SELECT * FROM employee WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("name");
                    String department = rs.getString("department");
                    employee = new Employee(id, name, department);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public boolean updateEmployee(int id, String name, String department) {
        String sql = "UPDATE employee SET name = ?, department = ? WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, department);
            statement.setInt(3, id);
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Employee updated: " + new Employee(id, name, department));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            int affectedRows = statement.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Employee deleted with ID: " + id);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeJDBC employeeJDBC = new EmployeeJDBC();

        Employee e1 = new Employee(101, "Phoebe", "Human Resource");
        Employee e2 = new Employee(102, "Monica", "Management");
        Employee e3 = new Employee(103, "Rachel", "Support");

        employeeJDBC.addEmployee(e1);
        employeeJDBC.addEmployee(e2);
        employeeJDBC.addEmployee(e3);

        System.out.println("All Employees: " + employeeJDBC.getAllEmployees());
        System.out.println("Get Employee by ID 103: " + employeeJDBC.getEmployeeById(103));

        employeeJDBC.updateEmployee(103, "Rachel Geller", "Retail");

        employeeJDBC.deleteEmployee(102);

        System.out.println("All Employees after update and delete: " + employeeJDBC.getAllEmployees());
    }
}
