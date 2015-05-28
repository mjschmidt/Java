import java.awt.event.WindowListener;

import javax.swing.JFrame;


public class WindowEventHandler extends JFrame implements WindowListener {

	public WindowEventHandler() {
        super();
    }
	
	public WindowEventHandler(String name) {
        super(name);
    }
	
	  public void windowOpened(java.awt.event.WindowEvent arg0)
	  {
		  System.out.println("windowOpened");
		  
	  }
	  
	  public void windowClosing(java.awt.event.WindowEvent arg0)
	  {
		  System.out.println("windowClosing");
		  
	  }
	  
	  // When the window is actually closed
	  public void windowClosed(java.awt.event.WindowEvent arg0)
	  {
		  System.out.println("windowClosed");
		  
	  }
	  
	  public void windowIconified(java.awt.event.WindowEvent arg0)
	  {
		  System.out.println("windowIconified");
	  }
	  
	  public void windowDeiconified(java.awt.event.WindowEvent arg0)
	  {
		  System.out.println("windowDeiconified");
	  }
	  
	  public void windowActivated(java.awt.event.WindowEvent arg0)
	  {
		  System.out.println("windowActivated");
	  }
	  
	  public void windowDeactivated(java.awt.event.WindowEvent arg0)
	  {
		  System.out.println("windowDeactivated");
	  }
}
