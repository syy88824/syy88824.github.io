
public class Course {
	private int courseID;
	private String courseName;
	private int credits;
	private int capacity;
	private int enrolled;
	Course(int id , String name , int credits , int capacity){
		this.courseID = id;
		this.courseName = name;
		this.credits = credits;
		this.capacity = capacity;
		this.enrolled = 0;
	}
	public boolean isFull() {
		if(enrolled == capacity) {
			return true;
		}else {
			return false;
		}
	}
	public void enroll() {
		enrolled+=1;
	}
	public void drop() {
		enrolled-=1;
	}
	public String getInfo() {
		String s = "";
		s = String.format("%d %s %d %d/%d",courseID,courseName,credits,enrolled,capacity);
		return s;
	}
	public int getCourseID() {
		return courseID;
	}
	public int getCredits() {
		return credits;
	}
	public String getCourseName() {
		return courseName;
	}
	public int getCapacity() {
		return capacity;
	}
	
}
