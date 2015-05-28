import javax.swing.JFrame;


public class MyJFrame extends JFrame {
	
	public void setDefaultCloseOperation(){
		System.out.println("hey I am closing");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/*
	public void EXIT_ON_CLOSE(){
		System.out.println("Hey I am closing");
		super.();
	}*/
}
