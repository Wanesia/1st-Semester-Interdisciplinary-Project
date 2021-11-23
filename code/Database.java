import java.io.*;
import java.util.ArrayList;

public class Database {

    private static final long serialVersionUID = 1234;


    // ArrayList for StaffObjects
    ArrayList<Staff> staffArray = new ArrayList<>();
    // ArrayList for RoomObjects
    ArrayList<Room> roomArray = new ArrayList<>();
    // ArrayList for GuestObjects
    ArrayList<Guest> guests = new ArrayList<>();
    // ArrayList for Booking
    ArrayList<Booking> bookings = new ArrayList<>();

    //////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\

    public void serializeStaff() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("Staff.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(staffArray);
        out.close();
        fileOut.close();

    }

    // Display Staff
    public void displayStaff() {
        try {
            FileInputStream fileIn = new FileInputStream("Staff.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            staffArray = (ArrayList<Staff>) in.readObject();
            System.out.println(staffArray.size());
            System.out.println(staffArray);
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList getStaffArray() {
        return staffArray;
    }

    //////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\
    // Guest Method
    public void serializeGuests() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("Guests.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(guests);
        out.close();
        fileOut.close();
    }

    public void displayGuest() {
        try {
            FileInputStream fileIn = new FileInputStream("guests.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            guests = (ArrayList<Guest>) in.readObject();
            System.out.println(guests.size());
            System.out.println(guests);
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\
    // Booking Method
    public void serializeBooking() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("Bookings.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(bookings);
        out.close();
        fileOut.close();
    }



    //////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\
    // Room Method
    Room doubleBed1 = new Room(200, 2, 2, true, 300, false);
    Room doubleBed2 = new Room(201, 2, 2, true, 300, false);
    Room singleBed1 = new Room(100, 1, 1, false, 150, false);
    Room singleBed2 = new Room(101, 1, 1, false, 150, false);
    Room suite1 =new Room(300,3,3,true,500, false);
    Room suite2 =new Room(301,3,3,true,500, false);


    public void serializeRoom() throws IOException {
        FileOutputStream fileOut = new FileOutputStream("Staff.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(roomArray);
        out.close();
        fileOut.close();

        }

        public void displayRoom() {
           try {
                FileInputStream fileIn = new FileInputStream("Staff.ser");
                ObjectInputStream in = new ObjectInputStream(fileIn);
                roomArray = (ArrayList<Room>) in.readObject();
                System.out.println(roomArray.size());
                System.out.println(roomArray);
                in.close();
                fileIn.close();
           } catch (IOException | ClassNotFoundException e) {
               e.printStackTrace();
           }
        }


    public ArrayList<Room> getRoomArray() {
        return roomArray;
    }
}