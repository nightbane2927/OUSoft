public class OUPeople {
    protected Student students[];
    protected Instructor instructors[];
    protected int lastStudentIndex = -1;
    protected int lastInstructorIndex = -1;

    // Creates an OUPeople object
    public OUPeople(int studentSize, int instructorSize) {
        students = new Student[studentSize];
        instructors = new Instructor[instructorSize];
    }

    // Adds a student object to the students array
    public void addStudent(Student newStudent) {
        lastStudentIndex++;
        students[lastStudentIndex] = newStudent;
    }

    // Adds an instructor object to the instructors array
    public void addIntstructor(Instructor newInstructor) {
        lastInstructorIndex++;
        instructors[lastInstructorIndex] = newInstructor;
    }

    // Retrieves a student object by id
    public Student getStudent(int idParam) {
        int i = 0;
        while (students[i].getId() != idParam) {
            i++;
        }
        return students[i];

    }

    // Retrieves an instructor object by id
    public Instructor getInstructor(int idParam) {
        int i = 0;
        while (instructors[i].getId() != idParam) {
            i++;
        }
        return instructors[i];
    }

    // Removes a student object by id from the students array
    public void removeStudent(int idParam) {
        int i = 0;
        while (students[i].getId() != idParam) {
            i++;
        }
        students[i] = null;

    }

    // Removes an instructor object by id from the instructors array
    public void removeInstructor(int idParam) {
        int i = 0;
        while (instructors[i].getId() != idParam) {
            i++;
        }
        instructors[i] = null;
    }

    // Prints out information of all students objects in the students array to
    // the console
    public void printStudents() {
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    // Prints out information of all instructors objects in the instructors
    // array to the console
    public void printInstructors() {
        for (int i = 0; i < instructors.length; i++) {
            System.out.println(instructors[i]);
        }
    }
}
