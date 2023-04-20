import java.util.ArrayList;

public class Student {
	private  int studentID;
	private String studentName;
	//此enrolledCourse為空的
	private ArrayList<Course> enrolledCourse;
	private int currentCredits;
	private int maxCredits;
	
	Student(int studentID, String name){
		this.studentID = studentID;
		this.studentName = name;
		this.currentCredits = 0;
		this.maxCredits = 25;
		//在constructor階段才要new物件
		this.enrolledCourse = new ArrayList<Course>();
	}
	Student(int studentID , String name , int maxCredits){
		this.studentID = studentID;
		this.studentName = name;
		this.maxCredits = maxCredits;
		this.currentCredits = 0;
		//在constructor階段才要new物件
		this.enrolledCourse = new ArrayList<Course>();
	}
	public Course getCourse(int courseID) {
		for(Course cou: enrolledCourse) {
			if(cou.getCourseID() == courseID) {
				return cou;
			}
		}
		return null;
	}
	public void enroll(Course cou) {
		if(cou.isFull()) {
			System.out.printf("Course %d is full\n",cou.getCourseID());
		}else {
			if(currentCredits+cou.getCredits() > maxCredits) {
				System.out.printf("Student %d cannot enroll this course\n",studentID);
			}else {
				enrolledCourse.add(cou);
				cou.enroll();
				currentCredits+= cou.getCredits();
			}
		}
	}
	public void drop(int courseID) {
		if(getCourse(courseID) == null) {
			System.out.printf("Course %d not found in student %d\n",courseID,studentID);
		}else {
			currentCredits -= getCourse(courseID).getCredits();
			getCourse(courseID).drop();
			//remove要放最後一個，不然先移除上面的方法就抓不到物件了
			enrolledCourse.remove(getCourse(courseID));
		}
	}
	public void drop(Course cou) {
		//呼叫有傳int參數的drop method
		drop(cou.getCourseID());
	}
	public String getInfo() {
		String s = "";
		String s_cou = "";
		//for each取得所有list內的課程物件
		for(Course cou: enrolledCourse) {
			s_cou += String.format("%d %s %d\n",cou.getCourseID(),cou.getCourseName(),cou.getCredits());
		}
		s = String.format("Student ID: %d\nName: %s\nCredits: %d/%d\nCourse list:\n%s", studentID,studentName,currentCredits,maxCredits,s_cou);
		return s;
	}
}
