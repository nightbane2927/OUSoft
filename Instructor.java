public class Instructor extends Person {
    private int officeNum;

    // Creates an instructor object
    Instructor(int idParam, String firstNameParam, String lastNameParam, int officeNumParam) {
        super(idParam, firstNameParam, lastNameParam);
        officeNum = officeNumParam;
    }

    // Returns the office number of the instructor object
    public int getOfficeNum() {
        return officeNum;
    }

    // Sets the office number of the instructor object
    public void setOfficeNum(int officeNumParam) {
        officeNum = officeNumParam;
    }

    // Prints out the contents of the instructor object to the console
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n" + "id: " + id + "\n" + "office number: " + officeNum + "\n" + "\n";
    }
}
