import java.util.ArrayList;

public class Seminar {
	private String title;
	private int hourStart;
	private int minuteStart;
	private int secondStart;
	private int hourFinish;
	private int minuteFinish;
	private int secondFinish;
	private int year;
	private int month;
	private int day;
	private int capacity;
	private ArrayList<Student> students=new ArrayList<Student>();
	public Seminar(ArrayList<Student> stus,String tit,int hours,int minutes,int seconds,int hourf,int minutef,int secondf,
			int year_,int month_,int day_,int cap) {
		students=stus;
		title=tit;
		hourStart=hours;
		minuteStart=minuteStart;
		secondStart=secondStart;
		hourFinish=hourf;
		minuteFinish=minutef;
		secondFinish=secondf;
		year=year_;
		month=month_;
		day=day_;
		capacity=cap;
		
	}
	public void setTitle(String t) {
		title=t;
	}
	public String getTitle() {
		return title;
	}
	public void setCapacity(int c) {
		capacity=c;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setYear(int y) {
		year=y;
	}
	public void setMonth(int m) {
		month=m;
	}
	public void setDay(int d) {
		day=d;
	}
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public void setHourStart(int h) {
		hourStart=h;
	}
	public void setMinuteStart(int m) {
		minuteStart=m;
	}
	public void setSecondStart(int s) {
		secondStart=s;
	}
	public int getHourStart() {
		return hourStart;
	}
	public int getMinuteStart() {
		return minuteStart;
	}
	public int getSecondStart() {
		return secondStart;
	}
	public void setHourFinish(int h) {
		hourFinish=h;
	}
	public void setMinuteFinish(int m) {
		minuteFinish=m;
	}
	public void setSecondFinish(int s) {
		secondFinish=s;
	}
	public int getHourFinish() {
		return hourFinish;
	}
	public int getMinuteFinish() {
		return minuteFinish;
	}
	public int getSecondFinish() {
		return secondFinish;
	}
	public void setStudents(ArrayList<Student> st) {
		students=st;
	}
	public ArrayList<Student> getStudents(){
		return  students;
	}

}
