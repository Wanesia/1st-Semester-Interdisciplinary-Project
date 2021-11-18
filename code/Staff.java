import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff  implements Serializable  {
    private String title;
    private String firstName;
    private String lastName;
    private int telephone;
    private double salary;
    ArrayList<Staff> staffs = new ArrayList<>();


    public void registerStaff() {
        Staff staff = new Staff();
        Scanner scan = new Scanner(System.in);
        System.out.println("Pick Your Title: ");
        System.out.println("[1][General Manager]");
        System.out.println("[2][Wait Staff]");
        System.out.println("[3][Concierge]");
        System.out.println("[4][Cleaning Staff]");
        String s = scan.next();
        switch (s) {
            case "1" -> title = "General Manager";
            case "2" -> title = "Wait Staff";
            case "3" -> title = "Concierge";
            case "4" -> title = "Cleaning Staff";
            default -> System.out.println("Please pick one of the available job titles");
        }
        //title = scan.next();
        System.out.println("First Name: ");
        firstName = scan.next();
        System.out.println("Last Name: ");
        lastName = scan.next();
        System.out.println("Phone Number: ");
        telephone = scan.nextInt();
//        System.out.println("Salary(DKK/Year): " + salary);

        switch (title) {
            case "General Manager" -> salary = 360000;
            case "Wait Staff" -> salary = 337000;
            case "Concierge" -> salary = 326800;
            case "Cleaning Staff" -> salary = 291000;
            default -> System.out.println("No salary to display");
        }

        System.out.println(toString());


        //salary = scan.nextDouble();

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
