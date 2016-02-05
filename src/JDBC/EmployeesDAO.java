package JDBC;

import java.sql.*;
import java.util.ArrayList;

import javax.annotation.PostConstruct;

public class EmployeesDAO {
	private final String URL = "jdbc:mysql://localhost:3306/companydb";
	private final String USER = "student";
	private final String PASSWORD = "student";
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private Connection conn;
	private Statement stmt;
	private ArrayList<Employee> employees;

	// initializing employees arraylist

	// simple select
	public ArrayList<ArrayList> select(String sqltxt)
	{
		ArrayList<ArrayList> arrayList = new ArrayList<>();
		System.out.println("in select");
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqltxt);
			ResultSetMetaData rsmd = rs.getMetaData();
			ArrayList<String> list = new ArrayList();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				list.add(rsmd.getColumnName(i));
			}
			arrayList.add(list);

			while (rs.next()) {
				ArrayList<String> arrList = new ArrayList();

				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					arrList.add(rs.getString(i));
				}
				arrayList.add(arrList);
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return arrayList;
		}
	}

	// simple update
	public int update(String sqltxt)
	{
		int uc = 0;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// conn.setAutoCommit(false);
			stmt = conn.createStatement();

			uc = stmt.executeUpdate(sqltxt);

			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			return uc;
		}
	}

	@PostConstruct
	// initializing employees
	private void initEmployees()
	{
		employees = new ArrayList();
		String sqltxt = "SELECT id, firstname, lastname, middlename, gender, salary, address, city, state, zipcode FROM employees;";
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqltxt);
			while (rs.next()) {
				int id = rs.getInt(1);
				String fn = rs.getString(2);
				String ln = rs.getString(3);
				String mn = rs.getString(4);
				String gender = rs.getString(5);
				double salary = rs.getDouble(6);
				String add = rs.getString(7);
				String city = rs.getString(8);
				String state = rs.getString(9);
				int zip = rs.getInt(10);

				employees.add(new Employee(id, fn, ln, mn, gender, salary, add, city, state, zip));
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.err.println(e);
		}

	}

	// listing employees
	public ArrayList<Employee> listAllEmployees()
	{
		// initEmployees();
		return employees;
	}

	public Employee getEmployee(int id)
	{
		Employee e = null;
		int num = -1;
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				num = employees.indexOf(employee);
				break;
			}
		}
		if (num != -1) {
			e = employees.get(num);
		}
		return e;
	}

	// adding an employee
	public void addEmployee(Employee emp)
	{
		employees.add(emp);
		emp.setSalary(15000.00);
		String sqltxt = "INSERT INTO employees(id, firstname, lastname, middlename, salary, address, city, state, zipcode) VALUES ("
				+ emp.getId() + ", '" + emp.getFirstName() + "', '" + emp.getLastName() + "', '" + emp.getMiddleName()
				+ "', 15000.00, '" + emp.getAddress() + "', '" + emp.getCity() + "', '" + emp.getState() + "', "
				+ emp.getZipcode() + ");";
		int num = update(sqltxt);
	}

	public void remove(Employee emp)
	{
		Employee e = getEmployee(emp.getId());
		employees.remove(e);
		// System.out.println(e.getId());
		String sqltxt = "DELETE FROM employees WHERE id=" + e.getId() + ";";
		int number = update(sqltxt);
	}

	public void updateEmployee(Employee emp)
	{
		String state = "";
		int number = -1;
		for (Employee employee : employees) {
			if (employee.getId() == emp.getId()) {
				state = employee.getState();
				number = employees.indexOf(employee);
				break;
			}
		}
		if (number != -1) {
			emp.setState(state);
			employees.set(number, emp);
			String sqltxt = "UPDATE employees SET firstname= '" + emp.getFirstName() + "', middlename= '"
					+ emp.getMiddleName() + "', lastname= '" + emp.getLastName() + "', salary= " + emp.getSalary()
					+ ", address= '" + emp.getAddress() + "', city= '" + emp.getCity() + "', zipcode= "
					+ emp.getZipcode() + " WHERE id =" + emp.getId();
			System.out.println(sqltxt);
			int num = update(sqltxt);
		}

	}

}
