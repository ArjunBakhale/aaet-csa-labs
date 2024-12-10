/* Assignment: Student Class Implementation
 *
 * Create a Student class that manages student course schedules.
 * Requirements:
 * 1. Private instance variables for:
 *    - name (String)
 *    - id (int)
 *    - courses (array of 8 Strings)
 *
 * 2. Implement:
 *    - Two constructors
 *    - Methods for managing courses (add, drop, swap)
 *    - Getters and setters for name and id
 *    - toString method
 */

public class Student {
    // TODO: Declare private instance variables

    private String name;
    private int id;
    private String[] courses;

    
    // TODO: Create constructor that takes name and id
    // Initialize courses array with size 8 (periods 1-8)

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new String[8];
    }


    // TODO: Create constructor that takes only name
    // Should call first constructor with id = -1


    public Student(String name){
        this(name, -1);
    }

    // TODO: Implement getName method
    // Should return student's name

    public String getName() {
        return name;
    }

    // TODO: Implement setName method
    // Parameter: String name
    // Should update student's name

    public void setName(String name) {
        this.name = name;
    }


    // TODO: Implement getId method
    // Should return student's id

    public int getId() {
        return id;
    }


    // TODO: Implement setId method
    // Parameter: int id
    // Should update student's id

    public void setId(int id) {
        this.id = id;
    }

    // TODO: Implement addCourse method
    // Parameters: int periodNumber, String courseName
    // Should validate period number (1-8)
    // Should store course name in appropriate array index

    public void addCourse(int periodNumber, String courseName) {
        if (periodNumber >= 1 && periodNumber <= 8) {
            courses[periodNumber -1 ] = courseName;
        }
    }


    // TODO: Implement dropCourse method
    // Parameter: int periodNumber
    // Should validate period number (1-8)
    // Should set course name of specified period to null
    // Should return dropped course name or null

    public String dropCourse(int periodNumber) {
        if (periodNumber >= 1 && periodNumber <= 8) {
            String droppedCourse = courses[periodNumber];
            courses[periodNumber] = null;
            return droppedCourse;
        }
        return null;
    }

    // TODO: Implement swapCourses method
    // Parameters: int period1, int period2
    // Should validate both period numbers (1-8)
    // Should swap courses in the specified periods
    // Should return true if swap successful, false if either period invalid

    public boolean swapCourses(int period1, int period2) {
        if ((period1 >= 1 && period1 <= 8) && (period2 >= 1 && period2 <= 8)) {
            String temp = courses[period1];
            courses[period1] = courses[period2];
            courses[period2] = temp;
            return true;
        }
        return false;
    }

    // TODO: Implement toString method
    // Should return name, id, and list of courses by period

    public String toString(){
        String result = "Name: " + name + "\nID: " + id + "\nCourses:";
        for (int i = 1; i < courses.length; i++) {
            result += "\nPeriod " + i + ": " + courses[i];
        }
        return result;
    }

    public static void main(String[] args) {
        // Test constructors
        Student s1 = new Student("John Smith", 12345);
        Student s2 = new Student("Jane Doe");  // Uses default constructor

        // Test getters/setters
        System.out.println("\n=== Testing Getters/Setters ===");
        System.out.println("Initial name: " + s1.getName());
        s1.setName("John A. Smith");
        System.out.println("Updated name: " + s1.getName());

        System.out.println("\nInitial id: " + s1.getId());
        s1.setId(54321);
        System.out.println("Updated id: " + s1.getId());
        System.out.println("Default id for s2: " + s2.getId());  // Should be -1

        // Test course management
        System.out.println("\n=== Testing Course Management ===");
        s1.addCourse(1, "AP Computer Science");
        s1.addCourse(2, "English Literature");
        s1.addCourse(3, "Physics");
        s1.addCourse(4, "US History");
        System.out.println("\nInitial schedule:");
        System.out.println(s1);

        // Test invalid period
        s1.addCourse(9, "Invalid Course");
        s1.addCourse(0, "Invalid Course");

        // Test dropping courses
        String dropped = s1.dropCourse(1);
        System.out.println("Dropped from period 1: " + dropped);
        dropped = s1.dropCourse(5);  // Empty period
        System.out.println("Dropped from empty period: " + dropped);  // Should be null

        // Test swapping courses
        System.out.println("\nBefore swap:");
        System.out.println(s1);

        boolean swapped = s1.swapCourses(2, 3);
        System.out.println("Swap successful (2 and 3): " + swapped);
        System.out.println("After swap:");
        System.out.println(s1);

        swapped = s1.swapCourses(1, 9);  // Invalid period
        System.out.println("Swap with invalid period: " + swapped);

        // Test second student
        System.out.println("\n=== Testing Second Student ===");
        s2.addCourse(1, "Calculus");
        s2.addCourse(2, "Spanish");
        s2.addCourse(3, "Chemistry");
        System.out.println(s2);

        s2.swapCourses(1, 3);
        System.out.println("\nAfter swapping periods 1 and 3:");
        System.out.println(s2);

        // Test toString with empty schedule
        Student s3 = new Student("Empty Schedule", 9999);
        System.out.println("\n=== Testing Empty Schedule ===");
        System.out.println(s3);
    }
}



