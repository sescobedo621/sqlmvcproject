package JDBC;

import java.sql.*;
import java.util.ArrayList;

public class EmployeesDAO {
	private final String URL = "jdbc:mysql://localhost:3306/companydb";
	private final String USER = "student";
	private final String PASSWORD = "student";
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private Connection conn;
	private Statement stmt;

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

	public int update(String sqltxt)
	{
		int uc = 0;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			//conn.setAutoCommit(false);
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
	
	

}
