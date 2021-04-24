
public class Student {
	private String name;
	private String family;
	private int age;
	private int grade;
	private Long phone;
	
	private Long id;
	private int hour;
	private int minute;
	private int second;//entrance time
	public Student(String name,String family,int age,int grade,Long idNum,Long phoneNumber,int hour,int minute,int second) {
		this.name=name;
		this.family=family;
		this.age=age;
		this.grade=grade;
		this.phone=phoneNumber;
		this.id=idNum;
		
		this.hour=hour;
		this.minute=minute;
		this.second=second;
		
		
	}
	public void setName(String n) {
		name=n;
	}
	public void setFamily(String f) {
		family=f;
	}
	public void setAge(int a) {
		age=a;
	}
	public void setGrade(int g) {
		grade=g;
	}
	public void setId(Long idd) {
		id=idd;
	}
	public void setHour(int h) {
		hour=h;
	}
	public void setMinute(int m) {
		minute=m;
	}
	public void setSecond(int s) {
		second=s;
	}
	
	public void setPhone(Long ph) {
		phone=ph;
	}
	public String getName() {
		return name;
	}
	public String getFamily() {
		return family;
	}
	public int getAge() {
		return age;
	}
	public int getGrade() {
		return grade;
	}
	public Long getId() {
		return id;
	}
	public Long getPhone() {
		return phone;
	}
	public int getHour() {
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}

		
	
}
