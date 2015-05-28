import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Font;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JComboBox;


public class ManagePrices {

	private JFrame frame;
	private JTextField txtRecipt;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagePrices window = new ManagePrices();
					window.frame.setSize(new Dimension(800, 500));
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ManagePrices() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon("src/logo.png"));
		lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblLogo);
		
		JLabel lblEmployeeTools = new JLabel("Manage Prices");
		lblEmployeeTools.setForeground(SystemColor.text);
		lblEmployeeTools.setFont(new Font("Times New Roman", Font.BOLD, 26));
		panel.add(lblEmployeeTools);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		
		JButton btnEmployeeManagement = new JButton("<html>Employee<br />Management</html>");
		btnEmployeeManagement.setEnabled(false);
		
		
		btnEmployeeManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.setLayout(new GridLayout(0, 1, 0, 5));
		panel_1.add(btnEmployeeManagement);
		
		JButton btnManagePrices = new JButton("<html>Manage<br />Prices</html>");
		btnManagePrices.setEnabled(false);
		panel_1.add(btnManagePrices);
		
		JButton btnNewButton = new JButton("<html>Place<br />Order</html>");
		btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		panel_1.add(btnCancel);
		
		JButton btnLogout = new JButton("Logout");
		panel_1.add(btnLogout);
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.EAST);
		
		txtRecipt = new JTextField();
		txtRecipt.setHorizontalAlignment(SwingConstants.LEFT);
		txtRecipt.setEnabled(false);
		txtRecipt.setEditable(false);
		txtRecipt.setText("Recipt");
		panel_2.add(txtRecipt);
		txtRecipt.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(9, 2, 0, 0));
		
		JLabel label_8 = new JLabel("");
		panel_3.add(label_8);
		
		JLabel lblNewLabel = new JLabel("Small Pizza Base: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_9 = new JLabel("");
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("");
		panel_3.add(label_10);
		
		JLabel lblNewLabel_1 = new JLabel("Medium Pizza Base: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_11 = new JLabel("");
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("");
		panel_3.add(label_12);
		
		JLabel lblNewLabel_2 = new JLabel("Large Pizza Base: ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		panel_3.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("");
		panel_3.add(label_3);
		
		JLabel lblNewLabel_3 = new JLabel("Topping: ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		panel_3.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_13 = new JLabel("");
		panel_3.add(label_13);
		
		JLabel label_14 = new JLabel("");
		panel_3.add(label_14);
		
		JLabel lblNewLabel_4 = new JLabel("Slurm: ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_4);
		
		textField_5 = new JTextField();
		panel_3.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_15 = new JLabel("");
		panel_3.add(label_15);
		
		JLabel label_16 = new JLabel("");
		panel_3.add(label_16);
		
		JLabel lblNewLabel_5 = new JLabel("Small Specialty Pizza: ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		panel_3.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label = new JLabel("");
		panel_3.add(label);
		
		JLabel label_1 = new JLabel("");
		panel_3.add(label_1);
		
		JLabel lblNewLabel_6 = new JLabel("Medium Specialty Pizza: ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_6);
		
		textField_7 = new JTextField();
		panel_3.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_4 = new JLabel("");
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("");
		panel_3.add(label_5);
		
		JLabel lblNewLabel_7 = new JLabel("Large Specialty Pizza: ");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_3.add(lblNewLabel_7);
		
		textField_8 = new JTextField();
		panel_3.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_6 = new JLabel("");
		panel_3.add(label_6);
		
		JLabel lblNewLabel_8 = new JLabel("");
		panel_3.add(lblNewLabel_8);
		
		JLabel label_17 = new JLabel("");
		panel_3.add(label_17);
		
		JButton btnNewButton_1 = new JButton("Save Prices");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_3.add(btnNewButton_1);
		
		JLabel label_18 = new JLabel("");
		panel_3.add(label_18);
		frame.setBounds(100, 100, 708, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

/*
 Small Pizza Base Price		
		
Medium Pizza Base Price		
		
Large Pizza Base Price		
		
Topping		
		
Soda		
		
Small Specialty Pizza		
		
Medium Specialty Pizza 2		
		
Large Specialty Pizza 3		
 */
