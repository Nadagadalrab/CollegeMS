import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Instructorauthorities {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Instructor> instructors;
    public Instructorauthorities() {
    }


    static void createAccount() {
        System.out.println("Enter your username: ");
        String name = sc.next();
        System.out.println("Enter your ID: ");
        int ID = sc.nextInt();
        System.out.println("Enter your password: ");
        String password = sc.next();
        Instructor newInstructor = new Instructor(name, password, ID);
        instructors.add(newInstructor);
        System.out.println("The Account is now yours");
    }

    static void login() {
        System.out.println("Enter your name=> ");
        String name = sc.next();
        System.out.println("Enter your password=> ");
        String password = sc.next();
        Instructor i = checkAccount(name, password);
        if (i == null) {
            System.out.println("Account not avilable");
             menu();
        } else {
            InstructorWork();
        }

    }

    static Instructor checkAccount(String n, String pass) {
        Iterator<Instructor> var2 = instructors.iterator();

        Instructor c;
        do {
            if (!var2.hasNext()) {
                return null;
            }

            c = var2.next();
        } while (!c.getName().equals(n) || !c.getPassword().equals(pass));

        return c;
    }
static void InstructorWork(){
    System.out.println("Enter your choice");
    System.out.println("update a students grade => 1");
    System.out.println("View all students in the list => 2");
    System.out.println("Return to the firstpage => 3");
    int ch = sc.nextInt();
    switch (ch) {
        case 1:
            Studentauthorities.updateGpa();
            InstructorWork();
            break;
        case 2:
            Studentauthorities.viewAll();
            InstructorWork();
            break;
        case 3:
            CollegeMS.start();
            break;
        default:
            System.out.println("Invalid Choice Try Again");
            InstructorWork();
    }
}
public static void menu(){
    System.out.println("Enter a Number from 1 to 3");
    System.out.println("you have an account? Log in => 1");
    System.out.println("oh! you don't? Sign up => 2");
    System.out.println("Return to the firstpage => 3");
    int ch = sc.nextInt();
    switch (ch) {
        case 1:
            login();
            InstructorWork();
            break;
        case 2:
            createAccount();
            menu();
            break;
        case 3:
            CollegeMS.start();
    }

}

    static {
        instructors = new ArrayList<>();
    }
}
