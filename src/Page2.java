import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Page2 extends BaseOfPages {
	private ArrayList<Seminar> seminars=new ArrayList<Seminar>();
	public Page2() {
		super();
		load_all_seminars();
		JButton btn1 = new JButton("Start a new seminar");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Start_Seminar ss=new Start_Seminar();

			}
		});
		btn1.setBounds(141, 106, 250, 46);
		super.image_label.add(btn1);
		
		JButton btn2 = new JButton("List all seminars");
		btn2.setBounds(141, 163, 250, 46);
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OutPut2 output=new OutPut2(seminars, "");

			}
		});
		super.image_label.add(btn2);
		
		JButton btn3 = new JButton("Search a seminar");
		btn3.setBounds(141, 220, 250, 46);
		btn3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int found=0;
				String title_entered=JOptionPane.showInputDialog("Please enter title of seminar:");
				for(Seminar seminar:seminars) {
					if(seminar.getTitle().equals(title_entered)) {
						OutPut2 out=new OutPut2(seminar);
						/*System.out.println("found");
						for(Student s:seminar.getStudents()) {
							System.out.println(s.getName());
							System.out.println("\n");
						}*/
						found=1;
						break;
					}
				}
				if(found==0) {
					JOptionPane.showMessageDialog(frame, "Seminar not found!!!");
				}
			}
		});
		super.image_label.add(btn3);
		JButton btn4=new JButton("Search a student in a seminar");
		btn4.setBounds(141, 277, 250,46);
		btn4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int found=0;
				String titleEntered=JOptionPane.showInputDialog("Please enter title of seminar:");
				for(Seminar seminarr:seminars) {
					if(seminarr.getTitle().equals(titleEntered)) {
						JOptionPane.showMessageDialog(frame, "Please choose type of search");
						SearchStudentInSeminar search=new SearchStudentInSeminar(seminarr);
						found=1;
						break;
					}
				}
				if(found==0) {
					JOptionPane.showMessageDialog(frame, "Seminar not found!!!");
				}
			}
		});
		image_label.add(btn4);
		JButton btn5=new JButton("List seminars sorted by date");
		btn5.setBounds(141, 334, 250, 46);
		btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Seminar> sorted=new ArrayList<Seminar>();
				for(Seminar s:seminars) {
					sorted.add(s);
				}
				
				for(int i=0;i<seminars.size()-1;i++) {
					for (int j=0;j<sorted.size()-i-1;j++) {
						int year1=sorted.get(j).getYear();
						int year2=sorted.get(j+1).getYear();
						int month1=sorted.get(j).getMonth();
						int month2=sorted.get(j+1).getMonth();
						int day1=sorted.get(j).getDay();
						int day2=sorted.get(j+1).getDay();
						LocalDate date1=LocalDate.of(year1, month1, day1);
						LocalDate date2=LocalDate.of(year2, month2, day2);
						if(date2.isBefore(date1)) {
							Seminar temp=sorted.get(j);
							sorted.set(j, sorted.get(j+1));
							sorted.set(j+1, temp);
						}
					}
				}
				
				OutPut2 output=new OutPut2(sorted, "");

			}
		});
		image_label.add(btn5);
		JButton exit_btn=new JButton("Exit");
		exit_btn.setBounds(230,391 , 70, 20);
		exit_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		image_label.add(exit_btn);
		super.frame.setVisible(true);
	}
	public void load_all_seminars() {
		HashSet<String> all_address=new HashSet<String>();
		try {

			FileReader reader = new FileReader("All.txt");
			Scanner sc=new Scanner(reader);
			while(sc.hasNext()) {
				all_address.add(sc.nextLine());
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
		}
		for(String url:all_address) {
			try {
				FileInputStream fi = new FileInputStream(url);
				InputStreamReader is = new InputStreamReader(fi, "UTF-8");
				BufferedReader bf = new BufferedReader(is);
				String s="";
				ArrayList<Student> stu=new ArrayList<Student>();
				String titleOfSeminar;
				int capacityOfSeminar;
				String[] dateOfSeminar;
				String[] startTime;
				String[] finishTime;
				String nameOfStu;
				String familyOfStu;
				int ageOfStu;
				Long phoneOfStu;
				int gradeOfStu;
				Long idOfStu;
				String[] entranceTimeOfStu;
				titleOfSeminar=bf.readLine();
				capacityOfSeminar=Integer.parseInt(bf.readLine());
				dateOfSeminar=bf.readLine().split("/");
				startTime=bf.readLine().split(":");
				finishTime=bf.readLine().split(":");
				while((s=bf.readLine())!=null) {
					nameOfStu=s;
					familyOfStu=bf.readLine();
					ageOfStu=Integer.parseInt(bf.readLine());
					phoneOfStu=Long.parseLong(bf.readLine());
					gradeOfStu=Integer.parseInt(bf.readLine());
					idOfStu=Long.parseLong(bf.readLine());
					entranceTimeOfStu=bf.readLine().split(":");
					Student st=new Student(nameOfStu, familyOfStu, ageOfStu, gradeOfStu, idOfStu, phoneOfStu,
							Integer.parseInt(entranceTimeOfStu[0]) , Integer.parseInt(entranceTimeOfStu[1]), 
							Integer.parseInt(entranceTimeOfStu[2]));
					stu.add(st);
				}
				Seminar semi=new Seminar(stu,titleOfSeminar, Integer.parseInt(startTime[0]),
						Integer.parseInt(startTime[1]), Integer.parseInt(startTime[2]), 
						Integer.parseInt(finishTime[0]), Integer.parseInt(finishTime[1]),
						Integer.parseInt(finishTime[2]), Integer.parseInt(dateOfSeminar[0]),
						Integer.parseInt(dateOfSeminar[1]), Integer.parseInt(dateOfSeminar[2])
						, capacityOfSeminar);
				seminars.add(semi);
			
			}
			catch(Exception ex) {
				ex.printStackTrace();
				
			}
		}
	}

}
