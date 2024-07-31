import java.util.ArrayList;
import java.util.Scanner;

public class Classes {
    private String name;
    private int ID;


  public Classes (String name, int ID){
      this.name = name;
      this.ID = ID;
  }
    public String getName() {
      return this.name;
    }

//    public void setName(String name) {
//      this.name = name;
//    }

    public int getID() {
        return this.ID;
    }

//    public void setID(int ID) {
//        this.ID = ID;
//    }
//    public void viewInfo(){
//        System.out.println("Class :" + getName() + "  ID :" + getID());
//    }
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Classes> classes = new ArrayList<>();

    static void addClass() {
        System.out.println("Enter the Class name ");
        String name = sc.next();
        System.out.println("Enter the ID ");
        int ID = sc.nextInt();
        Classes newClass = new Classes(name, ID);
        classes.add(newClass);
        System.out.println("New class is now available");
        System.out.println();
    }
    static void viewAll(){
        for (Classes classes1 : classes) {
            System.out.println("Name: " + classes1.getName() + ", ID: " + classes1.getID());
        }
    }



}
