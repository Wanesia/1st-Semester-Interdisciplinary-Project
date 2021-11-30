import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff  implements Serializable  {
    private static final long serialVersionUID = -3971986109222559602L;
    private String title;
    private String firstName;
    private String lastName;
    private String telephone;
    private double salary;


    public Staff() {

    }

    public Staff(String title, String firstName, String lastName, String telephone, double salary) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.salary = salary;
    }




    public Staff registerStaff() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Pick Your Title: ");
        System.out.println("[1][General Manager]");
        System.out.println("[2][Wait Staff]");
        System.out.println("[3][Concierge]");
        System.out.println("[4][Cleaning Staff]");
        String s = scan.next();
        switch (s) {
            case "1" : {
                setTitle("General Manager");
                setSalary(360000);
                break;
            }
            case "2" : {
                setTitle("Wait Staff");
                setSalary(337000);
                break;
            }
            case "3" : {
                setTitle("Concierge");
                setSalary(326800);
                break;
            }
            case "4" : {
                setTitle("Cleaning Staff");
                setSalary(291000);
                break;
            }
            default : System.out.println("Please pick one of the available job titles");
        }
        System.out.println("First Name: ");
        setFirstName(scan.next());
        System.out.println("Last Name: ");
        setLastName(scan.next());
        System.out.println("Phone Number: ");
        setTelephone(scan.nextLine());

        System.out.println(this);

        return this;
    }

    @Override
    public String toString() {
        return "Staff Info\n" +
                "Title: " + title + "\n" +
                "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + "\n" +
                "Telephone: " + telephone + "\n" +
                "Yearly Salary: " + salary + "DKK" + "\n";
    }

    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
