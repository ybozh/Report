package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import db.FillComboBox;
import db.SaveToDB;
import db.dbConnection;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class ReportCreatorForm extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportCreatorForm frame = new ReportCreatorForm();
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
	 */
	public ReportCreatorForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDateOfReport = new JLabel("Date of report");
		lblDateOfReport.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDateOfReport.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfReport.setBounds(-26, 35, 130, 14);
		contentPane.add(lblDateOfReport);
		
		JDateChooser dateChooser_DR = new JDateChooser();
		dateChooser_DR.setBounds(114, 32, 158, 20);
		contentPane.add(dateChooser_DR);
		
		JLabel lblStartOfTrip = new JLabel("Start of trip");
		lblStartOfTrip.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblStartOfTrip.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStartOfTrip.setBounds(-26, 63, 130, 14);
		contentPane.add(lblStartOfTrip);
		
		JLabel lblFinishOfTrip = new JLabel("Finish of trip");
		lblFinishOfTrip.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFinishOfTrip.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFinishOfTrip.setBounds(-26, 88, 130, 14);
		contentPane.add(lblFinishOfTrip);
		
		JDateChooser dateChooser_StartTr = new JDateChooser();
		dateChooser_StartTr.setBounds(114, 60, 158, 20);
		contentPane.add(dateChooser_StartTr);
		
		JDateChooser dateChooser_FinishTr = new JDateChooser();
		dateChooser_FinishTr.setBounds(114, 85, 158, 20);
		contentPane.add(dateChooser_FinishTr);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(-26, 115, 130, 14);
		contentPane.add(lblUser);
		
		JButton btnSaveToDb = new JButton("Save to DB");
		btnSaveToDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SaveToDB std = new SaveToDB();
				/*std.createRow("Engineers");				
				std.updateLastCreatedRow("Engineers", "CodeName", comboBox.getSelectedItem().toString());
				std.updateLastCreatedRow("Engineers", "Name", "Ivan");
				
				std.createRow("Payment");
				std.updateLastCreatedRow("Payment", "DateOfPay", dateChooser_DR.getDate().toString());
				
				std.selectAllFromRow("Engineers", "CodeName", comboBox.getSelectedItem().toString());*/
				
				
				std.createRow("Trips");
				std.updateLastCreatedRow("Trips", "DateOfReport", dateChooser_DR.getDate().toString());
				std.updateLastCreatedRow("Trips", "DateOfStart", dateChooser_StartTr.getDate().toString());
				std.updateLastCreatedRow("Trips", "DateOfFinish", dateChooser_FinishTr.getDate().toString());
				std.updateLastCreatedRow("Trips", "CodeOfEngineer", comboBox.getSelectedItem().toString());
				
				
		
				
			}
		});
		btnSaveToDb.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnSaveToDb.setBounds(10, 223, 119, 23);
		contentPane.add(btnSaveToDb);
		
		comboBox = new JComboBox();		
		
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboBox.setBounds(114, 113, 158, 20);
		contentPane.add(comboBox);
		FillComboBox fillComboBox1 = new FillComboBox();
		fillComboBox1.fillComboBox(comboBox, "Engineers", "CodeName");
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Verdana", Font.PLAIN, 11));
		spinner.setBounds(114, 144, 158, 20);		
		spinner.setValue(320.00);
		contentPane.add(spinner);
		
		JLabel lblDaySalary = new JLabel("Day Salary");
		lblDaySalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDaySalary.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDaySalary.setBounds(-26, 147, 130, 14);
		contentPane.add(lblDaySalary);
	}
}
