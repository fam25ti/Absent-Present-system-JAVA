import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OutPut2{
	private JFrame frame;
	private JTextArea text;
	private JScrollPane scroll;
	private Container contentPane ;
	public OutPut2(Student student) {
		make_frame();
		
		text=new JTextArea(10,20);
		text.append("\n"+"Name:"+student.getName()+"\n"+"Family:"+
				student.getFamily()+"\n"+"ID:"+student.getId()+"\n" +"Grade:"+student.getGrade()+"\n"+"Age:"+student.getAge()+
				"\n"+"Phone:"+student.getPhone()+"\n"+"Enterance time: "+student.getHour()+":"+student.getMinute()+":"+student.getSecond());
		text.setEditable(false);
		scroll=new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		frame.add(scroll);
		frame.setVisible(true);
		
		
	}

	public OutPut2(ArrayList<Student> students) {
		
		make_frame();
		text=new JTextArea(10,20);
		for(Student studentt:students) {
		text.append("\n"+"Name:"+studentt.getName()+"\n"+"Family:"+
				studentt.getFamily()+"\n"+"ID:"+studentt.getId()+"\n" +"Grade:"+studentt.getGrade()+"\n"+"Age:"+studentt.getAge()+
				"\n"+"Phone:"+studentt.getPhone()+"\n"+"Enterance time: "+studentt.getHour()+":"+studentt.getMinute()+":"+studentt.getSecond()+"\n"+"----------------------------------------");
		}
		text.setEditable(false);
		scroll=new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		frame.add(scroll);
		frame.setVisible(true);
		
	}
	public OutPut2(Seminar s) {
		make_frame();
		text=new JTextArea(10,20);
		text.append("Title of seminar:"+s.getTitle()+"\n"+"Capacity of seminar:"+s.getCapacity()
		+"\n"+"Date of seminar:"+s.getYear()+"/"+s.getMonth()+"/"+s.getDay()
		+"\n"+"Start time:"+s.getHourStart()+":"+s.getMinuteStart()+":"+s.getSecondStart()+
		"\n"+"End time:"+s.getHourFinish()+":"+s.getMinuteFinish()+":"+s.getSecondFinish()+
		"\n"+"Participants:");
		for(Student stu:s.getStudents()) {
			text.append("\n"+"Name:"+stu.getName()+"\n"+"Family:"+
				stu.getFamily()+"\n"+"ID:"+stu.getId()+"\n" +"Grade:"+stu.getGrade()+"\n"+"Age:"+stu.getAge()+
				"\n"+"Phone:"+stu.getPhone()+"\n"+"Enterance time: "+stu.getHour()+":"+stu.getMinute()+":"+stu.getSecond()+"\n"+"----------------------------------------");
		}
		text.append("\n"+"\n");
		scroll=new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scroll);
		text.setEditable(false);
		frame.add(scroll);
		frame.setVisible(true);

	}
	public OutPut2(ArrayList<Seminar> arrayOfSeminar,String a) {//the string parameter is only to make a different constructor
		make_frame();
		text=new JTextArea(10,20);
		for(Seminar s:arrayOfSeminar) {
		text.append("Title of seminar:"+s.getTitle()+"\n"+"Capacity of seminar:"+s.getCapacity()
		+"\n"+"Date of seminar:"+s.getYear()+"/"+s.getMonth()+"/"+s.getDay()
		+"\n"+"Start time:"+s.getHourStart()+":"+s.getMinuteStart()+":"+s.getSecondStart()+
		"\n"+"End time:"+s.getHourFinish()+":"+s.getMinuteFinish()+":"+s.getSecondFinish()+
		"\n"+"Participants:"+"\n"+"----------------------------------------");
		for(Student stu:s.getStudents()) {
			text.append("\n"+"Name:"+stu.getName()+"\n"+"Family:"+
				stu.getFamily()+"\n"+"ID:"+stu.getId()+"\n" +"Grade:"+stu.getGrade()+"\n"+"Age:"+stu.getAge()+
				"\n"+"Phone:"+stu.getPhone()+"\n"+"Enterance time: "+stu.getHour()+":"+stu.getMinute()+":"+stu.getSecond()+"\n"+"----------------------------------------");
		}
		text.append("\n"+"************************************"+"\n");}
		scroll=new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.add(scroll);
		text.setEditable(false);
		frame.add(scroll);
		frame.setVisible(true);
	}
	public void make_frame() {
		frame=new JFrame("Show information");
		contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		frame.setBounds(30, 30, 550, 550);
	}
}
