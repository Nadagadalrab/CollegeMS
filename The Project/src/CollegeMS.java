
import java.util.Scanner;

public class CollegeMS {

    public CollegeMS(){
    }
   static void start(){
       Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number from 1 to 3");
        System.out.println("1 => Admin");
        System.out.println("2 => Student");
        System.out.println("3 => Instructor");
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                Adminauthorities.menu();
                break;
            case 2:
                Studentauthorities.menu();
                break;
            case 3:
                Instructorauthorities.menu();
            default:
                System.out.println("Invalid choice");
        }

    }
public static void main(String[] args){
start();
}
}