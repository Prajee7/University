import java.rmi.MarshalException;

/**
 * Stores students choice of classes and stores it.
 *
 * @author Prajeet Pounraj
 * @version 11/24
 */
public class Student {
  private static int MAX_REGISTERED_COURSES = 4; // max number of courses a student can enroll

  private String name; // name of student
  private String[] registeredCourses; // list of currently registered courses
  private int numberOfRegisteredCourses; // number of courses currently registered
  private University university; // university student belongs to

  /**
   * constructor -- create a new student at this university.
   */
  public Student(String newName, University uni) {
    name = newName;
    university = uni;
    numberOfRegisteredCourses = 0;
    registeredCourses = new String[MAX_REGISTERED_COURSES];
  }

  /**
   * return the name of student.
   * name is a private variable, so need getter method.
   * @return
   */
  public String getName() {
    return name;
  }

  public void setName(String newName) {
    name = newName;
  }

  /**
   * return true if student is registered for the given course.
   */
  public boolean isRegisteredFor(String courseName) {
    for (int i = 0; i < registeredCourses.length; i++) {
      if (courseName.equalsIgnoreCase(registeredCourses[i])) {
        return true;
      }
    }
    return false;
  }

  /**
   * Add the course to the list of registeredCourses. Display message if
   * University does not offer this course. Display message if student already
   * registered for this course.
   */
  public void add(String courseName) {
    if (isRegisteredFor(courseName)) {
      System.out.println("Already registered for " + courseName);
    } else if (!university.hasCourse(courseName)) {
      System.out.println("There is no course named " + courseName);
    } else if (numberOfRegisteredCourses < registeredCourses.length) {
      System.out.println(name + " is now registered for " + courseName);
      registeredCourses[numberOfRegisteredCourses] = courseName;
      numberOfRegisteredCourses++;
    }
  }

  /**
   * list all courses that student is registered for.
   */
  private void listCourses() {
    System.out.println("registered courses: ");
    for (int i = 0; i < registeredCourses.length; i++) {
      if (registeredCourses[i] != null) {
        System.out.println(registeredCourses[i]);
      }
    }
  }

  public void drop(String courseName) {
    // HARD
    // Bonus question
    for (int i = 0; i < registeredCourses.length; i++) {
      if (courseName.equalsIgnoreCase(registeredCourses[i])) {
        String temp = registeredCourses[MAX_REGISTERED_COURSES];
        registeredCourses[MAX_REGISTERED_COURSES] = "";
        registeredCourses[i] = temp;
        numberOfRegisteredCourses--;
      }
    }
  }

}