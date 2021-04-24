import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class SearchStudentInSeminar extends BaseOfPages{

	public SearchStudentInSeminar(Seminar seminar) {
		super();
		JRadioButton name_radio = new JRadioButton("Search Name&Family");
		name_radio.setBounds(37, 72, 150, 23);
		image_label.add(name_radio);
		
		
		
		JRadioButton id_radio = new JRadioButton("Search by ID");
		
		id_radio.setBounds(206, 72, 109, 23);
		image_label.add(id_radio);
		
		JRadioButton grade_radio = new JRadioButton("Search by grade");
		
		grade_radio.setBounds(360, 72, 130, 23);
		image_label.add(grade_radio);
		
	JRadioButton phone_radio = new JRadioButton("Search by phone");

		phone_radio.setBounds(37, 131, 130, 23);
		image_label.add(phone_radio);
		
		JRadioButton  time_radio= new JRadioButton("Search by entrane time");
	
		time_radio.setBounds(206, 131, 165, 23);
		image_label.add(time_radio);

		ButtonGroup group=new ButtonGroup();
		group.add(name_radio);
		group.add(phone_radio);
		group.add(grade_radio);
		group.add(time_radio);
		group.add(id_radio);
		JButton sub_confirm = new JButton("Confirm");
		sub_confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(name_radio.isSelected()) {
					int found=0;
					String name=JOptionPane.showInputDialog("Please enter name of student:");
					String family=JOptionPane.showInputDialog("Please enter family of student:");
					ArrayList<Student> st=new ArrayList<Student>();
					for(Student stu:seminar.getStudents()) {
						if(stu.getName().toLowerCase().trim().equals(name.toLowerCase().trim())) {
							if(stu.getFamily().toLowerCase().trim().equals(family.toLowerCase().trim())) {
								st.add(stu);
								found=1;
							}
						}	
					}
					if(found==0) {
						JOptionPane.showMessageDialog(frame, "Student not found!!!");
					}
					else {
						JOptionPane.showMessageDialog(frame, "Student found with these personalities!!");
						OutPut2 out=new OutPut2(st);
					}
					
				}
				else if(grade_radio.isSelected()) {
					int check=0;
					int found=0;
					int grade=0;
					ArrayList<Student> stus=new ArrayList<Student>();
					try {
						grade=Integer.parseInt(JOptionPane.showInputDialog("Please enter grade of student:"));
					}
					catch(Exception ex) {
						check=1;
						JOptionPane.showConfirmDialog(frame, "Grade should be a number");
					}
					if(check==0) {
						for(Student st:seminar.getStudents()) {
							if(st.getGrade()==grade) {
								stus.add(st);
								found=1;
							}
						}
					}
					if(found==1) {
						JOptionPane.showMessageDialog(frame, "Student found!");
						OutPut2 out=new OutPut2(stus);
					}
					else {
						JOptionPane.showMessageDialog(frame, "Student not found!!");
					}
				}
				else if(id_radio.isSelected()) {
					int check=0;
					int found=0;
					Long id=0l;
					try {
						id=Long.parseLong(JOptionPane.showInputDialog("please enter id of student"));
					}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(frame, "ID should be a number!");
							//check=1;
					}
					
					if(check==0) {
						for(Student st:seminar.getStudents()) {
							if(st.getId().equals(id)) {
								JOptionPane.showMessageDialog(frame, "Student found!");
								OutPut2 out=new OutPut2(st);
								found=1;
								break;
							}
						}
						if(found==0) {
							JOptionPane.showMessageDialog(frame, "Sudent not found!!");
						}
						
					}
				}
				else if(phone_radio.isSelected()) {
					int check=0;
					int found=0;
					Long phone=0l;
					try {
						phone=Long.parseLong(JOptionPane.showInputDialog("please enter phone number of student"));
					}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(frame, "Phone number should be a number!");
							//check=1;
					}
					
					if(check==0) {
						for(Student st:seminar.getStudents()) {
							if(st.getPhone().equals(phone)) {
								JOptionPane.showMessageDialog(frame, "Student found!");
								OutPut2 out=new OutPut2(st);
								found=1;
								break;
							}
						}
						if(found==0) {
							JOptionPane.showMessageDialog(frame, "Sudent not found!!");
						}
				}
					
				}
				else if(time_radio.isSelected()) {
					int check=0;
					int hour=0;
					int minute=0;
					int second=0;
					int check_word=0;
					int found_before=0,found_after=0,found_equal=0;
					ArrayList<Student> students=new ArrayList<Student>();
					try {
						String[] time=JOptionPane.showInputDialog("Enter time in format hour:minute:second").split(":");
						hour=Integer.parseInt(time[0]);
						minute=Integer.parseInt(time[1]);
						second=Integer.parseInt(time[2]);
					}
					catch(Exception ex) {
						JOptionPane.showMessageDialog(frame, "you should enter time in format hour:minute:second/n(hour,minute and second are numbers)");
					check=1;
					}
					if(check==0) {
						
						String answer=JOptionPane.showInputDialog("Which type of studene do you want to see?Students before this time or after that or exactly in that time?(Just answer with (before) or (after) or (equal) words)");
					if(answer.trim().equals("before")) {
						for(Student stu:seminar.getStudents()) {
							LocalTime l1=LocalTime.of(hour, minute, second);
							LocalTime l2=LocalTime.of(stu.getHour(), stu.getMinute(), stu.getSecond());
							if(l2.isBefore(l1) ) {
								students.add(stu);
								found_before=1;
							}
						}
					}
					else if( answer.trim().equals("after")) {
						for(Student stu:seminar.getStudents()) {
							LocalTime l1=LocalTime.of(hour, minute, second);
							LocalTime l2=LocalTime.of(stu.getHour(), stu.getMinute(), stu.getSecond());
							if(l2.isAfter(l1) ) {
								students.add(stu);
								found_after=1;
							}
						}
					}
					else if(answer.trim().equals("equal")) {
						for(Student stu:seminar.getStudents()) {
							LocalTime l1=LocalTime.of(hour, minute, second);
							LocalTime l2=LocalTime.of(stu.getHour(), stu.getMinute(), stu.getSecond());
							if(l2.compareTo(l1)==0 ) {
								students.add(stu);
								found_equal=1;
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(frame, "Wrong word input!!");
						check_word=1;
					}
					if((found_after==1) || (found_before==1) || (found_equal==1)) {
						JOptionPane.showMessageDialog(frame, "Student found!");
						OutPut2 out=new OutPut2(students);
					}
					else if(check_word==0 && (found_after==0)&&(found_before==0)&&(found_equal==0)) {
						JOptionPane.showMessageDialog(frame, "Student not found!!");
					}
					
					}
					
					
				}
				group.clearSelection();

			}
		});
		sub_confirm.setBounds(228, 197, 89, 23);
		image_label.add(sub_confirm);
		JButton exit_button = new JButton("Exit this page");
		exit_button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exit_button.addActionListener(new ActionListener() {
					
					@Override
		public void actionPerformed(ActionEvent e) {
				frame.dispose();
					}
				});
		exit_button.setBounds(187, 377, 154, 23);
		image_label.add(exit_button);
		frame.setVisible(true);
			}
		
}
