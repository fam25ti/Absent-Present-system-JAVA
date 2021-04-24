import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Start_Seminar extends BaseOfPages{
	private JTextField textfield_title;
	private JTextField textfield_date;
	private JTextField textfield_start_time;
	private JTextField textfield_finish_time;
	private JTextField textfield_capacity;
	public Start_Seminar(){
		super();
		JLabel label_TitleOfSeminar = new JLabel("Title of seminar :");
		label_TitleOfSeminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_TitleOfSeminar.setBounds(123, 82, 106, 31);
		image_label.add(label_TitleOfSeminar);
		
		textfield_title = new JTextField("");
		textfield_title.setBounds(270, 86, 113, 25);
		image_label.add(textfield_title);
		
		JLabel capacityOfSeminar = new JLabel("Capacity of seminar :");
		capacityOfSeminar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		capacityOfSeminar.setBounds(123, 147, 126, 20);
		image_label.add(capacityOfSeminar);
		
		textfield_capacity = new JTextField();
		textfield_capacity.setBounds(270, 146, 113, 25);
		panel.add(textfield_capacity);
		
		JLabel label_StartTime = new JLabel("Seminar's start time :");
		label_StartTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_StartTime.setBounds(123, 181, 126, 14);
		image_label.add(label_StartTime);
		
		textfield_start_time = new JTextField();
		textfield_start_time.setText("hour:minute:second");
		textfield_start_time.setBounds(270, 177, 113, 25);
		image_label.add(textfield_start_time);
		
	
		
		
		
		JLabel label_seminar_finishTime = new JLabel("Seminar's finish time :");
		label_seminar_finishTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_seminar_finishTime.setBounds(123, 206, 137, 31);
		image_label.add(label_seminar_finishTime);
		
		textfield_finish_time = new JTextField();
		textfield_finish_time.setText("hour:minute:second");
		textfield_finish_time.setBounds(270, 210, 113, 25);
		image_label.add(textfield_finish_time);
		
		
		
		JLabel label_seminar_Date = new JLabel("Seminar's date :");
		label_seminar_Date.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_seminar_Date.setBounds(123, 119, 126, 20);
		image_label.add(label_seminar_Date);
		
		textfield_date = new JTextField();
		textfield_date.setText("year/month/day");
		textfield_date.setBounds(270, 115, 113, 25);
		image_label.add(textfield_date);
		
		
		
		JButton submit_button = new JButton("Submit");
		submit_button.setFont(new Font("Tahoma", Font.ITALIC, 14));
		submit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int hour_s=0;
				int minute_s=0;
				int second_s=0;
				int year_=0;
				int month_=0;
				int day_=0;
				int hour_f=0;
				int minute_f=0;
				int second_f=0;
				int capacity_=0;
				int check=0;
				int checkNotRepeatedTitle=0;
				try {
					capacity_=Integer.parseInt(textfield_capacity.getText());
				}
				catch(Exception ex) {
					check=1;
					JOptionPane.showMessageDialog(frame, "Capacity should be an integer");
				}
				String split_time_start[]=textfield_start_time.getText().split(":");

				try {
					hour_s=Integer.parseInt(split_time_start[0]);
					minute_s=Integer.parseInt(split_time_start[1]);
					second_s=Integer.parseInt(split_time_start[2]);
				}
				catch(Exception ex) {
					check=1;
					JOptionPane.showMessageDialog(frame,"You should enter start time in format integer:integer:integer");
				}
				
				String split_time_finish[]=textfield_finish_time.getText().split(":");

				try {
					hour_f=Integer.parseInt(split_time_finish[0]);
					minute_f=Integer.parseInt(split_time_finish[1]);
					second_f=Integer.parseInt(split_time_finish[2]);
				}
				catch(Exception ex) {
					
					check=1;
					JOptionPane.showMessageDialog(frame,"You should enter finish time in format integer:integer:integer");
				} 
				
				String split_date[]=textfield_date.getText().split("/");

				try {
					year_=Integer.parseInt(split_date[0]);
					month_=Integer.parseInt(split_date[1]);
					day_=Integer.parseInt(split_date[2]);
				}
				catch(Exception ex) {
					check=1;
					JOptionPane.showMessageDialog(frame,"You should enter date in format integer/integer/integer");
				}
				if(check==0) {
					if(!textfield_title.getText().equals("")) {
					try {
						FileReader reader=new  FileReader("nameOfseminars.txt");
						Scanner sc=new Scanner(reader);
						while(sc.hasNext()) {
							String name_of_before_seminars=sc.nextLine();
							if(name_of_before_seminars.equals(textfield_title.getText())) {
								checkNotRepeatedTitle=1;
								JOptionPane.showMessageDialog(frame, "There is a seminar with this title you should use a different title");
								break;
								
							}
						}
					}
					catch(Exception ex) {
						
					}
					if(checkNotRepeatedTitle==0) {
				ArrayList<Student> array=new ArrayList<Student>();
				Seminar seminar=new Seminar(array,textfield_title.getText(), hour_s, minute_s, second_s, hour_f, minute_f, second_f, year_, month_, day_, capacity_);
				String url=textfield_title.getText()+".txt";
				try {
					
					BufferedWriter b1=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("nameOfseminars.txt",true)));
					b1.write(seminar.getTitle());
					b1.newLine();
					b1.close();
					BufferedWriter buff=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("All.txt",true)));
					buff.write(url);
					buff.newLine();
					buff.close();
					BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(url, true), "UTF-8"));
					bfw.write(textfield_title.getText());
					bfw.newLine();
					bfw.write(textfield_capacity.getText());
					bfw.newLine();
					bfw.write(textfield_date.getText());
					bfw.newLine();
					bfw.write(textfield_start_time.getText());
					bfw.newLine();
					bfw.write(textfield_finish_time.getText());
					bfw.newLine();
					bfw.close();
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage());
				}
				//seminars.add(seminar);
				frame.dispose();
				StudentsInfoAdder adder=new StudentsInfoAdder(seminar,url);
				}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Title field could not be empty");
				}
			}
				else {
					check=0;
				}
				}
			
		});
		submit_button.setBounds(181, 267, 160, 23);
		JButton clr_title = new JButton("clear");
		clr_title.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield_title.setText("");
			}
		});
		clr_title.setBounds(393, 87, 89, 23);
		image_label.add(clr_title);
		
		JButton clr_date = new JButton("clear");
		clr_date.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfield_date.setText("");
			}
		});
		clr_date.setBounds(393, 116, 89, 23);
		image_label.add(clr_date);
		
		JButton clr_capacity = new JButton("clear");
		clr_capacity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textfield_capacity.setText("");
				
			}
		});
		clr_capacity.setBounds(393, 148, 89, 23);
		image_label.add(clr_capacity);
		
		JButton clr_stime = new JButton("clear");
		clr_stime.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textfield_start_time.setText("");
				
			}
		});
		clr_stime.setBounds(393, 178, 89, 23);
		image_label.add(clr_stime);
		
		JButton clr_ftime = new JButton("clear");
		clr_ftime.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textfield_finish_time.setText("");
				
			}
		});
		clr_ftime.setBounds(393, 211, 89, 23);
		image_label.add(clr_ftime);
		
		JButton clr_all = new JButton("Clear all");
		clr_all.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textfield_title.setText("");
				textfield_capacity.setText("");
				textfield_date.setText("");
				textfield_finish_time.setText("");
				textfield_start_time.setText("");
				
			}
		});
		clr_all.setBounds(393, 245, 89, 23);
		JButton back_btn = new JButton("Back");
		back_btn.setFont(new Font("Tahoma", Font.ITALIC, 14));
		back_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Page2 p=new Page2();			}
		});
		back_btn.setBounds(181, 303, 160, 25);
		image_label.add(back_btn);
		image_label.add(clr_all);
		image_label.add(submit_button);
		frame.setVisible(true);
		
		
		
		
	}
}
