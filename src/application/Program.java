package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbIntegrityException;

public class Program {
	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;

		try {

			conn = DB.getConnection();

			st = conn.createStatement();

			int rows1 = st.executeUpdate("update seller set BaseSalary = 2090 where departmentId = 1");

			int x = 1;
			if (x < 2) {
				throw new SQLException("Fake error! ");
			}

			int rows2 = st.executeUpdate("update seller set BaseSalary = 3090 where departmentId = 2");

			System.out.println("Rows 1 " + rows1);
			System.out.println("Rows 2 " + rows2);

		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
