import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Font;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
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
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

import java.awt.SystemColor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class Dominos {
	
	public JPanel Center;
	public JPanel North;
	public JPanel East;
	public JPanel West;
	
	//Heading Labels
	public JLabel lblLogo;
	public JLabel lblTitle;
	public JLabel lblUser;
	
	//Login Buttons
	JButton btnLogin;
	
	//Login fields
	JTextField txtLoginInput;
	
	//Home Buttons
	JButton btnEmployeeManagement;
	JButton btnManagePrices;
	JButton btnPlaceOrder;
	JButton btnCancel;
	JButton btnLogout;
	
	//Manage Employee Buttons
	JButton btnNewSubmit;
	JButton btnEditSubmit;
	JButton btnRemoveSubmit;
	
	//Manage Employee Fields
	JTextField txtNewName;
	JTextField txtNewPin;
	JTextField txtEditName;
	JTextField txtEditPin;
	
	//Manage Employee comboboxes
	JComboBox comboBoxRemoveName;
	JComboBox comboBoxEditName;
	
	//Manage prices Fields
	JTextField txtSmPizzaPrice;
	JTextField txtMPizzaPrice;
	JTextField txtLPizzaPrice;
	JTextField txtToppingPrice;
	JTextField txtSlurmPrice;
	JTextField txtSmSpecialPrice;
	JTextField txtMSpecialPrice;
	JTextField txtLSpecialPrice;
	JTextField txtTax;
	
	//Manage prices buttons
	JButton btnSavePrices;
	
	//Place Order Buttons
	JButton btnPizza;
	JButton btnSpecial;
	JButton btnSlurm;
	JButton btnCompleteOrder;
	
	//Place Order Receipt
	JTextArea TARecipt;
	
	//Special Pizza build Radio Buttons
	JRadioButton SpecialRBSmall;
	JRadioButton SpecialRBMedium;
	JRadioButton SpecialRBLarge;
	
	JRadioButton rdbtnVeggie;
	JRadioButton rdbtnMeatlovers;
	
	//Special Pizza Build Fields
	JTextField txtNumOfSpecialPizzas;
	
	//Special Pizza Buttons
	JButton btnSubmitNumOfSpecialPizzas;
	JButton btnCancelSpecial;
	
	//Pizza Radio Buttons
	JRadioButton RBSmall;
	JRadioButton RBMedium;
	JRadioButton RBLarge;
	
	//Pizza check boxes
	JCheckBox chckbxPepperoni;
	JCheckBox chckbxOnions;
	JCheckBox chckbxBacon;
	JCheckBox chckbxBlackOlives;
	JCheckBox chckbxHam;
	JCheckBox chckbxExtraCheese;
	JCheckBox chckbxMushrooms;
	JCheckBox chckbxGreenPeppers;
	JCheckBox chckbxChicken;
	JCheckBox chckbxPineapple;
	JCheckBox chckbxSausage;
	
	//Pizza txt fields
	JTextField txtNumOfPizzas;
	
	//Pizza Jbutton
	JButton btnSubmitNumOfPizzas;
	JButton btnCancelRegular;
	
	
	public ArrayList <String>PINList;
	public ArrayList<String> NameList;
	public ArrayList<Double> PricesList;
	
	public String CurrentUser;
	public int numOfSlurms=0;
	
	public ArrayList<Pizza>PizzaOrder;
	
	public double orderNumber;
	
	public int numberOfPizzas;
	
	public double SmPizzaPrice;
	public double MPizzaPrice;
	public double LPizzaPrice;
	public double ToppingPrice;
	public double SlurmPrice;
	public double SmSpecialPrice;
	public double MSpecialPrice;
	public double LSpecialPrice;
	public double Tax;
	
	public double subTotal=0;
	public double grandTotal=0;
	public double salesTax=0;
	
	private JFrame frame;
	public BorderLayout borderLayout;
	
	DecimalFormat df = new DecimalFormat("0.00"); 
	DecimalFormat intf = new DecimalFormat("#.#");
		// scanners for file scanning
		private Scanner scanForEmployeeFile;
		private Scanner scanForPinsFile;
		private Scanner scanForPricesFile;

		// Formatters for creating new text files
		private Formatter makeEmployeeFile;
		private Formatter makePinsFile;
		private Formatter makePricesFile;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dominos window = new Dominos();
					window.frame.setSize(new Dimension(1000, 500));
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
	public Dominos() {
		initialize();
	}
	
	public void Login(){
		
		Center.removeAll();
		Center = new JPanel();
		lblTitle.setText("Domino's Login");
		
		frame.getContentPane().add(Center, BorderLayout.CENTER);
		
		Center.setLayout(new GridLayout(4, 3, 0, 5));
		
		JLabel Blank1 = new JLabel("");
		Center.add(Blank1);

		JLabel lblWelcomeToDominos = new JLabel("Welcome to Domino's Pizza");
		lblWelcomeToDominos.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblWelcomeToDominos.setHorizontalAlignment(SwingConstants.CENTER);
		Center.add(lblWelcomeToDominos);
		
		JLabel Blank2 = new JLabel("");
		Center.add(Blank2);
		
		JLabel Blank3 = new JLabel("");
		Center.add(Blank3);

		JLabel lblEnterPin = new JLabel("Enter PIN");
		lblEnterPin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEnterPin.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblEnterPin.setBackground(new Color(238, 238, 238));
		lblEnterPin.setHorizontalAlignment(SwingConstants.CENTER);
		Center.add(lblEnterPin);
		
		JLabel Blank4 = new JLabel("");
		Center.add(Blank4);
		
		JLabel Blank5 = new JLabel("");
		Center.add(Blank5);

		txtLoginInput = new JTextField();
		txtLoginInput.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoginInput.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		txtLoginInput.setDocument(new JTextFieldLimit(4));
		
		
		Center.add(txtLoginInput);
		txtLoginInput.setColumns(10);

		//btnLogin = new JButton("Login");
		//btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		//Center.add(btnLogin);
		
		JLabel Blank6 = new JLabel("");
		Center.add(Blank6);
		
		JLabel Blank7 = new JLabel("");
		Center.add(Blank7);
		
		Center.add(btnLogin);
		
		JLabel Blank8 = new JLabel("");
		Center.add(Blank8);
		
		Center.revalidate();  
	    Center.repaint(); 
	    
	}

	
	public void Home(){
		
	East.removeAll();
	frame.remove(East);
	West.removeAll();
	frame.remove(West);
		
	Center.removeAll();
	//East.removeAll();
	//West.removeAll();
	
	frame.remove(Center);
	
	lblTitle.setText("Home");
		
	West = new JPanel();
	frame.getContentPane().add(West, BorderLayout.WEST);	
	West.setLayout(new GridLayout(0, 1, 0, 5));
	
	btnCancel.setEnabled(false);
	btnEmployeeManagement.setEnabled(true);
	btnManagePrices.setEnabled(true);
	btnPlaceOrder.setEnabled(true);
	
	btnEmployeeManagement.setForeground(Color.BLACK);
	btnManagePrices.setForeground(Color.BLACK);
	btnPlaceOrder.setForeground(Color.BLACK);
	
	btnCancel.setText("Cancel");
	btnCancel.setForeground(Color.GRAY);
	
	West.add(btnEmployeeManagement);
	West.add(btnManagePrices);
	West.add(btnPlaceOrder);
	West.add(btnCancel);
	West.add(btnLogout);
	
	Center = new JPanel();
	frame.getContentPane().add(Center, BorderLayout.CENTER);
	Center.setLayout(new GridLayout(0, 1, 0, 5));
	
	JLabel lblSlogan = new JLabel("Get The Door, Its Domino's");
	lblSlogan.setBackground(Color.LIGHT_GRAY);
	lblSlogan.setForeground(Color.BLACK);
	lblSlogan.setFont(new Font("Times New Roman", Font.PLAIN, 31));
	lblSlogan.setHorizontalAlignment(SwingConstants.CENTER);
	Center.add(lblSlogan);
	
	Center.revalidate();  
    Center.repaint(); 
	
	}
	
	
	public void ManageEmployees(){
		btnEmployeeManagement.setEnabled(false);
		btnManagePrices.setEnabled(false);
		btnPlaceOrder.setEnabled(false);
		btnCancel.setEnabled(true);
		
		btnEmployeeManagement.setForeground(Color.GRAY);
		btnManagePrices.setForeground(Color.GRAY);
		btnPlaceOrder.setForeground(Color.GRAY);
		btnCancel.setForeground(Color.BLACK);
		
		West.removeAll();
		frame.remove(West);
		West = new JPanel();
		frame.getContentPane().add(West, BorderLayout.WEST);	
		West.setLayout(new GridLayout(0, 1, 0, 5));

		West.add(btnEmployeeManagement);
		West.add(btnManagePrices);
		West.add(btnPlaceOrder);
		West.add(btnCancel);
		West.add(btnLogout);
		
		Center.removeAll();
		frame.remove(Center);
		
		lblTitle.setText("Employee Management");
		

		frame.getContentPane().add(Center, BorderLayout.CENTER);
		Center.setLayout(new GridLayout(13, 3, 0, 5));
		
		JLabel Blank1 = new JLabel("");
		Center.add(Blank1);
		
		JLabel lblAddEmployee = new JLabel("Add Employee");
		lblAddEmployee.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblAddEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		Center.add(lblAddEmployee);
		
		JLabel Blank2 = new JLabel("");
		Center.add(Blank2);
		
		JLabel Blank3 = new JLabel("Enter Name:", SwingConstants.RIGHT);
		Center.add(Blank3);
		
		txtNewName = new JTextField();
		txtNewName.setHorizontalAlignment(SwingConstants.CENTER);
		//txtNewName.setText("Enter Name");
		Center.add(txtNewName);
		txtNewName.setColumns(10);
		
		JLabel Blank4 = new JLabel("");
		Center.add(Blank4);
		
		JLabel Blank5 = new JLabel("Enter PIN:", SwingConstants.RIGHT);
		Center.add(Blank5);
		
		txtNewPin = new JTextField();
		txtNewPin.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewPin.setDocument(new JTextFieldLimit(4));
		Center.add(txtNewPin);
		txtNewPin.setColumns(10);
		
		JLabel Blank6 = new JLabel("");
		Center.add(Blank6);
		
		JLabel Blank7 = new JLabel("");
		Center.add(Blank7);
		
		//btnNewSubmit = new JButton("Submit");
		Center.add(btnNewSubmit);
		
		JLabel Blank8 = new JLabel("");
		Center.add(Blank8);
		
		JLabel Blank9 = new JLabel("");
		Center.add(Blank9);
		
		JLabel lblEditEmloyee = new JLabel("Edit Employee");
		lblEditEmloyee.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblEditEmloyee.setHorizontalAlignment(SwingConstants.CENTER);
		Center.add(lblEditEmloyee);
		
		JLabel Blank10 = new JLabel("");
		Center.add(Blank10);
		
		JLabel Blank11 = new JLabel("");
		Center.add(Blank11);
		
		String editDefault = "Select Name to Edit";
		comboBoxEditName = new JComboBox();
		comboBoxEditName.addItem(editDefault);
		for (String item : NameList) {
		    comboBoxEditName.addItem(item);
		}
		
		Center.add(comboBoxEditName);
		
		JLabel Blank12 = new JLabel("");
		Center.add(Blank12);
		
		JLabel Blank13 = new JLabel("Enter New Name:", SwingConstants.RIGHT);
		Center.add(Blank13);
		
		txtEditName = new JTextField();
		txtEditName.setHorizontalAlignment(SwingConstants.CENTER);
		//txtEditName.setText("Enter New Name");
		Center.add(txtEditName);
		txtEditName.setColumns(10);
		
		JLabel Blank14 = new JLabel("");
		Center.add(Blank14);
		
		JLabel Blank15 = new JLabel("Enter New PIN:", SwingConstants.RIGHT);
		Center.add(Blank15);
		
		txtEditPin = new JTextField();
		txtEditPin.setDocument(new JTextFieldLimit(4));
		txtEditPin.setHorizontalAlignment(SwingConstants.CENTER);
		txtEditPin.setColumns(10);
		Center.add(txtEditPin);
		
		JLabel Blank16 = new JLabel("");
		Center.add(Blank16);
		
		JLabel Blank17 = new JLabel("");
		Center.add(Blank17);
		
		//btnEditSubmit = new JButton("Submit");
		Center.add(btnEditSubmit);
		
		JLabel Blank18 = new JLabel("");
		Center.add(Blank18);
		
		JLabel Blank19 = new JLabel("");
		Center.add(Blank19);
		
		JLabel lblRemoveEmployee = new JLabel("Remove Employee");
		lblRemoveEmployee.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblRemoveEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		Center.add(lblRemoveEmployee);
		
		JLabel Blank20 = new JLabel("");
		Center.add(Blank20);
		
		JLabel Blank21 = new JLabel("");
		Center.add(Blank21);
		
		comboBoxRemoveName = new JComboBox();
		String removeDefault = "Select Name to Remove";
		comboBoxRemoveName.addItem(removeDefault);
		for (String item : NameList) {
		    if(item.equals(CurrentUser)==false){comboBoxRemoveName.addItem(item);}
		}
		Center.add(comboBoxRemoveName);
		
		JLabel Blank22 = new JLabel("");
		Center.add(Blank22);
		
		JLabel Blank23 = new JLabel("");
		Center.add(Blank23);
		
		//btnRemoveSubmit = new JButton("Submit");
		Center.add(btnRemoveSubmit);
		
		JLabel Blank24 = new JLabel("");
		Center.add(Blank24);
		
		Center.revalidate();  
	    Center.repaint(); 
		
	}
	
	
	public void PlaceOrder(){
		
		Center.removeAll();
		frame.remove(Center);
		
		East.removeAll();
		frame.remove(East);
		
		lblTitle.setText("Place Order");
		
		receipt();
		
		Center = new JPanel();
		frame.getContentPane().add(Center, BorderLayout.CENTER);
		Center.setLayout(new GridLayout(4, 3, 0, 0));
		
		JLabel Blank1 = new JLabel("");
		Center.add(Blank1);

		//btnPizza = new JButton("Pizza");
		Center.add(btnPizza);

		JLabel Blank2 = new JLabel("");
		Center.add(Blank2);
		
		JLabel Blank3 = new JLabel("");
		Center.add(Blank3);
		
		//btnSpecial = new JButton("Specialty Pizza");
		Center.add(btnSpecial);
		
		JLabel Blank4 = new JLabel("");
		Center.add(Blank4);
		
		JLabel Blank5 = new JLabel("");
		Center.add(Blank5);

		//btnSlurm = new JButton("Slurm");
		Center.add(btnSlurm);
		
		JLabel Blank6 = new JLabel("");
		Center.add(Blank6);
		
		JLabel Blank7 = new JLabel("");
		Center.add(Blank7);

		if(PizzaOrder.size()<1 && numOfSlurms==0){
			btnCompleteOrder.setForeground(Color.GRAY);
			btnCompleteOrder.setEnabled(false);
		}else{
			btnCompleteOrder.setEnabled(true);
			btnCompleteOrder.setForeground(Color.BLACK);
			}
		
		Center.add(btnCompleteOrder);
		
		JLabel Blank8 = new JLabel("");
		Center.add(Blank8);
		
		Center.revalidate();  
	    Center.repaint(); 
	}
	
	
	public void BuildPizza(){
		
		Center.removeAll();
		frame.remove(Center);
		
		lblTitle.setText("Add a Pizza");
		
		Center = new JPanel();
		frame.getContentPane().add(Center, BorderLayout.CENTER);
		Center.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel C1 = new JPanel();
		Center.add(C1);
		C1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSize.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		C1.add(lblSize, BorderLayout.NORTH);
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		
		ButtonGroup group = new ButtonGroup();
		
		JPanel C11 = new JPanel();
		C1.add(C11, BorderLayout.CENTER);
		C11.setLayout(new GridLayout(1, 0, 0, 0));
		
		RBSmall = new JRadioButton("Small",true);
		C11.add(RBSmall);
		RBSmall.setHorizontalAlignment(SwingConstants.CENTER);
		group.add(RBSmall);
		
		RBMedium = new JRadioButton("Medium");
		C11.add(RBMedium);
		RBMedium.setHorizontalAlignment(SwingConstants.CENTER);
		group.add(RBMedium);
		
		RBLarge = new JRadioButton("Large");
		C11.add(RBLarge);
		RBLarge.setHorizontalAlignment(SwingConstants.CENTER);
		group.add(RBLarge);
		
		JLabel lblToppings = new JLabel("Toppings");
		C1.add(lblToppings, BorderLayout.SOUTH);
		lblToppings.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblToppings.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel C2 = new JPanel();
		Center.add(C2);
		C2.setLayout(new BorderLayout(0, 0));
		
		JPanel C21 = new JPanel();
		C2.add(C21, BorderLayout.CENTER);
		C21.setLayout(new GridLayout(4, 3, 0, 0));
		
		chckbxPepperoni = new JCheckBox("Pepperoni");
		C21.add(chckbxPepperoni);
		
		chckbxOnions = new JCheckBox("Onions");
		C21.add(chckbxOnions);
		
		chckbxBacon = new JCheckBox("Bacon");
		C21.add(chckbxBacon);
		
		chckbxBlackOlives = new JCheckBox("Black Olives");
		C21.add(chckbxBlackOlives);
		
		chckbxHam = new JCheckBox("Ham");
		C21.add(chckbxHam);
		
		chckbxExtraCheese = new JCheckBox("Extra Cheese");
		C21.add(chckbxExtraCheese);
		
		chckbxMushrooms = new JCheckBox("Mushrooms");
		C21.add(chckbxMushrooms);
		
		chckbxGreenPeppers = new JCheckBox("Green Peppers");
		C21.add(chckbxGreenPeppers);
		
		chckbxChicken = new JCheckBox("Chicken");
		C21.add(chckbxChicken);
	
		chckbxPineapple = new JCheckBox("Pineapple");
		C21.add(chckbxPineapple);
		
		chckbxSausage = new JCheckBox("Sausage");
		C21.add(chckbxSausage);
		
		
		JPanel C3 = new JPanel();
		Center.add(C3);
		C3.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel Blank1 = new JLabel("");
		C3.add(Blank1);
		
		
		JLabel lblNumberOfPizzas = new JLabel("Number of Pizzas");
		C3.add(lblNumberOfPizzas);
		lblNumberOfPizzas.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNumberOfPizzas.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel Blank2 = new JLabel("");
		C3.add(Blank2);
		
		JLabel blank3 = new JLabel("");
		C3.add(blank3);
		
		txtNumOfPizzas = new JTextField(""+1);
		C3.add(txtNumOfPizzas);
		txtNumOfPizzas.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel blank4 = new JLabel("");
		C3.add(blank4);
		
		JLabel blank5 = new JLabel("");
		C3.add(blank5);
		
		//btnSubmitNumOfPizzas = new JButton("Submit");
		C3.add(btnSubmitNumOfPizzas);
		
		
		C3.add(btnCancelRegular);
		
		Center.revalidate();  
	    Center.repaint(); 
	}
	
	
	public void SpecialPizza(){
		
		Center.removeAll();
		frame.remove(Center);
		
		lblTitle.setText("Add a Specialty Pizza");
		
		Center = new JPanel();
		frame.getContentPane().add(Center, BorderLayout.CENTER);
		Center.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel C1 = new JPanel();
		Center.add(C1);
		C1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSize.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		C1.add(lblSize, BorderLayout.NORTH);
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		
		ButtonGroup group = new ButtonGroup();
		
		JLabel lblSpecials = new JLabel("Specials");
		C1.add(lblSpecials, BorderLayout.SOUTH);
		lblSpecials.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblSpecials.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel C11 = new JPanel();
		C1.add(C11, BorderLayout.CENTER);
		C11.setLayout(new GridLayout(0, 3, 0, 0));
		
		SpecialRBSmall = new JRadioButton("Small",true);
		C11.add(SpecialRBSmall);
		SpecialRBSmall.setHorizontalAlignment(SwingConstants.CENTER);
		group.add(SpecialRBSmall);
		
		SpecialRBMedium = new JRadioButton("Medium");
		C11.add(SpecialRBMedium);
		SpecialRBMedium.setHorizontalAlignment(SwingConstants.CENTER);
		group.add(SpecialRBMedium);
		
		SpecialRBLarge = new JRadioButton("Large");
		C11.add(SpecialRBLarge);
		SpecialRBLarge.setHorizontalAlignment(SwingConstants.CENTER);
		group.add(SpecialRBLarge);
		
		JPanel C2 = new JPanel();
		Center.add(C2);
		C2.setLayout(new GridLayout(1, 0, 0, 0));
		
		rdbtnVeggie = new JRadioButton("Veggie",true);
		rdbtnVeggie.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		rdbtnMeatlovers = new JRadioButton("MeatLovers");
		rdbtnMeatlovers.setHorizontalAlignment(SwingConstants.CENTER);
		
		ButtonGroup g1 = new ButtonGroup();
		g1.add(rdbtnVeggie);
		
		JLabel Blank1 = new JLabel("");
		C2.add(Blank1);
		g1.add(rdbtnMeatlovers);
		
		C2.add(rdbtnMeatlovers);
		C2.add(rdbtnVeggie);
		
		JLabel Blank2 = new JLabel("");
		C2.add(Blank2);
		
		JPanel C3 = new JPanel();
		Center.add(C3);
		C3.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel Blank3 = new JLabel("");
		C3.add(Blank3);
		
		
		JLabel lblNumberOfPizzas = new JLabel("Number of Pizzas");
		C3.add(lblNumberOfPizzas);
		lblNumberOfPizzas.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNumberOfPizzas.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel Blank4 = new JLabel("");
		C3.add(Blank4);
		
		JLabel Blank5 = new JLabel("");
		C3.add(Blank5);
		
		txtNumOfSpecialPizzas = new JTextField(""+1);
		C3.add(txtNumOfSpecialPizzas);
		txtNumOfSpecialPizzas.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel Blank6 = new JLabel("");
		C3.add(Blank6);
		
		JLabel Blank7 = new JLabel("");
		C3.add(Blank7);
		
		//btnSubmitNumOfSpecialPizzas = new JButton("Submit");
		C3.add(btnSubmitNumOfSpecialPizzas);
		
		
		C3.add(btnCancelSpecial);
		
		Center.revalidate();  
	    Center.repaint(); 
		
	}
	
	
	public void ManagePrices(){
		
		btnEmployeeManagement.setEnabled(false);
		btnManagePrices.setEnabled(false);
		btnPlaceOrder.setEnabled(false);
		btnCancel.setEnabled(true);
		
		btnEmployeeManagement.setForeground(Color.GRAY);
		btnManagePrices.setForeground(Color.GRAY);
		btnPlaceOrder.setForeground(Color.GRAY);
		btnCancel.setForeground(Color.BLACK);
		
		West.removeAll();
		frame.remove(West);
		West = new JPanel();
		frame.getContentPane().add(West, BorderLayout.WEST);	
		West.setLayout(new GridLayout(0, 1, 0, 5));

		West.add(btnEmployeeManagement);
		West.add(btnManagePrices);
		West.add(btnPlaceOrder);
		West.add(btnCancel);
		West.add(btnLogout);
		
		Center.removeAll();
		frame.remove(Center);
		
		lblTitle.setText("Manage Prices");
		
		Center = new JPanel();
		frame.getContentPane().add(Center, BorderLayout.CENTER);
		Center.setLayout(new GridLayout(10, 2, 0, 0));
		
		JLabel Blank1 = new JLabel("");
		Center.add(Blank1);
		
		JLabel lblSmPizzaPrice = new JLabel("Small Pizza Base: ");
		lblSmPizzaPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		Center.add(lblSmPizzaPrice);
		
		txtSmPizzaPrice = new JTextField(""+ df.format(SmPizzaPrice));
		Center.add(txtSmPizzaPrice);
		txtSmPizzaPrice.setColumns(10);
		
		JLabel Blank2 = new JLabel("");
		Center.add(Blank2);
		
		JLabel Blank3 = new JLabel("");
		Center.add(Blank3);
		
		JLabel lblMPizzaPrice = new JLabel("Medium Pizza Base: ");
		lblMPizzaPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		Center.add(lblMPizzaPrice);
		
		txtMPizzaPrice = new JTextField(""+df.format(MPizzaPrice));
		Center.add(txtMPizzaPrice);
		txtMPizzaPrice.setColumns(10);
		
		JLabel Blank4 = new JLabel("");
		Center.add(Blank4);
		
		JLabel Blank5 = new JLabel("");
		Center.add(Blank5);
		
		JLabel lblLPizzaPrice = new JLabel("Large Pizza Base: ");
		lblLPizzaPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		Center.add(lblLPizzaPrice);
		
		txtLPizzaPrice = new JTextField(""+df.format(LPizzaPrice));
		Center.add(txtLPizzaPrice);
		txtLPizzaPrice.setColumns(10);
		
		JLabel Blank6 = new JLabel("");
		Center.add(Blank6);
		
		JLabel Blank7 = new JLabel("");
		Center.add(Blank7);
		
		JLabel lblToppingPrice = new JLabel("Topping: ");
		lblToppingPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		Center.add(lblToppingPrice);
		
		txtToppingPrice = new JTextField(""+df.format(ToppingPrice));
		Center.add(txtToppingPrice);
		txtToppingPrice.setColumns(10);
		
		JLabel Blank8 = new JLabel("");
		Center.add(Blank8);
		
		JLabel Blank9 = new JLabel("");
		Center.add(Blank9);
		
		JLabel lblSlurmPrice = new JLabel("Slurm: ");
		lblSlurmPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		Center.add(lblSlurmPrice);
		
		txtSlurmPrice = new JTextField(""+df.format(SlurmPrice));
		Center.add(txtSlurmPrice);
		txtSlurmPrice.setColumns(10);
		
		JLabel Blank10 = new JLabel("");
		Center.add(Blank10);
		
		JLabel Blank11 = new JLabel("");
		Center.add(Blank11);
		
		JLabel lblSmSpecialPrice = new JLabel("Small Specialty Pizza: ");
		lblSmSpecialPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		Center.add(lblSmSpecialPrice);
		
		txtSmSpecialPrice = new JTextField(""+df.format(SmSpecialPrice));
		Center.add(txtSmSpecialPrice);
		txtSmSpecialPrice.setColumns(10);
		
		JLabel Blank12 = new JLabel("");
		Center.add(Blank12);
		
		JLabel Blank13 = new JLabel("");
		Center.add(Blank13);
		
		JLabel lblMSpecialPrice = new JLabel("Medium Specialty Pizza: ");
		lblMSpecialPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		Center.add(lblMSpecialPrice);
		
		txtMSpecialPrice = new JTextField(""+df.format(MSpecialPrice));
		Center.add(txtMSpecialPrice);
		txtMSpecialPrice.setColumns(10);
		
		JLabel Blank14 = new JLabel("");
		Center.add(Blank14);
		
		JLabel Blank15 = new JLabel("");
		Center.add(Blank15);
		
		JLabel lblLSpecialPrice = new JLabel("Large Specialty Pizza: ");
		lblLSpecialPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		Center.add(lblLSpecialPrice);
		
		txtLSpecialPrice = new JTextField(""+df.format(LSpecialPrice));
		Center.add(txtLSpecialPrice);
		txtLSpecialPrice.setColumns(10);
		
		JLabel Blank16 = new JLabel("");
		Center.add(Blank16);
		
		JLabel Blank17 = new JLabel("");
		Center.add(Blank17);
		
		JLabel lblTax = new JLabel("Tax: ");
		lblTax.setHorizontalAlignment(SwingConstants.RIGHT);
		Center.add(lblTax);
		
		
		txtTax = new JTextField();
		txtTax.setDocument(new JTextFieldLimit(2));
		txtTax.setText(""+intf.format(Tax*100));
		
		Center.add(txtTax);
		txtTax.setColumns(10);
		
		JLabel Blank18 = new JLabel("%");
		Center.add(Blank18);
		
		JLabel Blank19 = new JLabel("");
		Center.add(Blank19);
		
		JLabel Blank20 = new JLabel("");
		Center.add(Blank20);
		
		//btnSavePrices = new JButton("Save Prices");
		Center.add(btnSavePrices);
		
		JLabel Blank21 = new JLabel("");
		Center.add(Blank21);
		
		Center.revalidate();  
	    Center.repaint();
		
	}
	
	
	public double CalculatePrice(Pizza item){
		double baseprice=0;
		double itemTotal=0;
		if(item.Type.equals("regular")){
			if(item.Size.equals("small")){
			baseprice=SmPizzaPrice;
		}
			if(item.Size.equals("medium")){
			baseprice=MPizzaPrice;
		}
			if(item.Size.equals("large")){
			baseprice=LPizzaPrice;
		}
		}else{
				if(item.Size.equals("small")){
				baseprice=SmSpecialPrice;
			}
				if(item.Size.equals("medium")){
				baseprice=MSpecialPrice;
			}
				if(item.Size.equals("large")){
				baseprice=LSpecialPrice;
			}
		}
		itemTotal+=baseprice;
		if(item.Toppings!=null){itemTotal+=ToppingPrice*(item.Toppings.size());}
		itemTotal=item.Number*itemTotal;
		return itemTotal; 
	}
	
	
	public void receipt(){
		East.removeAll();
		frame.remove(East);
		
		East = new JPanel();
		frame.getContentPane().add(East, BorderLayout.EAST);
		East.setLayout(new GridLayout(0, 1, 0, 0));
		
		TARecipt = new JTextArea();
		TARecipt.setColumns(24);
		
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		Date date = new Date();
		//System.out.println(dateFormat.format(date));
		
String orderitems="";		
subTotal=0;
for (Pizza item : PizzaOrder) {
	subTotal+=item.getPrice();
    orderitems+="("+ item.Number +") "+item.Size +" "+item.Type+" pizza \t$" + df.format(item.getPrice()) + "\n";
    if(item.Toppings!=null){
    	for(String element: item.Toppings){
    	orderitems+="               +"+element+"\n";
    	}
    }
}

if(numOfSlurms>0){
	orderitems+="("+numOfSlurms+") "+"Slurm\t\t$"+df.format(numOfSlurms*SlurmPrice)+"\n";
	subTotal+=numOfSlurms*SlurmPrice;
}

salesTax=subTotal*Tax;
grandTotal=salesTax+subTotal;

DecimalFormat DF = new DecimalFormat("0"); 

String Receipt=
"Domino's Pizza\n"+
"Order Number#: "+ DF.format(orderNumber)+"\n"+
"Employee: "+CurrentUser+"\n"+
dateFormat.format(date)+"\n"+
"----------------------------------\n"+
orderitems+

"----------------------------------\n" +
"Subtotal\t\t$" + df.format(subTotal) +"\n"+
//"State Tax\t\t$" + df.format(Tax)+"\n"+
"Sales Tax ("+((int)(100*Tax))+"%)\t\t$" +df.format(salesTax)+ "\n" +
"----------------------------------\n" +
"Grand Total\t\t$"+df.format(grandTotal);

		TARecipt.setText(Receipt);
		TARecipt.setEditable(false);
		JScrollPane sp = new JScrollPane(TARecipt);
		
		East.add(sp);
		East.repaint();
		East.revalidate();
	}
	
	
	public void makeOrOpenEAndPFiles() throws FileNotFoundException {
		try {
			scanForEmployeeFile = new Scanner(new File("EmployeeNames.txt"));
			scanForPinsFile = new Scanner(new File("EmployeePins.txt"));
			
		} catch (FileNotFoundException NotFound) {
				scanForEmployeeFile = null;
				scanForPinsFile = null;
				makeEmployeeFile = new Formatter("EmployeeNames.txt");
				makePinsFile = new Formatter("EmployeePins.txt");
//				
			} catch (SecurityException SecNav) {
				System.err.println("Something is Horribly Wrong");
				System.exit(1);
			}
		}
	
	
	public void read(){
		if ( (null == scanForEmployeeFile) || (null == scanForPinsFile)) return;
		
		//read for employee names
		try{
			while(scanForEmployeeFile.hasNext()){
				String nextInput = scanForEmployeeFile.nextLine();
				NameList.add(nextInput);
			}
		} catch(NoSuchElementException noEl){
			System.err.println("File improperly formatted");
			scanForEmployeeFile.close();
			System.exit(1);
		} catch(IllegalStateException illState){
			System.err.println("Error reading from file");
			System.exit(1);
		}
		
		if (makeEmployeeFile!=null){
			makeEmployeeFile.close();
		}
		
		//second read for pins
		try{
			while(scanForPinsFile.hasNext()){
				String nextInput = scanForPinsFile.nextLine();
				PINList.add(nextInput);
			}
		} catch(NoSuchElementException noEl){
			System.err.println("File improperly formatted");
			scanForEmployeeFile.close();
			System.exit(1);
		} catch(IllegalStateException illState){
			System.err.println("Error reading from file");
			System.exit(1);
		}

		if (scanForPinsFile!=null){
			scanForPinsFile.close();
		}
		
		//Third read method for prices
				try{
					
					while(scanForPricesFile.hasNext()){
						String nextInput = scanForPricesFile.nextLine();
						double input=Double.parseDouble(nextInput);
						PricesList.add(input);
					}
					
					if(PricesList.size()!=0){
					SmPizzaPrice=PricesList.get(0);
					MPizzaPrice=PricesList.get(1);
					LPizzaPrice=PricesList.get(2);
					ToppingPrice=PricesList.get(3);
					SlurmPrice=PricesList.get(4);
					SmSpecialPrice=PricesList.get(5);
					MSpecialPrice=PricesList.get(6);
					LSpecialPrice=PricesList.get(7);
					Tax=PricesList.get(8);
					orderNumber=PricesList.get(9);}
					
				} catch(NoSuchElementException noEl){
					System.err.println("If you saved prices before, there is a problem in the program. Otherwise do not panic, you just have yet to save prices to your text file.");
					scanForPricesFile.close();
					//System.exit(1);
				} catch(IllegalStateException illState){
					System.err.println("Error reading from file");
					System.exit(1);
				}
				
				if (scanForPricesFile!=null){
					scanForPricesFile.close();
				}
	}
	
	public void makeOrOpenPriceFiles() throws FileNotFoundException {
		try {
			scanForPricesFile = new Scanner(new File("Prices.txt"));
		} catch (FileNotFoundException NotFound) {
			scanForPricesFile = null;
			makePricesFile = new Formatter("Prices.txt");
				//System.out.print("making new files");
			} catch (SecurityException SecNav) {
				System.err.println("Something is Horribly Wrong with prices file method");
				System.exit(1);
			}
		}
	
	public void write(){
		try {
			makeEmployeeFile = new Formatter("EmployeeNames.txt");
			makePinsFile = new Formatter("EmployeePins.txt");
			//System.out.println("opening output files");
					
		} catch (FileNotFoundException NotFound) {
			
		} catch (SecurityException SecNav) {
			System.err.println("Something is Horribly Wrong");
			System.exit(1);
		} catch ( IOException ioException ){
		      System.err.println( "Error opening file." );
		   } 
		
		for(String item:NameList){
			makeEmployeeFile.format(item+ System.getProperty( "line.separator" ));//outputs defaults to file
			}
		if (makeEmployeeFile!=null){
			makeEmployeeFile.close();
		}
		
		for(String item:PINList){
			makePinsFile.format(item+ System.getProperty( "line.separator" ));//outputs defaults to file
			}
		if (makePinsFile!=null){
			makePinsFile.close();
		}
	}
	
	public void writePricesToFile() throws FileNotFoundException {
		try {
			makePricesFile = new Formatter("Prices.txt");
			//System.out.println("opening prices file");
			//System.out.println(PricesList);			
		} catch (FileNotFoundException NotFound) {
			//System.out.print("making new files");
		} catch (SecurityException SecNav) {
			System.err.println("Something is Horribly Wrong");
			System.exit(1);
		} catch ( IOException ioException ){
		      System.err.println( "Error opening file." );
		   } 
		
		for(Double	item:PricesList){
			makePricesFile.format(item+ System.getProperty( "line.separator" ));//outputs defaults to file
			}
		if (makePricesFile!=null){
			makePricesFile.close();
		}
		//System.out.println("wrote new prices to file");
		
	}
	
	private void initialize() {
		
		PINList=new ArrayList<String>();
		NameList=new ArrayList<String>();
		PricesList=new ArrayList<Double>();
		
		try {
			makeOrOpenPriceFiles();
			makeOrOpenEAndPFiles();
			read();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//login buttons
		btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		
		//home buttons
		btnEmployeeManagement = new JButton("<html>Employee<br />Management</html>");
		btnManagePrices = new JButton("<html>Manage<br />Prices</html>");
		btnPlaceOrder = new JButton("<html>Place<br />Order</html>");
		btnCancel = new JButton("Cancel");
		btnLogout = new JButton("Logout");
		
		//place order buttons
		btnPizza = new JButton("Pizza");
		btnSpecial = new JButton("Specialty Pizza");
		btnSlurm = new JButton("Slurm");
		btnCompleteOrder = new JButton("Complete Order");
		
		//manage employees buttons
		btnNewSubmit = new JButton("Submit New Employee");
		btnEditSubmit = new JButton("Submit Changes");
		btnRemoveSubmit = new JButton("Remove Employee");
		
		//build pizza buttons
		btnSubmitNumOfPizzas = new JButton("Add to order");
		btnCancelRegular = new JButton("Cancel Pizza");
		
		//build special pizza
		btnSubmitNumOfSpecialPizzas = new JButton("Add to order");
		btnCancelSpecial = new JButton("Cancel Pizza");
		
		//manage prices buttons
		btnSavePrices = new JButton("Save Prices");
		
		frame = new JFrame();
		borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		
		Center = new JPanel();
		East = new JPanel();
		West = new JPanel();
		North = new JPanel();

		
		North.setForeground(SystemColor.text);
		North.setBackground(SystemColor.textHighlight);
		frame.getContentPane().add(North, BorderLayout.NORTH);
		North.setLayout(new BorderLayout());
		
		JPanel NC=new JPanel();
		NC.setForeground(SystemColor.text);
		NC.setBackground(SystemColor.textHighlight);
		North.add(NC,BorderLayout.CENTER);
		
		JPanel NE=new JPanel();
		NE.setForeground(SystemColor.text);
		NE.setBackground(SystemColor.textHighlight);
		North.add(NE,BorderLayout.EAST);
		
		
		lblLogo = new JLabel();
		ImageIcon icon = new ImageIcon(getClass().getResource("/logo.png"));
		lblLogo.setIcon(icon);
		lblLogo.setHorizontalAlignment(SwingConstants.RIGHT);
		NC.add(lblLogo);

		lblTitle = new JLabel("Domino's Login");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(UIManager.getColor("EditorPane.inactiveBackground"));
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 26));
		NC.add(lblTitle);
		
		
		lblUser = new JLabel(CurrentUser);
		lblUser.setForeground(UIManager.getColor("EditorPane.inactiveBackground"));
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		NE.add(lblUser);
		
		
		ButtonHandler buttons = new ButtonHandler();
		btnLogin.addActionListener(buttons);
		
		btnEmployeeManagement.addActionListener(buttons);
		btnManagePrices.addActionListener(buttons);
		btnPlaceOrder.addActionListener(buttons);
		btnCancel.addActionListener(buttons);
		btnLogout.addActionListener(buttons);
		
		btnPizza.addActionListener(buttons);
		btnSpecial.addActionListener(buttons);
		btnSlurm.addActionListener(buttons);
		btnCompleteOrder.addActionListener(buttons);
		
		btnNewSubmit.addActionListener(buttons);
		btnEditSubmit.addActionListener(buttons);
		btnRemoveSubmit.addActionListener(buttons);
		
		btnSubmitNumOfPizzas.addActionListener(buttons);
		btnCancelRegular.addActionListener(buttons);
		
		btnSubmitNumOfSpecialPizzas.addActionListener(buttons);
		btnCancelSpecial.addActionListener(buttons);
		
		btnSavePrices.addActionListener(buttons);
		
		Login();
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public class ButtonHandler implements ActionListener{

		public void actionPerformed(ActionEvent ae) {
			// TODO Auto-generated method stub
			
			if(ae.getSource() == btnLogin){
				String PIN = txtLoginInput.getText();
				if(PINList.contains(PIN)){
					CurrentUser = NameList.get(PINList.indexOf(PIN));
					lblUser.setText(CurrentUser);
					Home();
				}else if(PIN.equals("0000")){
					CurrentUser = "ADMIN";
					lblUser.setText(CurrentUser);
					Home();
				}else{
					JOptionPane.showConfirmDialog(null, "Invalid PIN. Try again.",
							"Login Failed", JOptionPane.PLAIN_MESSAGE);
					txtLoginInput.setText("");
					Center.revalidate();  
				    Center.repaint();
				}
			}
			
			if(ae.getSource() == btnEmployeeManagement){
				ManageEmployees();
			}
			
			if(ae.getSource() == btnManagePrices){
				ManagePrices();
			}
			
			if(ae.getSource() == btnPlaceOrder){
				PizzaOrder = new ArrayList<Pizza>();
				numOfSlurms=0;
				numberOfPizzas=0;
				
				btnEmployeeManagement.setEnabled(false);
				btnManagePrices.setEnabled(false);
				btnPlaceOrder.setEnabled(false);
				btnCancel.setEnabled(true);
				btnCancel.setText("Cancel Order");
				
				btnEmployeeManagement.setForeground(Color.GRAY);
				btnManagePrices.setForeground(Color.GRAY);
				btnPlaceOrder.setForeground(Color.GRAY);
				btnCancel.setForeground(Color.BLACK);
				
				East.removeAll();
				frame.remove(East);
				West.removeAll();
				frame.remove(West);
				
				West = new JPanel();
				frame.getContentPane().add(West, BorderLayout.WEST);	
				West.setLayout(new GridLayout(0, 1, 0, 5));

				West.add(btnEmployeeManagement);
				West.add(btnManagePrices);
				West.add(btnPlaceOrder);
				West.add(btnCancel);
				West.add(btnLogout);
				PlaceOrder();
			}
			
			if(ae.getSource() == btnCancel){
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you wish to cancel?","Warning",dialogButton,JOptionPane.PLAIN_MESSAGE);
				if(dialogResult == JOptionPane.YES_OPTION){
					PizzaOrder=new ArrayList<Pizza>();
				Home();
				}
			}
			
			if(ae.getSource() == btnLogout){
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you wish to Logout?","Warning",dialogButton,JOptionPane.PLAIN_MESSAGE);
				if(dialogResult == JOptionPane.YES_OPTION){
				
				West.removeAll();
				East.removeAll();
				frame.remove(West);
				frame.remove(East);
				frame.remove(Center);
				lblUser.setText("");
				Login();}
			}
			
			if(ae.getSource() == btnPizza){
				BuildPizza();
			}
			
			if(ae.getSource() == btnSpecial){
				SpecialPizza();
			}
			
			if(ae.getSource() == btnSlurm){
			    String input = JOptionPane.showInputDialog(null, "How many Slurms would you like to add?", "Slurm", JOptionPane.PLAIN_MESSAGE);
			    if(input == null || (input != null && ("".equals(input)))){
			    	
			    }else{
			    	try{
			    	int addedSlurms=0;
			    	
			    	addedSlurms = numOfSlurms + Integer.parseInt(input);
			    	if(addedSlurms<101 && addedSlurms>numOfSlurms){
			    		numOfSlurms=addedSlurms;
			    		PlaceOrder();
			    	}else{
			    		JOptionPane.showConfirmDialog(null, "The number of Slurms must be between 1 and 100.",
								"Warning quanity not Saved", JOptionPane.PLAIN_MESSAGE);
			    	}
			    	
			    	}catch(Exception e){
			    		JOptionPane.showConfirmDialog(null, "The number of Slurms must be between 1 and 100.",
								"Warning quanity not Saved", JOptionPane.PLAIN_MESSAGE);
			    	}
			    	}
			}
			
			if(ae.getSource() == btnCompleteOrder ){
				if(PizzaOrder.size()>0||numOfSlurms>0){
				orderNumber++;
				if(orderNumber==10001){
					orderNumber=0;
				}
				PricesList.set(9, orderNumber);
				try {
					writePricesToFile();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Home();
				}
			}
			
			if(ae.getSource() == btnNewSubmit){
					if(txtNewPin.getText().length()!=4 || txtNewName.getText().equals("")){
						JOptionPane.showConfirmDialog(null, "Valid PIN's are 4 digit numbers and names are non-empty strings.",
								"Warning New Employee not Saved", JOptionPane.PLAIN_MESSAGE);
					}else{
						try{
							int pin = Integer.parseInt(txtNewPin.getText());
							if(NameList.contains(txtNewName.getText())==false && PINList.contains(txtNewPin.getText())==false && 
									txtNewName.getText().equals("ADMIN")==false && txtNewPin.getText().equals("0000")==false){
								NameList.add(txtNewName.getText());
								PINList.add(txtNewPin.getText());
								write();
								Home();
							}else{
							JOptionPane.showConfirmDialog(null, "Either the name or PIN entered are already taken.",
									"Warning New Employee not Saved", JOptionPane.PLAIN_MESSAGE);}
						}catch(Exception e){
							JOptionPane.showConfirmDialog(null, "Valid PIN's are 4 digit numbers.",
									"Warning New Employee not Saved", JOptionPane.PLAIN_MESSAGE);}
					}
					
			}
			
			if(ae.getSource() == btnEditSubmit){
				if(comboBoxEditName.getSelectedItem() != "Select Name to Edit"){
					if(txtEditPin.getText().length()!=4 || txtEditName.getText().equals("")){
						JOptionPane.showConfirmDialog(null, "Valid PIN's are 4 digit numbers and names are non-empty strings.",
								"Warning Edit not Saved", JOptionPane.PLAIN_MESSAGE);
					}else{
						try{
							if((NameList.contains(txtEditName.getText())==false || txtEditName.getText().equals(comboBoxEditName.getSelectedItem())) &&
									(PINList.contains(txtEditPin.getText())==false||
									txtEditPin.getText().equals(PINList.get(NameList.indexOf(comboBoxEditName.getSelectedItem())))) &&
									txtEditName.getText().equals("ADMIN")==false && txtEditPin.getText().equals("0000")==false){
								int pin = Integer.parseInt(txtEditPin.getText());
								int num = NameList.indexOf(comboBoxEditName.getSelectedItem());
								NameList.set(num,txtEditName.getText());
								PINList.set(num, txtEditPin.getText());
								if(comboBoxEditName.getSelectedItem().equals(CurrentUser)){
									CurrentUser=txtEditName.getText();
									lblUser.setText(CurrentUser);}
								write();
								Home();
							}else{
								JOptionPane.showConfirmDialog(null, "Either the name or PIN entered are already taken.",
										"Warning New Employee not Saved", JOptionPane.PLAIN_MESSAGE);}
						}catch(Exception e){
							JOptionPane.showConfirmDialog(null, "Valid PIN's are 4 digit numbers.",
									"Warning Edit not Saved", JOptionPane.PLAIN_MESSAGE);}
					}
				}
			}
			
			if(ae.getSource() == btnRemoveSubmit){
				if(comboBoxRemoveName.getSelectedItem().equals("Select Name to Remove")==false){
					int num = NameList.indexOf(comboBoxRemoveName.getSelectedItem());
					NameList.remove(num);
					PINList.remove(num);
					write();
					Home();
				}
			}
			
			if(ae.getSource()==btnSubmitNumOfPizzas){
				if(txtNumOfPizzas.getText().trim().equals("")==false){
					
					String Size;
					int Number;
					ArrayList<String>toppings = new ArrayList<String>();
					
					if(RBSmall.isSelected()){ Size="small";
					}else if(RBMedium.isSelected()){ Size="medium";
					}else{ Size="large";}
					
					if(chckbxPepperoni.isSelected()){
						toppings.add("Pepperoni");}
					
					if(chckbxOnions.isSelected()){
						toppings.add("Onions");}
					
					if(chckbxBacon.isSelected()){
						toppings.add("Bacon");}
					
					if(chckbxBlackOlives.isSelected()){
						toppings.add("BlackOlives");}
					
					if(chckbxHam.isSelected()){
						toppings.add("Ham");}
					
					if(chckbxExtraCheese.isSelected()){
						toppings.add("ExtraCheese");}
					
					if(chckbxMushrooms.isSelected()){
						toppings.add("Mushrooms");}
					
					if(chckbxGreenPeppers.isSelected()){
						toppings.add("GreenPeppers");}
					
					if(chckbxChicken.isSelected()){
						toppings.add("Chicken");}
					
					if(chckbxPineapple.isSelected()){
						toppings.add("Pineapple");}
					
					if(chckbxSausage.isSelected()){
						toppings.add("Sausage");}
					try{
					Number=Integer.parseInt(txtNumOfPizzas.getText());
					if(Number>100||Number<=0){
						JOptionPane.showConfirmDialog(null, "The number of pizzas must be between 0 and 100.",
								"Warning prices not saved", JOptionPane.PLAIN_MESSAGE);
					}else{
					if(numberOfPizzas+Number<101){
					numberOfPizzas+=Number;
					
					Pizza p = new Pizza(Size, "regular", toppings, Number);
					p.setPrice(CalculatePrice(p));
					PizzaOrder.add(p);
					PlaceOrder();
					}else{
						JOptionPane.showConfirmDialog(null, "The total number of pizzas must be between 0 and 100.\n Currently you have "+numberOfPizzas+".",
								"Warning pizza not saved", JOptionPane.PLAIN_MESSAGE);
					}}
					}catch(Exception e){
						JOptionPane.showConfirmDialog(null, "The number of pizzas must be between 0 and 100.",
								"Warning pizza not saved", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
			
			if(ae.getSource()==btnCancelRegular){
				PlaceOrder();
			}
			
			if(ae.getSource()==btnSubmitNumOfSpecialPizzas){
				if(txtNumOfSpecialPizzas.getText().trim().equals("")==false){
					
					String Size;
					String Type;
					int Number=0;
				
					if(SpecialRBSmall.isSelected()){ Size="small";
					}else if(SpecialRBMedium.isSelected()){ Size="medium";
					}else{ Size="large";}
				
					if(rdbtnVeggie.isSelected()){Type="veggie";
					}else{Type="meatlovers";}
					
					try{
					Number=Integer.parseInt(txtNumOfSpecialPizzas.getText());
					
					if(Number>100||Number<=0){
						JOptionPane.showConfirmDialog(null, "The number of pizzas must be between 0 and 100.",
								"Warning prices not saved", JOptionPane.PLAIN_MESSAGE);
					}else{
					
					if(numberOfPizzas+Number<101){
							numberOfPizzas+=Number;
					
					Pizza sp = new Pizza(Size, Type, null, Number);
					sp.setPrice(CalculatePrice(sp));
					PizzaOrder.add(sp);
					PlaceOrder();
					}else{
						JOptionPane.showConfirmDialog(null, "The total number of pizzas must be between 0 and 100.\n Currently you have "+numberOfPizzas+".",
								"Warning pizza not saved", JOptionPane.PLAIN_MESSAGE);
					}
					}
					}catch(Exception e){
						JOptionPane.showConfirmDialog(null, "The number of pizzas must be between 0 and 100.",
								"Warning prices not saved", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
			
			if(ae.getSource()==btnCancelSpecial){
				PlaceOrder();
			}
			
			if(ae.getSource()==btnSavePrices){
				try{
				double SmPizzaPrice1 = Double.parseDouble(txtSmPizzaPrice.getText());
				double MPizzaPrice1 = Double.parseDouble(txtMPizzaPrice.getText());
				double LPizzaPrice1 = Double.parseDouble(txtLPizzaPrice.getText());
				double ToppingPrice1 = Double.parseDouble(txtToppingPrice.getText());
				double SlurmPrice1 = Double.parseDouble(txtSlurmPrice.getText());
				double SmSpecialPrice1 = Double.parseDouble(txtSmSpecialPrice.getText());
				double MSpecialPrice1 = Double.parseDouble(txtMSpecialPrice.getText());
				double LSpecialPrice1 = Double.parseDouble(txtLSpecialPrice.getText());
				double Tax1 = Double.parseDouble(txtTax.getText())/100;
				
				
				 String [] p1 = txtSmPizzaPrice.getText().split("\\.");
				 String [] p2 = txtMPizzaPrice.getText().split("\\.");
				 String [] p3 = txtLPizzaPrice.getText().split("\\.");
				 String [] p4 = txtToppingPrice.getText().split("\\.");
				 String [] p5 = txtSlurmPrice.getText().split("\\.");
				 String [] p6 = txtSmSpecialPrice.getText().split("\\.");
				 String [] p7 = txtMSpecialPrice.getText().split("\\.");
				 String [] p8 = txtLSpecialPrice.getText().split("\\.");
				 String [] p9 = txtTax.getText().split("\\.");
				 
				 boolean validDigits=true;
				 
				 if(p1[1].length()>2 || p2[1].length()>2 || p3[1].length()>2||
						 p4[1].length()>2 || p5[1].length()>2 || p6[1].length()>2||
						 p7[1].length()>2 || p8[1].length()>2){
					 		validDigits=false;}
				
				if(SmPizzaPrice1>100||SmPizzaPrice1<0||MPizzaPrice1>100||MPizzaPrice1<0||LPizzaPrice1>100||LPizzaPrice1<0||
						ToppingPrice1>100||ToppingPrice1<0||SlurmPrice1<0||SlurmPrice1>100||SmSpecialPrice1>100||SmSpecialPrice1<0||
						MSpecialPrice1>100||MSpecialPrice1<0||LSpecialPrice1>100||LSpecialPrice1<0||Tax1>.3||Tax1<0 || validDigits==false){
					
					JOptionPane.showConfirmDialog(null, "Prices were not saved. At least one entry is invalid. Prices should be between 0 and 100 dollars with two significant digits past the decimal.\n Tax should be between 0 and 30 percent.",
							"Warning", JOptionPane.PLAIN_MESSAGE);
					
				}else{
					SmPizzaPrice = Double.parseDouble(txtSmPizzaPrice.getText());
					MPizzaPrice = Double.parseDouble(txtMPizzaPrice.getText());
					LPizzaPrice = Double.parseDouble(txtLPizzaPrice.getText());
					ToppingPrice = Double.parseDouble(txtToppingPrice.getText());
					SlurmPrice = Double.parseDouble(txtSlurmPrice.getText());
					SmSpecialPrice = Double.parseDouble(txtSmSpecialPrice.getText());
					MSpecialPrice = Double.parseDouble(txtMSpecialPrice.getText());
					LSpecialPrice = Double.parseDouble(txtLSpecialPrice.getText());
					Tax = Double.parseDouble(txtTax.getText())/100;
					
					PricesList = new ArrayList<Double>();
					PricesList.add(SmPizzaPrice);
					PricesList.add(MPizzaPrice);
					PricesList.add(LPizzaPrice);
					PricesList.add(ToppingPrice);
					PricesList.add(SlurmPrice);
					PricesList.add(SmSpecialPrice);
					PricesList.add(MSpecialPrice);
					PricesList.add(LSpecialPrice);
					PricesList.add(Tax);
					PricesList.add(orderNumber);
					writePricesToFile();
					
					Home();}
				}catch(Exception e){
					JOptionPane.showConfirmDialog(null, "Atleast one entry is invalid. Prices should be between 0 and 100 dollars with two significant digits past the decimal.\n Tax should be between 0 and 30 percent.",
							"Warning prices not saved", JOptionPane.PLAIN_MESSAGE);
					}
				
			}
			
			}
			
			
		}
	
	public class JTextFieldLimit extends PlainDocument {
	    private int limit;

	    public JTextFieldLimit(int limit) {
	        //super();
	        this.limit = limit;
	    }

	        public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
	            if (str == null) return;

	            if ((getLength() + str.length()) <= limit) {
	                super.insertString(offset, str, attr);
	            }
	        }       

	    }

	}


