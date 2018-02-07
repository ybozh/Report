package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class SaveToDB {
	
	Connection connection = dbConnection.dbConnector();
	String ID = null;
	
	
	
	public void createRow (String NameOfTable) {
		
		try {		
			
			String query = "INSERT INTO " + NameOfTable + " DEFAULT VALUES";			
			PreparedStatement pat = connection.prepareStatement(query);			
			pat.execute();
			pat.close();
			
			String query1 = "SELECT ID FROM " + NameOfTable + " WHERE rowid=last_insert_rowid();";
			//String query = "INSERT INTO " + NameOfTable + " (" + NameOfField + ") VALUES ('" + str + "')";
			PreparedStatement pat1 = connection.prepareStatement(query1);			
			ResultSet rs = pat1.executeQuery();
			ID = rs.getString(1);			
			pat1.close();
			//pat.setString(2, dateChooser_StartTr.getDate().toString());
			//pat.setString(3, dateChooser_FinishTr.getDate().toString());
			
			//pat.setString(no, str);
			
			//pat.execute();
			
			
			JOptionPane.showMessageDialog(null, "Row " + ID + " is saved!");
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
		
		
		
	}
	
	public void updateLastCreatedRow (String NameOfTableUPD, String NameOfField, String value) {		
		
		try {	
			
			String query = "UPDATE " + NameOfTableUPD + " SET " + NameOfField + " = '" + value + "' WHERE ID = " + ID;			
			PreparedStatement pat2 = connection.prepareStatement(query);			
			pat2.execute();
			
			pat2.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
		
		
	}
	
	public void updateRow (String NameOfTableUPD, String NameOfField, String value, String where) {		
		
		try {	
			
			String query = "UPDATE " + NameOfTableUPD + " SET " + NameOfField + " = '" + value + "' WHERE ID = " + where;			
			PreparedStatement pat4 = connection.prepareStatement(query);			
			pat4.execute();
			
			pat4.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
		
		
	}
	
	public void selectAllFromRow (String NameOfTable, String NameOfField, String value) {
		try {
			String query1 = "SELECT * FROM " + NameOfTable + " WHERE " + NameOfField + " = '" + value + "'";			
			PreparedStatement pat5 = connection.prepareStatement(query1);			
			ResultSet rs = pat5.executeQuery();
			String res = rs.getString(3);			
			pat5.close();
			
			JOptionPane.showMessageDialog(null, res);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	
	public void deleteRow(String NameOfTable, String NameOfField, String value) {
		try {
			String query = "DELETE FROM " + NameOfTable + " WHERE " + NameOfField + " = '" + value + "'";			
			PreparedStatement pat3 = connection.prepareStatement(query);			
			pat3.execute();
			
			pat3.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
	}

}
