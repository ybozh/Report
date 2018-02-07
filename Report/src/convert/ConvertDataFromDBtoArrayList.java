package convert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import db.dbConnection;



public class ConvertDataFromDBtoArrayList {

Connection connection = null;

public ArrayList<String> dataFromDBtoAL (String NameOfTable, String NameOfField)
{    	
	
	connection = dbConnection.dbConnector();
	
	ArrayList<String> al = new ArrayList<String>();
	
	try {
	String sql = "Select * from " + NameOfTable;
	PreparedStatement pat = connection.prepareStatement(sql);
	ResultSet rs = pat.executeQuery();		
	
	while (rs.next()) {		  
	  String str = rs.getString(NameOfField);
	  al.add(str);
	}
	
	} catch (Exception e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, e);
	}
	return al;    	
	
}

public ArrayList<String> dataFromDBtoALwhere (String NameOfTable, String NameOfField, String WhereField, String WhereValue)
{    	
	
	connection = dbConnection.dbConnector();
	
	ArrayList<String> al = new ArrayList<String>();
	
	try {
	String sql = "SELECT * FROM " + NameOfTable + " WHERE " + WhereField + " = '" + WhereValue + "'";	
	PreparedStatement pat = connection.prepareStatement(sql);
	ResultSet rs = pat.executeQuery();		
	
	while (rs.next()) {		  
	  String str = rs.getString(NameOfField);	  
	  al.add(str);
	}
	
	} catch (Exception e) {
		// TODO: handle exception
		JOptionPane.showMessageDialog(null, e);
	}
	return al;    	
	
}

}
