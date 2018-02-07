package db;

import static org.junit.Assert.isArray;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PUBLIC_MEMBER;

import convert.ConvertDataFromDBtoArrayList;

import java.awt.Font;
import java.awt.Frame;
import java.awt.List;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AddCustomerToDB extends JFrame {

	private JPanel contentPane;
	private FilterComboBox fcb1_City;
	private FilterComboBox fcb2_CutomerName;
	public JComboBox comboBox;
	public JComboBox comboBox_2;
	
	Connection connection = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomerToDB frame = new AddCustomerToDB();
					frame.setVisible(true);
					Connection connection = dbConnection.dbConnector();
					
					try {
						if (connection!=null || !connection.isClosed()) {
							JOptionPane.showMessageDialog(null, "Connection is Ok!");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e);
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddCustomerToDB() throws SQLException {
		setFont(new Font("Verdana", Font.PLAIN, 12));
		setTitle("ADD Customer to DB");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 668, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCuctomerName = new JLabel("Customer Name:");
		lblCuctomerName.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCuctomerName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCuctomerName.setBounds(10, 56, 123, 14);
		contentPane.add(lblCuctomerName);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(10, 25, 123, 14);
		contentPane.add(lblCity);		
				
		ConvertDataFromDBtoArrayList cdf1 = new ConvertDataFromDBtoArrayList();
		ArrayList<String> al1 = cdf1.dataFromDBtoAL("Customers", "City");		
		fcb1_City = new FilterComboBox(al1);		
		comboBox = new JComboBox();
		comboBox = fcb1_City;
		comboBox.setBounds(142, 25, 468, 20);
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 11));		
		contentPane.add(comboBox);		
		
		ConvertDataFromDBtoArrayList cdf2 = new ConvertDataFromDBtoArrayList();
		ArrayList<String> al2 = cdf2.dataFromDBtoAL("Customers", "CustomerName");		
		fcb2_CutomerName = new FilterComboBox(al2);		
		comboBox_2 = new JComboBox();				
		comboBox_2 = fcb2_CutomerName;
		comboBox_2.setBounds(142, 53, 468, 20);
		comboBox_2.setFont(new Font("Verdana", Font.PLAIN, 11));		
		contentPane.add(comboBox_2);		
		
		JButton btnAddToDb = new JButton("Add to DB");
		btnAddToDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SaveToDB std = new SaveToDB();
				std.createRow("Customers");
				std.updateLastCreatedRow("Customers", "CustomerName", fcb2_CutomerName.getSelectedItem().toString());
				std.updateLastCreatedRow("Customers", "City", fcb1_City.getSelectedItem().toString());
				
			}
		});
		btnAddToDb.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnAddToDb.setBounds(142, 84, 138, 23);
		contentPane.add(btnAddToDb);
		
		
		   comboBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub				
				
				/*ConvertDataFromDBtoArrayList cdf3 = new ConvertDataFromDBtoArrayList();				
				ArrayList<String> al3 = cdf3.dataFromDBtoALwhere("Customers", "CustomerName", "City", comboBox.getSelectedItem().toString());											
									
				comboBox_2.setModel(new DefaultComboBoxModel(al3.toArray()));*/	
				
				
				if(fcb1_City.getSelectedItem().toString().length() == 0) {
					//comboBox_2.setModel(new DefaultComboBoxModel(al2.toArray()));
					
					//FillComboBox fcb1 = new FillComboBox();
					//fcb1.fillComboBox(fcb1_City, "Customers", "City");
					ConvertDataFromDBtoArrayList cda = new ConvertDataFromDBtoArrayList();
					cda.dataFromDBtoAL("Customers", "City");
					ArrayList<String> al = new ArrayList<String>();
					FilterComboBox fcb2 = new FilterComboBox(al);
					
					fcb1_City.repaint();
					fcb1_City.revalidate();
					fcb1_City.doLayout();
				}else {					
					FillComboBox fcb = new FillComboBox();
					fcb.fillComboBoxDependenceOtherCB(fcb2_CutomerName, "Customers", "CustomerName", "City", fcb1_City.getSelectedItem().toString());
				}
				
				
				
				
			}
		});		
		
	}
}
