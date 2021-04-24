import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StudentsInfoAdder extends BaseOfPages{
	private String addressOfFile;
	private JTextField textField_Age;
	private JTextField textField_Name;
	private JTextField textField_Family;
	private JTextField textField_Grade;
	private JTextField textField_Id;
	private JTextField textField_Phone;
	private Seminar seminar;
	private int counterOfParticipants=0;
	public StudentsInfoAdder(Seminar s,String url){
		super();

		seminar=s;
		addressOfFile=url;
		JLabel label_Name = new JLabel("Name :");
		label_Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_Name.setBounds(21, 11, 58, 24);
		image_label.add(label_Name);
		
		textField_Name = new JTextField("");
		textField_Name.setBounds(74, 15, 107, 20);
		image_label.add(textField_Name);
		
		JLabel label_Family = new JLabel("Family :");
		label_Family.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_Family.setBounds(249, 15, 58, 17);
		image_label.add(label_Family);
		
		textField_Family = new JTextField("");
		textField_Family.setBounds(317, 15, 114, 20);
		image_label.add(textField_Family);
		
		JLabel label_Age = new JLabel("Age :");
		label_Age.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_Age.setBounds(21, 79, 48, 24);
		image_label.add(label_Age);
		
		JLabel label_Grade = new JLabel("Grade :");
		label_Grade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_Grade.setBounds(249, 84, 48, 14);
		image_label.add(label_Grade);
		
		textField_Age = new JTextField();
		textField_Age.setBounds(74, 83, 107, 20);
		image_label.add(textField_Age);
		
		textField_Grade = new JTextField();
		textField_Grade.setBounds(317, 83, 114, 20);
		image_label.add(textField_Grade);
		
		JLabel label_Id = new JLabel("ID :");
		label_Id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_Id.setBounds(21, 150, 48, 14);
		image_label.add(label_Id);
		
		textField_Id = new JTextField();
		textField_Id.setBounds(74, 149, 107, 20);
		image_label.add(textField_Id);
		
		JLabel label_Phone = new JLabel("Phone :");
		label_Phone.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_Phone.setBounds(249, 150, 58, 14);
		image_label.add(label_Phone);
		
		textField_Phone = new JTextField();
		textField_Phone.setBounds(317, 149, 114, 20);
		image_label.add(textField_Phone);
		
		JLabel free_cap_label = new JLabel("Free capacity:"+(seminar.getCapacity()+""));
		free_cap_label.setBounds(2, 236, 120, 14);
		image_label.add(free_cap_label);
	
		JButton save_button = new JButton("Save information");
		save_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (counterOfParticipants==seminar.getCapacity()) {
					JOptionPane.showMessageDialog(frame,"Capacity is full!!!");
				}
				else {
					String name=textField_Name.getText();
					String family=textField_Family.getText();
					DateTime time=new DateTime();
					int hour=time.gettingHour();
					int minute=time.gettingMinute();
					int second=time.gettingSecond();
					int age=0;
					Long phone=0l;
					Long id=0l;
					int grade=0;
					int checkCorrectFormat=0;
					try {
						age=Integer.parseInt(textField_Age.getText());
					}
					catch(Exception ex) {
						checkCorrectFormat=1;
						JOptionPane.showMessageDialog(frame, "Age should be a number");
					}
					try {
						phone=Long.parseLong(textField_Phone.getText());
					}
					catch(Exception ex) {
						checkCorrectFormat=1;
						JOptionPane.showMessageDialog(frame, "Phone should be a number");

					}
					try {
						id=Long.parseLong(textField_Id.getText());}
					catch(Exception ex) {
						checkCorrectFormat=1;
						JOptionPane.showMessageDialog(frame, "ID should be a number");

					}
					try {
						grade=Integer.parseInt(textField_Grade.getText());
					}
					catch(Exception ex){
						checkCorrectFormat=1;
						JOptionPane.showMessageDialog(frame, "Grade should be a number");

					}
					if(checkCorrectFormat==0) {
						int repeat=0;
						for(Student st:seminar.getStudents()) {
							if(st.getName().equals(name)) {
								if(st.getFamily().equals(family)) {
									if(st.getId().equals(id)) {
										repeat=1;
										JOptionPane.showMessageDialog(frame, "This participant with this name and family and id has entered before");
									}
								}
							}
						}
						if(repeat==0) {
							if(!(textField_Name.getText().equals(""))&&!(textField_Family.getText().equals(""))) {
						Student student=new Student(name, family, age, grade, id, phone, hour, minute, second);
						s.getStudents().add(student);
						try {

							BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(addressOfFile, true), "UTF-8"));
							bfw.write(name+"\n"+family+"\n"+age+"\n"+phone+"\n"+grade+"\n"+id+"\n"+hour+":"+minute+":"+second);
							counterOfParticipants++;
							bfw.newLine();
							free_cap_label.setText("Free capacity:"+((seminar.getCapacity()-counterOfParticipants)+""));
							bfw.close();
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(frame, ex.getMessage());

					}
						textField_Age.setText("");
						textField_Family.setText("");
						textField_Grade.setText("");
						textField_Name.setText("");
						textField_Id.setText("");
						textField_Phone.setText("");
						}
							else {
								JOptionPane.showMessageDialog(frame, "Name and family field should not be empty");
							}	
						
						}
						else {
							repeat=0;
						}
						}
					else {
						checkCorrectFormat=0;
					}
				}
				
				}
			
			});
		save_button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		save_button.setBounds(169, 204, 153, 32);
		image_label.add(save_button);
		
		
		JButton search_student = new JButton("Search student");
		search_student.setFont(new Font("Tahoma", Font.PLAIN, 12));
		search_student.setBounds(169, 236, 153, 32);
		image_label.add(search_student);
		search_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=JOptionPane.showInputDialog("Enter name of student:");
				String family=JOptionPane.showInputDialog("Enter family of student:");
				Long idNum=0l;
				int found=0;
				try {
					idNum=Long.parseLong(JOptionPane.showInputDialog("Enter ID of student"));
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(frame, "ID should be a number");
				}
				for(Student student:seminar.getStudents()) {
					if(student.getName().toLowerCase().trim().equals(name.toLowerCase().trim())) {
								if(student.getFamily().toLowerCase().trim().equals(family.toLowerCase().trim())) {
									if(student.getId().equals(idNum)) {
										
										JOptionPane.showMessageDialog(frame, "Student found!!");
										found=1;
										OutPut2 op=new OutPut2(student);
										break;
									}
									
								}
							}
				}
				if (found==0) {
						JOptionPane.showMessageDialog(frame, "Student not found!!");

				}
			}
		});
		
		
		JButton list_button = new JButton("List all participant");
		list_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OutPut2 out=new OutPut2(seminar.getStudents());
			}
		});
		list_button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		list_button.setBounds(169, 268, 153, 32);
		image_label.add(list_button);
		
		JLabel total_cap_label = new JLabel("Total capacity:"+seminar.getCapacity());
		total_cap_label.setBounds(2, 214, 120, 14);
		image_label.add(total_cap_label);
		
		JButton end_button = new JButton("End seminar and back to main page");
		end_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Page2 page2=new Page2();
			}
		});
		end_button.setBounds(115, 334, 272, 23);
		image_label.add(end_button);
		
		JButton clear1 = new JButton("clear");
		clear1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		clear1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		clear1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_Name.setText("");
			}
		});
		clear1.setBounds(181, 15, 58, 20);
		image_label.add(clear1);
		
		JButton clear2 = new JButton("clear");
		clear2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		clear2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_Family.setText("");
			}
		});
		clear2.setBounds(431, 15, 58, 20);
		image_label.add(clear2);
		
		JButton clear3 = new JButton("clear");
		clear3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		clear3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_Age.setText("");
			}
		});
		clear3.setBounds(181, 82, 58, 20);
		image_label.add(clear3);
		
		JButton clear4 = new JButton("clear");
		clear4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		clear4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_Grade.setText("");
			}
		});
		clear4.setBounds(431, 82, 58, 20);
		image_label.add(clear4);
		
		JButton clear5 = new JButton("clear");
		clear5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		clear5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_Id.setText("");
			}
		});
		clear5.setBounds(181, 148, 58, 20);
		image_label.add(clear5);
		
		JButton clear6 = new JButton("clear");
		clear6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		clear6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_Phone.setText("");
			}
		});
		clear6.setBounds(431, 149, 58, 20);
		image_label.add(clear6);
		
		
		
		JButton clear_all = new JButton("Clear all");
		clear_all.setBounds(400, 180, 89, 23);
		clear_all.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_Age.setText("");
				textField_Family.setText("");
				textField_Grade.setText("");
				textField_Name.setText("");
				textField_Id.setText("");
				textField_Phone.setText("");			}
		});
		image_label.add(clear_all);
		
		frame.setVisible(true);
		JOptionPane.showMessageDialog(frame, "Please enter student's information" );


	}

}
