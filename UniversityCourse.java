
/**
 * Write a description of class course here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UniversityCourse

{
    // TODO: Add private attributes here
    private String courseCode;
    private String courseName;
    private String instructorName;
    private int creditHours;
    private int maxCapacity;
    private int enrolledStudents;
    private boolean isActive;
    
    // TODO: Add default constructor
    public UniversityCourse(){
        this.courseCode = " ";
        this.courseName = " ";
        this.instructorName = " ";
        this.creditHours = 1 ;
        this.maxCapacity = 1;
        this.enrolledStudents = 0;
        this.isActive = true;
    }
        
    // TODO: Add parameterized constructor
    private UniversityCourse(String courseCode, String courseName, int creditHours, int maxCapacity){
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.creditHours = creditHours;
        this.maxCapacity = maxCapacity;
    }
    
    
    // TODO: Add getters

    public String getcourseCode(){
        return courseCode;
    }
    public String getcourseName(){
        return courseName;
    }
    public String getinstructorName(){
        return instructorName;
    }
    public int getcreditHours(){
        return creditHours;
    }
    public int getmaxCapacity(){
        return maxCapacity;
    }
    public int getenrolledStudents(){
        return enrolledStudents;
    }
    public boolean getisActive(){
        return isActive;
    }
    
    
    // TODO: Add setters with validation
    public void setcreditHours() {
        if (creditHours >=1 && creditHours <= 6){
            this.creditHours = creditHours;
        }
        else {
            System.out.println("Invalid creditHours" );
        }
    }
    public void setmaxCapacity(){
        if (maxCapacity > 0){
            this.maxCapacity=maxCapacity;
        }
        else{
            System.out.println("This is not maxCapacity");
        }
    }
    
    
    // TODO: Add assignInstructor() method
    public void setInstructor(String name){
        this.instructorName = name;
    }
    
    
    // TODO: Add enrollStudent() method
    public boolean enrollStudent() {
    if (isActive && enrolledStudents < maxCapacity) {
        enrolledStudents++;
        return true;
    }
    return false;
    }
    
     // TODO: Add dropStudent() method
    public void dropStudent(){
        if (enrolledStudents > 0){
            enrolledStudents --;
        }
    }
    
    
    
    // TODO: Add getAvailableSeats() method
    public int getAvailableSeats(){
        return maxCapacity - enrolledStudents;
    }
    
    // TODO: Add isFull() method
    public boolean isFull(){
        return enrolledStudents == maxCapacity;
    }
    
    
    // TODO: Add cancelCourse() method
    public void cancelCourse(){
        if(enrolledStudents == 0){
            isActive = false;
        }
    }
    
    
    // TODO: Add displayCourseInfo() method
    public void displayCourseInfo() {
        System.out.println("Course Code      : " + courseCode);
        System.out.println("Course Name      : " + courseName);
        System.out.println("Instructor       : " + instructorName);
        System.out.println("Credit Hours     : " + creditHours);
        System.out.println("Max Capacity     : " + maxCapacity);
        System.out.println("Enrolled Students: " + enrolledStudents);
        System.out.println("Available Seats  : " + getAvailableSeats());
        System.out.println("Course Active    : " + isActive);
        System.out.println("----------------------------------");
    }
    
    
    
    // TODO: Create course1 - "PT821", "Object-Oriented Programming", 3, 40
    // TODO: Create course2 - "PT822", "Database Systems", 3, 35
    public static void main(String[] args) {
    UniversityCourse course1 =
        new UniversityCourse("PT821", "Object-Oriented Programming", 3, 40);
    UniversityCourse course2 =
        new UniversityCourse("PT822", "Database Systems", 3, 35);  

        
    // TODO: Assign instructors to both courses
    course1.setInstructor("Dr. Hazaam Ali");
    course2.setInstructor("Dr. Ali Juma");

    
     // TODO: Enroll 38 students in course1 (use a loop)
    for (int i = 0; i < 38; i++){
        course1.enrollStudent();
    }
    
    
    // TODO: Display course1 info
    course1.displayCourseInfo();
    course2.displayCourseInfo();
    
    // TODO: Check available seats in course1

    System.out.println("Available Seats (Course1): " + course1.getAvailableSeats());
    
    
    // TODO: Try to enroll 5 more students in course1
    for (int i = 0; i < 5; i++) {
            if (!course1.enrollStudent()) {
                System.out.println("Course1 is full. Cannot enroll more students.");
                break;
            }
        }
        
    
    // TODO: Check if course1 is full
    System.out.println("Is Course1 Full? " + course1.isFull());
    
    // TODO: Drop 3 students from course1
    for (int i = 0; i < 3; i++) {
            course1.dropStudent();
        }
        
    
    // TODO: Display final info for both courses
    System.out.println("\nFinal Course Information:");
        course1.displayCourseInfo();
        course2.displayCourseInfo();

        System.out.println("\n=== Exercise Complete ===");
    }
}
    