import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Font;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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

public class OrderPage {

	private JFrame frame;
	private JTextArea txtRecipt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderPage window = new OrderPage();
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
	public OrderPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane()
				.getLayout();
		frame.getContentPane().setFont(
				new Font("Times New Roman", Font.PLAIN, 12));

		JPanel panel = new JPanel();
		panel.setForeground(SystemColor.text);
		panel.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon("src/logo.png"));
		lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblLogo);

		JLabel lblEmployeeTools = new JLabel("Order Page");
		lblEmployeeTools.setForeground(UIManager
				.getColor("EditorPane.inactiveBackground"));
		lblEmployeeTools.setFont(new Font("Times New Roman", Font.BOLD, 26));
		panel.add(lblEmployeeTools);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.WEST);

		JButton btnEmployeeManagement = new JButton(
				"<html>Employee<br />Management</html>");
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
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));

		txtRecipt = new JTextArea();
		txtRecipt.setColumns(15);
		txtRecipt.setText("Recipt");
		JScrollPane sp = new JScrollPane(txtRecipt);
		panel_2.add(sp);

		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(4, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		panel_3.add(lblNewLabel);

		JButton btnNewButton_1 = new JButton("Pizza");
		panel_3.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Specialty Pizza");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel label = new JLabel("");
		panel_3.add(label);
		
		JLabel label_7 = new JLabel("");
		panel_3.add(label_7);
		panel_3.add(btnNewButton_2);
		
		JLabel label_2 = new JLabel("");
		panel_3.add(label_2);
		
		JLabel label_1 = new JLabel("");
		panel_3.add(label_1);

		JButton btnNewButton_3 = new JButton("Slurm");
		panel_3.add(btnNewButton_3);
		
		JLabel label_3 = new JLabel("");
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("");
		panel_3.add(label_4);

		JButton btnCompleteOrder = new JButton("Complete Order");
		panel_3.add(btnCompleteOrder);
		
		JLabel label_5 = new JLabel("");
		panel_3.add(label_5);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
