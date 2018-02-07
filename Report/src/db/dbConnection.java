package db;

import java.sql.*;
import javax.swing.*;

public class dbConnection {
	Connection conn = null;
	public static Connection dbConnector() {
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:EmployeeInfo.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection Ok!");
			return conn;
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
