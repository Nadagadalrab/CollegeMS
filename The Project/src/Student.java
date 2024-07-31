public class Student extends Person{
private double gpa;
    public Student(String name, String password, int ID) {
        super(name, password, ID);

    }
    public Student(String name, int ID, double gpa){
        super(name, ID);
        this.gpa = gpa;

    }
    public double getGpa(){
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}


//takeClass
//checkclasses
//view gpa
