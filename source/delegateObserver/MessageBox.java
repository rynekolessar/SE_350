package delegateObserver;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MessageBox extends JFrame{
		/** Constructor
		 ** @param title text for Window's title bar
		 **/
		public MessageBox (String title, String message){
			super(title);
			//setDefaultCloseOperation(EXIT_ON_CLOSE); //replaces need to create WindowAdapter object
			JLabel label = new JLabel(message, JLabel.CENTER);
			this.getContentPane().add(label, BorderLayout.CENTER);
			this.setSize(300,100);
			this.show();
			this.addWindowListener( new WindowAdapter (){
				public void windowClosing ( WindowEvent event){
					hide();
					dispose();
				}
			});
			
	   }
}
