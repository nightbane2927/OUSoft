public abstract class Person {
     int id;
     String firstName;
     String lastName;

    // Constructor for class, since class is abstract, only used for var.
    // initialization
    public Person(int idParam, String firstNameParam, String lastNameParam) {
        id = idParam;
        firstName = firstNameParam;
        lastName = lastNameParam;
    }

    // Returns the id
    int getId() {
        return id;
    }

    // Sets the id
    public void setId(int idParam) {
        id = idParam;
    }

    // Returns the first name
    public String getFirstName() {
        return firstName;
    }

    // Sets the first name
    public void setFirstName(String firstNameParam) {
        firstName = firstNameParam;
    }

    // Returns the last name
    public String getLastName() {
        return lastName;
    }

    // Sets the last name
    public void setLastName(String lastNameParam) {
        lastName = lastNameParam;
    }

    // Prints out the contents of subclass object, implemented in subclasses
    public abstract String toString();
}
