import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class BaseOfPages {
	protected JFrame frame;
	protected Container contentPane ;
	protected JPanel panel;
	protected JLabel image_label;
	protected ImageIcon icon;
	protected JLabel clock_lbl;
	public BaseOfPages() {
		frame=new JFrame("Absent-Present system");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = frame.getContentPane();
		frame.setBounds(0, 0, 550, 550);
		contentPane.setLayout(new BorderLayout(0,0));
		panel=new JPanel();
		contentPane.add(panel,BorderLayout.CENTER);
		panel.setLayout(null);	
		image_label=new JLabel();
		image_label.setBounds(0, 0, 550, 550);
		image_label.setLayout(null);
		Image background=null;
		try {
			background=ImageIO.read(new File("cloud_background.jpg"));
		}
		catch(IOException io) {
			io.printStackTrace();
		}
		Image scaled=background.getScaledInstance(550, 550, 0);
		icon=new ImageIcon(scaled);
		image_label.setIcon(icon);
		clock_lbl=new JLabel();
		clock_lbl.setBounds(10, 465, 293, 14);
		JMenuBar menuBar=new JMenuBar();
		JMenu menu=new JMenu("File");
		frame.setJMenuBar(menuBar);
		menuBar.add(menu);
		JMenuItem item_clock=new JMenuItem("Add date & time to window");
		menu.add(item_clock);
		item_clock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clock();
			}
		});
		JMenuItem item_exit=new JMenuItem("Exit");
		item_exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(item_exit);
		
		panel.add(image_label);
		
	}
	public void clock() {
		image_label.add(clock_lbl);
		Thread clock=new Thread() {
			public void run() {
				try {
					while(true) {
					DateTime dt=new DateTime();
					int day=dt.gettingDay();
					int month=dt.gettingMonth();
					int year=dt.gettingYear();
					int hour=dt.gettingHour();
					int minute=dt.gettingMinute();
					int second=dt.gettingSecond();
					clock_lbl.setText("Time "+hour+":"+minute+":"+second+" Date  "+year+"/"+month+"/"+day);
					sleep(1000);
					}
				
			}
				catch(Exception ex) {
				ex.printStackTrace();
			}
			}
			};
			clock.start();
	}

}
