import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String skip;
        boolean keepGoing;
        int stuSize = 0;
        int instSize = 0;
        int courseSize = 0;
        int operation;
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello! Welcome to OUSoft!");
        System.out.println();
        System.out.println("Please select an option >");
        System.out.println();
        System.out.println("1: Create a database of students, instructors and courses >");
        System.out.println();


        if(scan.nextInt() == 1) {
            System.out.println();
            System.out.println("Insert number of students, instructors, and courses separated by a space >");
            System.out.println();
        }



        else {
            System.out.println("Incorrect value entered");
            System.out.println("Exiting database");
            return;

        }


        while(scan.hasNextInt()){
            stuSize = scan.nextInt();
            instSize = scan.nextInt();
            courseSize = scan.nextInt();
            break;
        }

        //initializes OUPeople object
        OUSoft people = new OUSoft(stuSize, instSize, courseSize);
        keepGoing = true;

        while(keepGoing) {
            System.out.println();
            System.out.println("Please enter an operation >");
            System.out.println();
            System.out.println("1: Add a student >");
            System.out.println("2: Add an instructor >");
            System.out.println("3: Retrieve a student >");
            System.out.println("4: Retrieve an instructor >");
            System.out.println("5: Remove a student >");
            System.out.println("6: Remove an instructor >");
            System.out.println("7: Print all student's info. >");
            System.out.println("8: Print all instructors info. >");
            System.out.println("9: Exit >");
            System.out.println();



            if(scan.hasNextInt())
                operation = scan.nextInt();
            else {
                System.out.println("Input must be 1-8, incorrect value entered >");
                System.out.println("Exiting database ");
                return;

            }
            skip = scan.nextLine();

            //prompts user for actions until they want to quit
            switch(operation) {
                case 1: //adding a student
                    System.out.println();
                    System.out.println();
                    System.out.println("Enter id #, first name, last name, year >");
                    System.out.println();
                    Student newStu = new Student(scan.nextInt(), scan.next(), scan.next(), scan.nextInt());
                    people.addStudent(newStu);
                    break;

                case 2: //adding an instructor
                    System.out.println();
                    System.out.println("Enter id #, first name, last name, office num. >");
                    System.out.println();
                    Instructor newInst = new Instructor(scan.nextInt(), scan.next(), scan.next(), scan.nextInt());
                    people.addInstructor(newInst);
                    break;

                case 3: //retrieve a student
                    int retStu;
                    System.out.println();
                    System.out.println("Enter id # of student to retrieve >");
                    System.out.println();
                    retStu = scan.nextInt();
                    System.out.println();
                    System.out.println(people.getStudent(retStu));
                    break;

                case 4: //retrieve a instructor
                    int retInst;
                    System.out.println();
                    System.out.println("Enter id # of instructor to retrieve >");
                    System.out.println();
                    retInst = scan.nextInt();
                    System.out.println();
                    System.out.println(people.getInstructor(retInst));
                    break;

                case 5: //removes a student
                    int stuIdEntered;
                    System.out.println();
                    System.out.println("Enter id # of student to remove >");
                    System.out.println();
                    stuIdEntered = scan.nextInt();
                    people.removeStudent(stuIdEntered);
                    System.out.println();
                    System.out.println("Student" + " " + stuIdEntered + " " + "removed");
                    break;

                case 6: //removes an instructor
                    int instIdEntered;
                    System.out.println();
                    System.out.println("Enter id # of instructor to remove >");
                    System.out.println();
                    instIdEntered = scan.nextInt();
                    people.removeInstructor(instIdEntered);
                    System.out.println();
                    System.out.println("Instructor" + " " + instIdEntered + " " + "removed");
                    break;

                case 7: //prints all student info
                    System.out.println();
                    people.printStudents();
                    break;

                case 8: //prints all instructors info
                    System.out.println();
                    people.printInstructors();
                    break;

                case 9: //stops the database from running
                    keepGoing = false;
                    break;

                default: //exits database
                    System.out.println();
                    System.out.println("Error in operation selection");
                    System.out.println("Exiting database");
                    return;
            }
        }

        System.out.println();
        scan.close();
        System.out.println("Exiting OUPeople!");
    }

}

/*To make program clear, one recommended design is to have seven files
 (Person.java, Student.java, Instructor.java, Course.java, Enrollment.java, OUSoft.java (the database) and Main.java(The console)).
 An OUSoft object is created to manage the array for Student, Instructor, and Course, the linked list of Enrollment objects,
 as well all the methods you implement for working with the objects, arrays and linked list.
 The Main class provides the main method and user interface functionality for managing students, instructors, courses and enrollment.
 You main program also needs to create the course objects and feed in information for the course.
  Then you will prompt for user input for enrollment, which could be either student ID or student first and last name.
  You should also provide interfaces for reporting number of enrollment, listing the enrollment, and list the course information, etc.
  Try to make your interface and design from the perspective of users of your applications (30 points)
  */
