package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import db.AddCustomerToDB;
import db.FillComboBox;
import db.SaveToDB;
import db.dbConnection;

import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
	}
	
	Connection connection = null;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		
		connection = dbConnection.dbConnector();
		try {
			if (connection!=null || !connection.isClosed()) {
				JOptionPane.showMessageDialog(null, "Connection is Ok!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 633);
		setTitle("My Report!");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Date of report");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Verdana", Font.PLAIN, 11));
		label.setBounds(10, 35, 130, 14);
		contentPane.add(label);
		
		JDateChooser dateChooser_DR = new JDateChooser();
		dateChooser_DR.setBounds(150, 32, 158, 20);
		contentPane.add(dateChooser_DR);
		
		JLabel label_1 = new JLabel("Start of trip");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Verdana", Font.PLAIN, 11));
		label_1.setBounds(10, 63, 130, 14);
		contentPane.add(label_1);
		
		JDateChooser dateChooser_StartTr = new JDateChooser();
		dateChooser_StartTr.setBounds(150, 60, 158, 20);
		contentPane.add(dateChooser_StartTr);
		
		JLabel label_2 = new JLabel("Finish of trip");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		label_2.setBounds(10, 88, 130, 14);
		contentPane.add(label_2);
		
		JDateChooser dateChooser_FinishTr = new JDateChooser();
		dateChooser_FinishTr.setBounds(150, 85, 158, 20);
		contentPane.add(dateChooser_FinishTr);
		
		JLabel label_3 = new JLabel("User");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Verdana", Font.PLAIN, 11));
		label_3.setBounds(10, 115, 130, 14);
		contentPane.add(label_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 11));
		comboBox.setBounds(150, 113, 158, 20);
		contentPane.add(comboBox);
		FillComboBox fillComboBox1 = new FillComboBox();
		fillComboBox1.fillComboBox(comboBox, "Engineers", "CodeName");
		
		JLabel label_4 = new JLabel("Day Salary");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Verdana", Font.PLAIN, 11));
		label_4.setBounds(10, 147, 130, 14);
		contentPane.add(label_4);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Verdana", Font.PLAIN, 11));
		spinner.setBounds(150, 144, 158, 20);
		spinner.setValue(320.00);
		contentPane.add(spinner);
		
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
		btnSaveToDb.setBounds(46, 223, 119, 23);
		contentPane.add(btnSaveToDb);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Verdana", Font.PLAIN, 12));
		menuBar.setBounds(0, 0, 945, 21);
		contentPane.add(menuBar);
		
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
