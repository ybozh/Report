package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import convert.ConvertDataFromDBtoArrayList;

public class FillComboBox {
	
	Connection connection = null;
	
	public void fillComboBox (JComboBox comboBox, String NameOfTable, String NameOfField) {
		try {
			
			connection = dbConnection.dbConnector();
			
			String sql = "Select * from " + NameOfTable;
			PreparedStatement pat = connection.prepareStatement(sql);
			ResultSet rs = pat.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString(NameOfField);		
				comboBox.addItem(name);	
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void fillComboBoxWhere (JComboBox comboBox, String NameOfTable, String NameOfField, String WhereField, String WhereValue) {
		try {
			
			connection = dbConnection.dbConnector();
			
			String sql = "SELECT * FROM " + NameOfTable + " WHERE " + WhereField + " = '" + WhereValue + "'";
			PreparedStatement pat = connection.prepareStatement(sql);
			ResultSet rs = pat.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString(NameOfField);		
				comboBox.addItem(name);	
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void fillComboBoxDependenceOtherCB (JComboBox<String> cb, String NameOfTable, String NameOfField, String WhereField, String WhereValue) {
		
		ConvertDataFromDBtoArrayList cdf = new ConvertDataFromDBtoArrayList();				
		ArrayList<String> al = cdf.dataFromDBtoALwhere(NameOfTable, NameOfField, WhereField, WhereValue);											
							
		cb.setModel(new DefaultComboBoxModel(al.toArray()));
	}

}
