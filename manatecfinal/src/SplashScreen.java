
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class SplashScreen {

	public static void main(String[] args) {
		JWindow window = new JWindow();
		window.getContentPane().add(new JLabel("",new ImageIcon(SplashScreen.class.getResource("/resources/Load.jpg")),SwingConstants.CENTER));
		window.setBounds(100, 100, 800, 600);
		window.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		window.dispose();
		
		 MainScreen localMainScreen = new MainScreen();
         localMainScreen.setVisible(true);
         localMainScreen.setDefaultCloseOperation(3);
         localMainScreen.setResizable(false);
         localMainScreen.initSelection();
	}

}