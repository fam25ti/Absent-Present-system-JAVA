import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Page1 extends BaseOfPages{
	public Page1() {
		super();
	JLabel welcome=new JLabel("WELCOME TO APPLICATION");
	welcome.setBounds(170, 29, 250, 14);
	super.image_label.add(welcome);
	JButton start = new JButton("START");
	start.setBounds(205, 100, 89, 23);
	image_label.add(start);
	start.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			LogIn log=new LogIn();
		}});
	JButton exit=new JButton("EXIT");
	exit.setBounds(205, 150, 89, 23);
	image_label.add(exit);
	exit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	});
	frame.setVisible(true);
	JOptionPane.showMessageDialog(frame, "Absent_present checking system\n" + "version 1"+"\nWriter *M.T*",
            "About App", 
            JOptionPane.INFORMATION_MESSAGE);
	}
}
