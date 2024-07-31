import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Adminauthorities{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Admin> admins = new ArrayList<>();
    public Adminauthorities(){
    }
    static Admin checkAccount(String name, String password) {
        Iterator<Admin> var2 = admins.iterator();

        Admin i;
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
        System.out.println("Enter your password: ");
        String password = sc.next();
        Admin newAdmin = new Admin(name, password, ID);
        admins.add(newAdmin);
        System.out.println("The Account is now yours");
        System.out.println();
    }

    static void login() {
        System.out.println("Enter your name=> ");
        String name = sc.next();
        System.out.println("Enter your password=> ");
        String password = sc.next();
        Admin i = checkAccount(name, password);
        if (i == null) {
            System.out.println("Account not avilable");
            menu();
        } else {
            AdminWork();
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
                AdminWork();
                break;
            case 2:
                createAccount();
                menu();
                break;
            case 3:
                CollegeMS.start();
        }


    }
    static void AdminWork(){
        System.out.println("Choose a number from 1 to 5: ");
        System.out.println("add a class to the System => 1");
        System.out.println("add a student to the System => 2");
        System.out.println("View all students in the list => 3");
        System.out.println("update student's Data => 4");
        System.out.println("Return to first page => 5");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                Classes.addClass();
                AdminWork();
                break;
            case 2:
                Studentauthorities.addStd();
                AdminWork();
                break;
            case 3:
                Studentauthorities.viewAll();
                AdminWork();
                break;
            case 4:
                Studentauthorities.update();
                AdminWork();
            case 5:
                CollegeMS.start();
            default:
                System.out.println("invalid choice");
                AdminWork();
        }
    }
}
