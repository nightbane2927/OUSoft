public class Enrollment {
    private Course courseRef;
    private Student student;
    private Enrollment enrollmentLink;

    public Enrollment(Course courseRefParam, Student studentParam) {
        courseRef = courseRefParam;
        student = studentParam;
    }

    public void setEnrollmentLink(Enrollment linkParam) {
        enrollmentLink = linkParam;
    }

    public Enrollment getEnrollmentLink() {
        return enrollmentLink;
    }

    public Course getCourseRef() {
        return courseRef;
    }

    public Student getStudent() {
        return student;
    }

}

/*It will then need an Enrollment class that contains at least two fields,
one for referencing to the Course object and one referencing to the Student object.
Since we will build a linked list of the all enrollment objects,you will add an “Enrollment link” filed in the Enrollment class,
the same approach as the LLNode class in the textbook.
The idea for this design is that we will need an enrollment object for each <course, student>
record and the enrollment object only contains references to the course object and student object,
which is the same principle as the relational database. (10 points)
*/