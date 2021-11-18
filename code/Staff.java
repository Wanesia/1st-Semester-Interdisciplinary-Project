import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff implements Serializable {
    private String title;
    private String firstName;
    private String lastName;
    private int telephone;
    private double salary;
    ArrayList<Staff> staffs = new ArrayList<>();


    public void registerStaff() {
        Staff staff = new Staff();
        Scanner scan = new Scanner(System.in);
        System.out.println("Title: ");
        title = scan.next();
        System.out.println("First Name: ");
        firstName = scan.next();
        System.out.println("Last Name: ");
        lastName = scan.next();
        System.out.println("Phone Number: ");
        telephone = scan.nextInt();
        System.out.println("Salary: ");
        salary = scan.nextDouble();
        try {
            FileInputStream f = new FileInputStream("staff.bin");
            ObjectInputStream ois = new ObjectInputStream(f);
            staffs = (ArrayList<Staff>)ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        staffs.add(staff);

        try {
            FileOutputStream f = new FileOutputStream("staff.bin");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(staffs);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "Staff\n" +
                "Title: " + title + "\n" +
                "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + "\n" +
                "Telephone: " + telephone + "\n" +
                "Salary: " + salary + "\n";
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


    public int getTelephone() {
        return telephone;
    }


    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
