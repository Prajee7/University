import java.util.Scanner;

/**
 * Write a description of class Registrar here.
 *
 * @author Prajeet Pounraj
 * @version 11/24
 */

public class Registrar {
  // static variable, so we can use the same keyboard for all input
  static Scanner keyboard = new Scanner(System.in);

  /**
   * prompt user for integer and return it.
   */
  private static int getChoice(String prompt) {
    System.out.print(prompt);
    int choice = keyboard.nextInt();
    return choice;
  }

  /**
   * prompt user for String and return it.
   * @return
   */
  private static String getString(String prompt) {
    System.out.print(prompt);
    String str = keyboard.next();
    return str;
  }

  /**
   * Main menu for program, asks university name. Creates university object and
   * calls universityMenu
   */
  public static void mainMenu() {
    System.out.println("Welcome to the Registrar program");
    changeUni();
  }

  /**
   * helps with changing uni extra credit.
   */
  public static void changeUni() {
    String uniName = getString("Enter a name for University: ");
    University uni = new University(uniName);
    universityMenu(uni);
  }

  /**
   * Main university menu with registrar functions.
   */
  private static void universityMenu(University uni) {
    System.out.println("Welcome to the " + uni + " menu");
    System.out.println("1. Display information about the university");
    System.out.println("2. List all courses");
    System.out.println("3. Add a course");
    System.out.println("4. Enroll a new student");
    System.out.println("5. List all students");
    System.out.println("6. Register a student for a course");
    System.out.println("7. List all students enrolled in a course");
    System.out.println("8. Drop a course");
    System.out.println("9. Change university");
    System.out.println("10. Exit");
    int choice = getChoice("Enter command: ");
    System.out.println("Choice is " + choice);
    switch (choice) {
      case 1:
        uni.information();
        break;
      case 2:
        uni.listCourses();
        break;
      case 3:
        addCourse(uni);
        break;
      case 4:
        enrollAStudent(uni);
        break;
      case 5:
        uni.listStudents();
        break;
      case 6:
        registerStudentForCourse(uni);
        break;
      case 7:
        listStudentsInCourse(uni);
        break;
      case 8:
        dropCourse(uni);
        break;
      case 9:
        mainMenu();
        break;
      case 10:
        System.out.println("Thank you for using the Registrar program");
        System.exit(0);
        break;
      default:
        System.out.println("Invalid choice " + choice);
    }
    System.out.println();
    universityMenu(uni);
  }

  /**
   * checks if the course is already offered at university.
   * if course is not offered, adds course.
   */
  private static void addCourse(University uni) {
    String course;
    course = keyboard.next();
    if (!uni.hasCourse(course)) {
      System.out.println("Added new course");
      uni.addCourse(course);
    } else {
      System.out.println("Already have a course named " + course);
    }
  }

  /**
   * Drops a course of a select student.
   */
  private static void dropCourse(University uni) {
    String course;
    System.out.println("Enter course:");
    course = keyboard.next();
    System.out.println("Enter Student name:");
    String name = keyboard.next();
    Student obj = new Student(name, uni);
    if (!obj.isRegisteredFor(course)) {
      System.out.println("No such course found");
    }
    if (uni.getStudent(name) != null) {
      obj.drop(course);
      System.out.println(course + " has been dropped");
    } else {
      System.out.println("Could not find student");
    }
  }

  /**
   * gets name from user, creates Student object and
   * enrolls the new student at university
   */
  private static void enrollAStudent(University uni) {
    String name = keyboard.next();
    Student obj = new Student(name, uni);
    uni.enroll(obj);
    System.out.println("Enrolled student");
  }

  /**
   * gets name from user, checks if the student with that name
   * can be found at university.
   * If student is found, gets course name
   * if course is offered at university and student is not
   * already registered for the course, add student to that course
   */
  private static void registerStudentForCourse(University uni) {
    System.out.print("Student name: ");
    String studentName = keyboard.next();
    if (uni.getStudent(studentName) == null) {
      System.out.println("Could not find student with name " + studentName);
      Student obj = new Student(studentName, uni);
      uni.enroll(obj);
      System.out.println("Enrolled student");
    } 
    System.out.println("Course name: ");
    String courseName = keyboard.next();
    Student obj = new Student(studentName, uni);
    if (!uni.hasCourse(courseName)) {
      System.out.println(courseName + " is not one of the courses offered ");
    } else if (obj.isRegisteredFor(courseName)) {
      System.out.println("Registered student for a course");
      obj.add(courseName);
    }
    // Error to print:
    // System.out.println(studentName + " is already registered in " + courseName);
  }

  // gets course name from user, if course is offered
  // prints all students taking that course
  private static void listStudentsInCourse(University uni) {
    System.out.println("Course name:");
    String courseName = keyboard.next();
    if (!uni.hasCourse(courseName)) {
      System.out.println(courseName + " is not one of the courses offered ");
    } else {
      uni.listStudentsInCourse(courseName);
    }

    // Error to print:
    // System.out.println(courseName + " is not one of the courses offered ");
  }

}