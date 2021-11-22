import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff implements Serializable  {
    private String title;
    private String firstName;
    private String lastName;
    private int telephone;
    private double salary;
    ArrayList<Staff> staffs = new ArrayList<>();

    Staff staff;

    public Staff() {

    }

    public Staff(String title, String firstName, String lastName, int telephone, double salary) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.salary = salary;
    }

    public void registerStaff() {
        staff = new Staff();
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

        System.out.println(this);


        //salary = scan.nextDouble();

        staffs.add(staff);

        try {
            FileOutputStream fileOut = new FileOutputStream("Staff.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(staff);
            out.close();
            fileOut.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



//        try {
//            FileInputStream fileIn = new FileInputStream("Staff.ser");
//            ObjectInputStream in = new ObjectInputStream(fileIn);
//            staff = (Staff) in.readObject();
//            in.close();
//            fileIn.close();
//        }
//        catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }


    public void displayStaff() {
        try {
            FileInputStream fileIn = new FileInputStream("Staff.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            staff = (Staff) in.readObject();
            in.close();
            fileIn.close();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < staffs.size(); i++) {
            System.out.println(staffs.get(i));
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
