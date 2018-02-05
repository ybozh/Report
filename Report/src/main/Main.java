import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Main {

	private JFrame frmMyReport;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMyReport.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
	}
	
	Connection connection = null;

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		connection = dbConnection.dbConnector();
		try {
			if (connection!=null || !connection.isClosed()) {
				JOptionPane.showMessageDialog(null, "Connection is Ok!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
		}
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmMyReport = new JFrame();
		frmMyReport.setFont(new Font("Verdana", Font.PLAIN, 11));
		frmMyReport.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 11));
		frmMyReport.setTitle("My Report");
		frmMyReport.setBounds(100, 100, 961, 633);
		frmMyReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMyReport.getContentPane().setLayout(null);
		
		JLabel lblDateOfReport = new JLabel("Date of report");
		lblDateOfReport.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDateOfReport.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfReport.setBounds(-26, 35, 130, 14);
		frmMyReport.getContentPane().add(lblDateOfReport);
		
		JDateChooser dateChooser_DR = new JDateChooser();
		dateChooser_DR.setBounds(114, 32, 158, 20);
		frmMyReport.getContentPane().add(dateChooser_DR);
		
		JLabel lblStartOfTrip = new JLabel("Start of trip");
		lblStartOfTrip.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblStartOfTrip.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStartOfTrip.setBounds(-26, 63, 130, 14);
		frmMyReport.getContentPane().add(lblStartOfTrip);
		
		JLabel lblFinishOfTrip = new JLabel("Finish of trip");
		lblFinishOfTrip.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblFinishOfTrip.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFinishOfTrip.setBounds(-26, 88, 130, 14);
		frmMyReport.getContentPane().add(lblFinishOfTrip);
		
		JDateChooser dateChooser_StartTr = new JDateChooser();
		dateChooser_StartTr.setBounds(114, 60, 158, 20);
		frmMyReport.getContentPane().add(dateChooser_StartTr);
		
		JDateChooser dateChooser_FinishTr = new JDateChooser();
		dateChooser_FinishTr.setBounds(114, 85, 158, 20);
		frmMyReport.getContentPane().add(dateChooser_FinishTr);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setBounds(-26, 115, 130, 14);
		frmMyReport.getContentPane().add(lblUser);
		
		JButton btnSaveToDb = new JButton("Save to DB");
		btnSaveToDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SaveToDB std = new SaveToDB();
				std.createRow("Engineers");				
				std.updateLastCreatedRow("Engineers", "CodeName", comboBox.getSelectedItem().toString());
				std.updateLastCreatedRow("Engineers", "Name", "Ivan");
				
				std.createRow("Payment");
				std.updateLastCreatedRow("Payment", "DateOfPay", dateChooser_DR.getDate().toString());
				
				std.selectAllFromRow("Engineers", "CodeName", comboBox.getSelectedItem().toString());
				
				
				
				
		
				
			}
		});
		btnSaveToDb.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnSaveToDb.setBounds(10, 223, 119, 23);
		frmMyReport.getContentPane().add(btnSaveToDb);
		
		comboBox = new JComboBox();		
		
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboBox.setBounds(114, 113, 158, 20);
		frmMyReport.getContentPane().add(comboBox);
		FillComboBox fillComboBox1 = new FillComboBox();
		fillComboBox1.fillComboBox(comboBox, "Engineers", "CodeName");
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Verdana", Font.PLAIN, 11));
		spinner.setBounds(114, 144, 158, 20);		
		spinner.setValue(320.00);
		frmMyReport.getContentPane().add(spinner);
		
		JLabel lblDaySalary = new JLabel("Day Salary");
		lblDaySalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDaySalary.setFont(new Font("Verdana", Font.PLAIN, 11));
		lblDaySalary.setBounds(-26, 147, 130, 14);
		frmMyReport.getContentPane().add(lblDaySalary);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Verdana", Font.PLAIN, 12));
		frmMyReport.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Verdana", Font.PLAIN, 11));
		menuBar.add(mnFile);
		
		JMenuItem mntmNewReport = new JMenuItem("New report");
		mntmNewReport.setFont(new Font("Verdana", Font.PLAIN, 11));
		mntmNewReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReportCreatorForm rcf = new ReportCreatorForm();
				rcf.setVisible(true);
			}
		});
		mnFile.add(mntmNewReport);
		
		JMenu mnNewReport = new JMenu("New report");
		mnNewReport.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnFile.add(mnNewReport);
		
		JMenu mnOpen = new JMenu("Open");
		mnOpen.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnFile.add(mnOpen);
		
		JMenu mnSave = new JMenu("Save");
		mnSave.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnFile.add(mnSave);
		
		JMenu mnSaveAs = new JMenu("Save As");
		mnSaveAs.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnFile.add(mnSaveAs);
		
		JMenu mnText = new JMenu("Text");
		mnText.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnSaveAs.add(mnText);
		
		JMenu mnPdf = new JMenu("PDF");
		mnPdf.setFont(new Font("Verdana", Font.PLAIN, 11));
		mnSaveAs.add(mnPdf);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setFont(new Font("Verdana", Font.PLAIN, 11));
		menuBar.add(mnEdit);
		
		JMenuItem mntmAddToDb = new JMenuItem("ADD to DB");
		mntmAddToDb.setFont(new Font("Verdana", Font.PLAIN, 11));
		mntmAddToDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddCustomerToDB acd;
				try {
					acd = new AddCustomerToDB();
					acd.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e);
				}
				
			}
		});
		mnEdit.add(mntmAddToDb);
		
		JMenu mnSettings = new JMenu("Settings");
		mnSettings.setFont(new Font("Verdana", Font.PLAIN, 11));
		menuBar.add(mnSettings);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Verdana", Font.PLAIN, 11));
		menuBar.add(mnHelp);
		
		
		
	}
}
