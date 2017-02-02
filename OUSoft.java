public class OUSoft {
    private Course allCourses[];
    private Student students[];
    private Instructor instructors[];
    private Enrollment allEnrollment;
    private int lastCourseIndex = -1;
    private int lastStudentIndex = -1;
    private int lastInstructorIndex = -1;
    private static int arrCounterStu = 2;
    private static int arrCounterInst = 2;

    // Creates an OUPeople object with specified sizes
    OUSoft(int studentSize, int instructorSize, int courseNum) {
        students = new Student[studentSize];
        instructors = new Instructor[instructorSize];
        allCourses = new Course[courseNum];


    }

    // Adds a student object to the students array
    //Precondition: The students array is not full
    void addStudent(Student newStudent) {
        lastStudentIndex++;
        students[lastStudentIndex] = newStudent;
    }

    // Adds an instructor object to the instructors array
    //Precondition: The instructors array is not full
    void addInstructor(Instructor newInstructor) {
        lastInstructorIndex++;
        instructors[lastInstructorIndex] = newInstructor;
    }

    // Retrieves a student object by id
    //Precondition: Students array isn't empty
    Student getStudent(int idParam) {
        int i = 0;
        while (students[i].getId() != idParam) {
            i++;
        }
        return students[i];

    }

    // Retrieves an instructor object by id
    //Precondition: Instructors array isn't empty
    Instructor getInstructor(int idParam) {
        int i = 0;
        while (instructors[i].getId() != idParam) {
            i++;
        }
        return instructors[i];
    }

    // Removes a student object by id from the students array
    //PreCondition: Students array isn't empty and the id exists
    public void removeStudent(int idParam) {
        int i = 0;
        while (students[i].getId() != idParam) {
            i++;
        }
        students[i] = null;
        for (; i <= students.length - arrCounterStu; i++) {
            students[i] = students[i + 1];
        }
        students[(students.length - arrCounterStu) + 1] = null;
        arrCounterStu++;
        lastStudentIndex--;

    }

    // Removes an instructor object by id from the instructors array
    //Precondition: Instructors array isn't empty and the id exists
    public void removeInstructor(int idParam) {
        int i = 0;
        while (instructors[i].getId() != idParam) {
            i++;
        }
        instructors[i] = null;
        for (; i <= instructors.length - arrCounterInst; i++) {
            instructors[i] = instructors[i + 1];
        }
        instructors[(instructors.length - arrCounterInst) + 1] = null;
        arrCounterInst++;
        lastInstructorIndex--;


    }


    // Prints out information of all students objects in the students array to
    // the console
    //Precondition: Students array isn't empty, prints null otherwise
    public void printStudents() {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    // Prints out information of all instructors objects in the instructors
    // array to the console
    //Precondition: Instructors array isn't empty, prints null otherwise

    public void printInstructors() {
        for (int i = 0; i < instructors.length; i++) {
            System.out.println(instructors[i]);
        }
    }
    //Adds a course object to the Courses array
    public void addCourse(Course course) {
        lastCourseIndex++;
        allCourses[lastCourseIndex] = course;
    }
    //Enrolls a student in a course
    //the program should only allow enrolling a student who is already in the student array and can only enroll a student in a course once.
    //Please make sure your “enroll” method checks those condition and reports necessary errors (or exceptions) to users.
    public void enroll(Student stu, Course course) {
        boolean flag = studentCheck(stu);
        if(flag) {
            Enrollment enroll = new Enrollment(course, stu);
            enroll.setEnrollmentLink(allEnrollment);
            allEnrollment = enroll;
        }
        else
            System.out.println("Sorry, that student isn't in the database. Exiting OUSoft.");

    }

    private boolean studentCheck(Student stu) {
        for(int i = 0; i < students.length; i++){
            if(students[i].getId() == stu.getId())
                return true;
        }
        return false;
    }

    //Withdraws a student from a course
    //returns null if the list is empty
    public Enrollment withdraw(Student stu, Course course) {
        Enrollment previous = allEnrollment;
        Enrollment current = allEnrollment;
        while (!(current.getCourseRef().equals(course) && current.getStudent().equals(stu))) {
            if (current.getEnrollmentLink() == null)
                return null;
            else {
                previous = current;
                current = current.getEnrollmentLink();
            }
        }

        if (current == allEnrollment) {
            allEnrollment = allEnrollment.getEnrollmentLink();

        } else {
            previous.setEnrollmentLink(current.getEnrollmentLink());
        }
        return current;
    }
    //Returns the number of students enrolled in a course
    public int numEnrollment(Course course) {
        int totalStudentsinCourse = 0;
        Enrollment current = allEnrollment;
        while (current != null) {
            if (current.getCourseRef().equals(course))
                totalStudentsinCourse++;
            else current = current.getEnrollmentLink();
        }
        return totalStudentsinCourse;

    }
    //Determines if a particular student is enrolled in a particular course
    public boolean contains(Student stu, Course course) {
        Enrollment current = allEnrollment;
        while (current != null) {
            if (current.getCourseRef().equals(course) && current.getStudent().equals(stu))
                return true;
            else current = current.getEnrollmentLink();
        }
        return false;
    }
    //Returns the number of courses a student is in
    public int numCourses(Student stu) {
        int courseCount = 0;
        Enrollment current = allEnrollment;
        while (current != null) {
            if (current.getStudent().equals(stu)) {
                courseCount++;
            }
            current = current.getEnrollmentLink();
        }
        return courseCount;

    }
    //Prints the information of the students in a particular course
    public void printEnrollment(Course course) {
        Enrollment current = allEnrollment;
        while (current != null) {
            if (current.getCourseRef().equals(course)) {
                current.getStudent().toString();
            }
            current = current.getEnrollmentLink();

        }
    }
    //Prints the information of the courses a particular student is in
    public void printCourses(Student stu) {
        Enrollment current = allEnrollment;
        while (current != null) {
            if (current.getStudent().equals(stu)) {
                current.getCourseRef().toString();
            }
            current = current.getEnrollmentLink();

        }
    }


}
