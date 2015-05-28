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
import javax.swing.JComboBox;
import java.awt.SystemColor;


public class ManageEmployee {
	public String [] EditNameList = {"Employee to Edit"};
	public String [] RemoveNameList = {"Employee to Remove"};
	private JFrame frame;
	private JTextField txtName;
	private JTextField txtEnterPin;
	private JTextField txtEnterNewName;
	private JTextField txtEnterNewPin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageEmployee window = new ManageEmployee();
					window.frame.setSize(new Dimension(950, 500));
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
	public ManageEmployee() {
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
		panel.setForeground(SystemColor.text);
		panel.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon("src/logo.png"));
		lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblLogo);
		
		JLabel lblEmployeeTools = new JLabel("Manage Employees");
		lblEmployeeTools.setForeground(UIManager.getColor("EditorPane.inactiveBackground"));
		lblEmployeeTools.setFont(new Font("Times New Roman", Font.BOLD, 26));
		panel.add(lblEmployeeTools);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		
		JButton btnEmployeeManagement = new JButton("<html>Employee<br />Management</html>");
		
		
		btnEmployeeManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.setLayout(new GridLayout(0, 1, 0, 5));
		panel_1.add(btnEmployeeManagement);
		
		JButton btnManagePrices = new JButton("<html>Manage<br />Prices</html>");
		panel_1.add(btnManagePrices);
		
		JButton btnNewButton = new JButton("<html>Place<br />Order</html>");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setEnabled(false);
		panel_1.add(btnCancel);
		
		JButton btnLogout = new JButton("Logout");
		panel_1.add(btnLogout);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(13, 3, 0, 5));
		
		JLabel label = new JLabel("");
		panel_3.add(label);
		
		JLabel lblAddEmployee = new JLabel("Add Employee");
		lblAddEmployee.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblAddEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblAddEmployee);
		
		JLabel label_1 = new JLabel("");
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panel_3.add(label_2);
		
		txtName = new JTextField();
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setText("Enter Name");
		panel_3.add(txtName);
		txtName.setColumns(10);
		
		JLabel label_3 = new JLabel("");
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("");
		panel_3.add(label_4);
		
		txtEnterPin = new JTextField();
		txtEnterPin.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterPin.setText("Enter PIN");
		panel_3.add(txtEnterPin);
		txtEnterPin.setColumns(10);
		
		JLabel label_5 = new JLabel("");
		panel_3.add(label_5);
		
		JLabel label_6 = new JLabel("");
		panel_3.add(label_6);
		
		JButton btnSubmitt = new JButton("Submitt");
		panel_3.add(btnSubmitt);
		
		JLabel label_7 = new JLabel("");
		panel_3.add(label_7);
		
		JLabel label_8 = new JLabel("");
		panel_3.add(label_8);
		
		JLabel lblEditEmloyee = new JLabel("Edit Emloyee");
		lblEditEmloyee.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblEditEmloyee.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblEditEmloyee);
		
		JLabel label_9 = new JLabel("");
		panel_3.add(label_9);
		
		JLabel label_10 = new JLabel("");
		panel_3.add(label_10);
		
		JComboBox comboBox = new JComboBox(EditNameList);
		
		panel_3.add(comboBox);
		
		JLabel label_11 = new JLabel("");
		panel_3.add(label_11);
		
		JLabel label_12 = new JLabel("");
		panel_3.add(label_12);
		
		txtEnterNewName = new JTextField();
		txtEnterNewName.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterNewName.setText("Enter New Name");
		panel_3.add(txtEnterNewName);
		txtEnterNewName.setColumns(10);
		
		JLabel label_13 = new JLabel("");
		panel_3.add(label_13);
		
		JLabel label_14 = new JLabel("");
		panel_3.add(label_14);
		
		txtEnterNewPin = new JTextField();
		txtEnterNewPin.setText("Enter New PIN");
		txtEnterNewPin.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterNewPin.setColumns(10);
		panel_3.add(txtEnterNewPin);
		
		JLabel label_15 = new JLabel("");
		panel_3.add(label_15);
		
		JLabel label_16 = new JLabel("");
		panel_3.add(label_16);
		
		JButton button = new JButton("Submitt");
		panel_3.add(button);
		
		JLabel label_17 = new JLabel("");
		panel_3.add(label_17);
		
		JLabel label_18 = new JLabel("");
		panel_3.add(label_18);
		
		JLabel lblRemoveEmployee = new JLabel("Remove Employee");
		lblRemoveEmployee.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblRemoveEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblRemoveEmployee);
		
		JLabel label_19 = new JLabel("");
		panel_3.add(label_19);
		
		JLabel label_20 = new JLabel("");
		panel_3.add(label_20);
		
		JComboBox comboBox_1 = new JComboBox(RemoveNameList);
		panel_3.add(comboBox_1);
		
		JLabel label_21 = new JLabel("");
		panel_3.add(label_21);
		
		JLabel label_22 = new JLabel("");
		panel_3.add(label_22);
		
		JButton button_1 = new JButton("Submitt");
		panel_3.add(button_1);
		
		JLabel label_23 = new JLabel("");
		panel_3.add(label_23);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
