import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Studentauthorities {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();
    public Studentauthorities(){
    }
    static Student checkAccount(String name, String password) {
        Iterator<Student> var2 = students.iterator();

        Student i;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            i = var2.next();
        } while(!i.getName().equals(name) || !i.getPassword().equals(password));

        return i;
    }
    static void createAccount() {
        System.out.println("Enter your username: ");
        String name = sc.next();
        System.out.println("Enter your ID: ");
        int ID = sc.nextInt();
//        System.out.println("Enter your gpa: ");
//        int gpa = sc.nextInt();
        System.out.println("Enter your password: ");
        String password = sc.next();
        Student newStudent = new Student(name, password, ID);
        students.add(newStudent);
        System.out.println("The Account is now yours");
    }

    static void login() {
        System.out.println("Enter your name => ");
        String name = sc.next();
        System.out.println("Enter your password => ");
        String password = sc.next();
        Student i = checkAccount(name, password);
        if (i == null) {
            System.out.println("Account not avilable");
            menu();
        } else {
            StudentWork();
        }
    }

    static void menu() {
        System.out.println("Enter a Number from 1 to 3: ");
        System.out.println("you have an account? Log in => 1");
        System.out.println("oh! you don't? Sign up => 2");
        System.out.println("Return to the firstpage => 3");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                login();
                StudentWork();
                break;
            case 2:
                createAccount();
                menu();
                break;
            case 3:
                CollegeMS.start();
        }


    }
    static void StudentWork(){
        System.out.println("Choose a number from 1 to 3: ");
        System.out.println("View all the classes in the list => 1");
        System.out.println("update Your Data => 2");
        System.out.println("View your Gpa => 3");
        System.out.println("Return to first page => 4");
        int ch = sc.nextInt();
        switch (ch) {

            case 1:
                Classes.viewAll();
                StudentWork();
                break;
            case 2:
                Studentauthorities.update();
                StudentWork();
                break;
            case 3:
                Studentauthorities.viewGpa();
                StudentWork();
                break;
            case 4:
                CollegeMS.start();
            default:
                System.out.println("invalid choice");
                StudentWork();
        }
    }
    static Student getStudent(String name) {
        Iterator<Student> var1 = students.iterator();

        Student student;
        do {
            if (!var1.hasNext()) {
                return null;
            }

            student = var1.next();
        } while(!student.getName().equals(name));

        return student;
    }


    static void update(){
        if (students.isEmpty()) {
            System.out.println("Not a registered Student");
        } else {
            System.out.println("Enter the student's name");
            String name = sc.next();
            Student std = getStudent(name);
            if (std == null) {
                System.out.println("Not a registered Student");
            } else {
                System.out.println("What's there to update?");
                System.out.println("Update the name => 1 ");
                System.out.println("Update the ID => 2 ");
                System.out.println("Return to the first page => 4 ");
                System.out.println();
                int ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        System.out.println("Enter the new name: ");
                        String newName = sc.next();
                        std.setName(newName);
                        System.out.println("the name is now changed");
                      //  std.info();
                        //  Studentauthorities.StudentWork();
                        break;
                    case 2:
                        System.out.println("Enter the new ID");
                        int newID = sc.nextInt();
                        std.setID(newID);
                        System.out.println("the ID is now changed");
//                        std.info();
                       // Studentauthorities.StudentWork();
                        break;
                    case 3:
                       // Studentauthorities.StudentWork();
                    default:
                        System.out.println("Invalid Choice Try Again");
                        update();
                }
            }
        }
    }
   static void viewAll() {
       if (students.isEmpty()) {
           System.out.println("There are no students");
       } else {
           for (Student student : students) {
               System.out.println("Student name is " + student.getName() + " with the ID of " + student.getID() + "  and the Gpa is " + student.getGpa());
           }
       }
   }
   static void updateGpa (){
       if (students.isEmpty()) {
           System.out.println("Not a registered Student");
       } else {
           System.out.println("Enter the student's name: ");
           String name = sc.next();
           Student std = getStudent(name);
           if (std == null) {
               System.out.println("Not a registered Student");
           } else {
                    System.out.println("Enter the new gpa: ");
                     double gpa = sc.nextDouble();
                     std.setGpa(gpa);
                     System.out.println("Done");
                     System.out.println();

           }
   }
}
    static void addStd() {
        System.out.println("Enter Student name: ");
        String name = sc.next();
        System.out.println("Enter Student ID: ");
        int ID = sc.nextInt();
        System.out.println("Enter Student gpa: ");
        double gpa = sc.nextDouble();
        Student newStd = new Student(name, ID, gpa);
        students.add(newStd);
        System.out.println("Done");
        System.out.println();
    }

    static void viewGpa() {
        if (students.isEmpty()) {
            System.out.println("Not a registered Student");
        } else {
            System.out.println("Enter the student's name");
            String name = sc.next();
            Student std = getStudent(name);
            if (std == null) {
                System.out.println("Not a registered Student");
            } else {
                System.out.println("Your GPA is: " + std.getGpa());

            }
        }
    }
}

