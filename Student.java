public class Student extends Person {
    protected int term;

    // Creates a student object
    public Student(int idParam, String firstNameParam, String lastNameParam, int termParam) {
        super(idParam, firstNameParam, lastNameParam);
        term = termParam;
    }

    // Returns the students year
    public int getTerm() {
        return term;
    }

    // Sets the students year
    public void setTerm(int termParam) {
        term = termParam;
    }

    // Prints out the contents of the students object
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n" + "id: " + id + "\n" + "term: " + term + "\n" + "\n";
    }
}
