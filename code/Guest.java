import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class Guest   implements Serializable   {
    private String firstName;
    private String lastName;
    private String address;
    private int telephone;
//    ArrayList<Guest>guests=new ArrayList<>();
    
    public Guest createGuest() {
        //Guest guest = new Guest();
        Scanner scanner = new Scanner(System.in);
        System.out.println("First name: ");

        while (!scanner.hasNext("[A-Za-z]+")) {
            System.out.println("Please input only letters");
            firstName = scanner.nextLine();
        }
        scanner.nextLine();
        System.out.println("Last name: ");

        while (!scanner.hasNext("[A-Za-z]+")) {
            //  lastName = scanner.nextLine();
            System.out.println("Please input only letters");
            lastName = scanner.nextLine();
        }
            scanner.nextLine();
            System.out.println("Address: ");
            address = scanner.nextLine();

//            scanner.nextInt();
        System.out.println("Telephone: ");
// to do
//        while(!scanner.hasNextInt()) {
//            System.out.println("Enter only numbers");
//            telephone = scanner.nextInt();
//        }
        return this;
    }
//    try{
//        FileInputStream f =new FileInputStream("guests.bin");
//        ObjectInputStream o = new ObjectInputStream(f);
//        guests=(ArrayList<Guest>)o.readObject();
//
//    } catch (FileNotFoundException e) {
//        e.printStackTrace();
//    } catch (IOException e) {
//        e.printStackTrace();
//    } catch (ClassNotFoundException e) {
//        e.printStackTrace();
//    }
    //guests.add(guest);

//    try {
//   FileOutputStream f = new FileOutputStream("guest.bin");
//   ObjectOutputStream o = new ObjectOutputStream(f);
//   o.writeObject(guests);
//    }
//    catch (IOException e) {
//        e.printStackTrace();
//    }


    @Override
    public String toString() {
        return "\n" +
                "First name: " + firstName + "\n" +
                "Last name: " + lastName + "\n" +
                "Address: " + address + "\n" +
                "Telephone: " + telephone + "\n";
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return int return the telephone
     */
    public int getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }




}
