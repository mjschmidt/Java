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

public class Login {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
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

		JLabel lblEmployeeTools = new JLabel("Domino's Login");
		lblEmployeeTools.setForeground(UIManager
				.getColor("EditorPane.inactiveBackground"));
		lblEmployeeTools.setFont(new Font("Times New Roman", Font.BOLD, 26));
		panel.add(lblEmployeeTools);

		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(4, 3, 0, 5));
		
		JLabel lblNewLabel = new JLabel("");
		panel_3.add(lblNewLabel);

		JLabel lblWelcomeToDominos = new JLabel("Welcome to Domino's Pizza");
		lblWelcomeToDominos.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblWelcomeToDominos.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblWelcomeToDominos);
		
		JLabel label_1 = new JLabel("");
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panel_3.add(label_2);

		JLabel lblEnterPin = new JLabel("Enter PIN");
		lblEnterPin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEnterPin.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblEnterPin.setBackground(new Color(238, 238, 238));
		lblEnterPin.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblEnterPin);
		
		JLabel label_3 = new JLabel("");
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("");
		panel_3.add(label_4);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_3.add(textField);
		textField.setColumns(10);

		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel label_5 = new JLabel("");
		panel_3.add(label_5);
		
		JLabel label_6 = new JLabel("");
		panel_3.add(label_6);
		panel_3.add(btnLogin);
		
		JLabel label = new JLabel("");
		panel_3.add(label);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
