import java.util.Scanner;

/**
 * Stores information about the university and calls the student class to help
 * find students and link them with the university/courses.
 * 
 * @author Prajeet Pounraj
 * @version 11/24/2021
 */
public class University {
  private static int MAX_COURSES = 100; // max courses at university
  private static int MAX_STUDENTS = 1000; // max students at university

  private String[] courses; // courses currently offered
  private int numberOfCourses; // number of courses currently on offer
  private Student[] students; // students enrolled at university
  private int numberOfStudents; // number of students currently enrolled
  private String name; // name of university

  /**
   * constructor -- set name of university.
   * initialize numberOfCourses, numberOfStudents.
   */
  public University(String newName) {
    name = newName;
    courses = new String[MAX_COURSES];
    students = new Student[MAX_STUDENTS];
    numberOfCourses = 0;
    numberOfStudents = 0;
  }

  /**
   * return true if a course with the given name is offered.
   * @return
   */
  public boolean hasCourse(String courseName) {
    for (int i = 0; i < courses.length; i++) {
      if (!(courses[i] == null)) {
        if (courses[i].equalsIgnoreCase(courseName)) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * print out all courses offered.
   */
  public void listCourses() {
    System.out.println("Courses are: ");
    for (int i = 0; i < courses.length; i++) {
      if (courses[i] != null) {
        System.out.println(courses[i]);
      }
    }
  }

  /**
   * add a new course to courses[].
   */
  public void addCourse(String courseName) {
    courses[numberOfCourses] = courseName;
    numberOfCourses++;
  }

  /**
   * print out all students enrolled at university.
   */
  public void listStudents() {
    System.out.println("Students are:");
    for (int i = 0; i < students.length; i++) {
      if (students[i] != null) {
        System.out.println(students[i].getName());
      }
    }
  }

  /**
   * print out all students enrolled in this course.
   */
  public void listStudentsInCourse(String courseName) {
    for (int i = 0; i < students.length; i++) {
      if (students[i] != null) {
        if (students[i].isRegisteredFor(courseName)) {
          System.out.println("Students in " + courseName + " are:");
          System.out.println(students[i].getName());
        }
      }
    }
  }

  /**
   * return a Student object based on name.
   * if no student with that name found, return null.
   * @return
   */
  public Student getStudent(String name) {
    for (int i = 0; i < students.length; i++) {
      if (students[i] != null) {
        if (students[i].getName().equalsIgnoreCase(name)) {
          return students[i];
        }
      }
    }
    return null;
  }

  /**
   * enroll a student at university.
   */
  public void enroll(Student student) {
    students[numberOfStudents] = student;
    numberOfStudents++;
  }

  /**
   * display information about university.
   */
  public void information() {
    System.out.println(name + " has " + numberOfCourses + " courses and " 
        + numberOfStudents + " students");
  }

  /**
   * short string when university object is printed.
   */
  public String toString() {
    return "<" + name + ">";
  }

}