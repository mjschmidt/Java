import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Font;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
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
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;


public class BuildPizza {

	private JFrame frame;
	private JTextArea txtRecipt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuildPizza window = new BuildPizza();
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
	public BuildPizza() {
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
		panel.setBackground(UIManager.getColor("Desktop.background"));
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblLogo = new JLabel();
		lblLogo.setIcon(new ImageIcon("src/logo.png"));
		lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblLogo);
		
		JLabel lblEmployeeTools = new JLabel("Pizza");
		lblEmployeeTools.setForeground(UIManager.getColor("EditorPane.inactiveBackground"));
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
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		txtRecipt = new JTextArea();
		txtRecipt.setColumns(15);
		txtRecipt.setText("Recipt");
		JScrollPane sp = new JScrollPane(txtRecipt); 
		panel_2.add(sp);
		
		JPanel panel_3 = new JPanel();
		frame.getContentPane().add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Size");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		panel_4.add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		ButtonGroup group = new ButtonGroup();
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new GridLayout(1, 0, 0, 0));
		
		JRadioButton RBSmall = new JRadioButton("Small");
		panel_8.add(RBSmall);
		//panel_4.add(RBSmall, BorderLayout.CENTER);
		RBSmall.setHorizontalAlignment(SwingConstants.CENTER);
		group.add(RBSmall);
		
		JRadioButton RBMedium = new JRadioButton("Medium");
		panel_8.add(RBMedium);
		//panel_4.add(RBMedium, BorderLayout.CENTER);
		RBMedium.setHorizontalAlignment(SwingConstants.CENTER);
		group.add(RBMedium);
		
		JRadioButton RBLarge = new JRadioButton("Large");
		panel_8.add(RBLarge);
		//panel_4.add(RBLarge, BorderLayout.CENTER);
		RBLarge.setHorizontalAlignment(SwingConstants.CENTER);
		group.add(RBLarge);
		
		JLabel lblToppings = new JLabel("Toppings");
		panel_4.add(lblToppings, BorderLayout.SOUTH);
		lblToppings.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblToppings.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(4, 3, 0, 0));
		
		JCheckBox chckbxPeperoni = new JCheckBox("Peperoni");
		panel_6.add(chckbxPeperoni);
		
		JCheckBox chckbxOnions = new JCheckBox("Onions");
		panel_6.add(chckbxOnions);
		
		JCheckBox chckbxBacon = new JCheckBox("Bacon");
		panel_6.add(chckbxBacon);
		
		JCheckBox chckbxBlackOlives = new JCheckBox("Black Olives");
		panel_6.add(chckbxBlackOlives);
		
		JCheckBox chckbxHam = new JCheckBox("Ham");
		panel_6.add(chckbxHam);
		
		JCheckBox chckbxExtraCheese = new JCheckBox("Extra Cheese");
		panel_6.add(chckbxExtraCheese);
		
		JCheckBox chckbxMushrooms = new JCheckBox("Mushrooms");
		panel_6.add(chckbxMushrooms);
		
		JCheckBox chckbxGreenPeppers = new JCheckBox("Green Peppers");
		panel_6.add(chckbxGreenPeppers);
		
		JCheckBox chckbxChicken = new JCheckBox("Chicken");
		panel_6.add(chckbxChicken);
	
		JCheckBox chckbxPineapple = new JCheckBox("Pineapple");
		panel_6.add(chckbxPineapple);
		
		JCheckBox chckbxSausage = new JCheckBox("Sausage");
		panel_6.add(chckbxSausage);
		
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel_7.add(lblNewLabel_1);
		
		
		JLabel lblNumberOfPizzas = new JLabel("Number of Pizzas");
		panel_7.add(lblNumberOfPizzas);
		lblNumberOfPizzas.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNumberOfPizzas.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_3 = new JLabel("");
		panel_7.add(label_3);
		
		JLabel label = new JLabel("");
		panel_7.add(label);
		
		JTextField NumOfPizzas = new JTextField();
		panel_7.add(NumOfPizzas);
		NumOfPizzas.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_2 = new JLabel("");
		panel_7.add(label_2);
		
		JLabel label_4 = new JLabel("");
		panel_7.add(label_4);
		
		JButton btnSubmitNumOfPizzas = new JButton("Submit");
		panel_7.add(btnSubmitNumOfPizzas);
		
		JLabel label_1 = new JLabel("");
		panel_7.add(label_1);
		
		
		frame.setBounds(100, 100, 745, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
