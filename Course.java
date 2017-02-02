public class Course {
    private String courseName;
    private String meetTime;
    private Instructor instructor;

    public Course(String courseNameparam, String meetTimeParam, Instructor instructorParam) {
        courseName = courseNameparam;
        meetTime = meetTimeParam;
        instructor = instructorParam;
    }

    public String toString() {
        return "Course: " + courseName + "\n" + "Time: " + meetTime + "\n" + "Instructor: " + instructor + "\n" + "\n";
    }


}

/*It will need a Course Java class, which includes information for a course such as course name, instructor, class meeting time, etc.
 The instructor field of a Course object should reference to a valid Instructor object.
*/