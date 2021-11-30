import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.InputMismatchException;
public class Guest  implements Serializable {
    private static final long serialVersionUID = -3971986109222559602L;
    private String firstName;
    private String lastName;
    private String address;
    private String telephone;
//    ArrayList<Guest>guests=new ArrayList<>();
    public Guest createGuest() {
        //Guest guest = new Guest();
        Scanner scanner = new Scanner(System.in);

        System.out.println("First name: ");
        String input = scanner.nextLine();
        while (!input.matches("[A-Za-z]+")) {
            System.out.println("Please input only letters");
            input = scanner.nextLine();
        }
        firstName = input;

        System.out.println("Last name: ");
        String input1=scanner.nextLine();

            while (!input1.matches("[A-Za-z]+")) {
            System.out.println("Please input only letters");
            input1=scanner.nextLine();
        }
        lastName = input1;
       // scanner.nextLine();

        System.out.println("Address: ");
        address = scanner.nextLine();

        System.out.println("Telephone: ");
        String input2 = scanner.nextLine();
        while (input2.matches("[A-Za-z]+")) {
            System.out.println("Please input only numbers");
            input2 = scanner.nextLine();
        }
        telephone=input2;
//        while (!input1== ) {
//            System.out.println("Enter only numbers");
//            telephone=scanner.nextInt();
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
    public String getTelephone() {
        return telephone;
    }

    /**
     * @param telephone the telephone to set
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }




}
