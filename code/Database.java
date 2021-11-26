import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Database   {

    private static final long serialVersionUID = 1234;

    Random rand = new Random();

    private int bookingNumber = rand.nextInt(1000);;



    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }


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

    public void editStaff() {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();

        for (Staff staff : staffArray) {
            if (staff != null && s.equalsIgnoreCase(staff.getFirstName())) {
                System.out.println("Change staff last name: ");
                staff.setLastName(scan.next());
                System.out.println(staff.getLastName());

                System.out.println("Change work title: ");
                System.out.println("Pick Your Title: ");
                System.out.println("[1][General Manager]");
                System.out.println("[2][Wait Staff]");
                System.out.println("[3][Concierge]");
                System.out.println("[4][Cleaning Staff]");
                s = scan.next();
                if ("1".equals(s)) {
                    staff.setTitle("General Manager");
                    System.out.println(staff.getTitle());
                } else if ("2".equals(s)) {
                    staff.setTitle("Wait Staff");
                    System.out.println(staff.getTitle());
                } else if ("3".equals(s)) {
                    staff.setTitle("Concierge");
                    System.out.println(staff.getTitle());
                } else if ("4".equals(s)) {
                    staff.setTitle("Cleaning Staff");
                    System.out.println(staff.getTitle());
                } else {
                    System.out.println("Please pick one of the available job titles");
                }

                int ss;
                System.out.println("");
                System.out.println("Change phone number: ");
                ss = scan.nextInt();
                staff.setTelephone(ss);
                System.out.println(staff.getTelephone());
                System.out.println("Change Salary: ");
                ss = scan.nextInt();
                staff.setSalary(ss);
                System.out.println(staff.getSalary());
                System.out.println("");
                System.out.println(staff);
            }
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
            FileInputStream fileIn = new FileInputStream("guests.ser");
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

    public void editGuest() {
        Scanner scann = new Scanner(System.in);

        System.out.println("Search for guest by first name: ");
        String guestName = scann.next();
        for (Guest guest : guests) {
            if (guest != null && guestName.equalsIgnoreCase(guest.getFirstName())) {
                System.out.println("Change first name: ");
                guest.setFirstName(scann.next());
                System.out.println(guest.getFirstName());
                System.out.println("Change last name");
                guest.setLastName(scann.next());
                System.out.println(guest.getLastName());
                System.out.println("Change Address: ");
                guest.setAddress(scann.next());
                System.out.println(guest.getAddress());
                System.out.println("Change phone number: ");
                int ss;
                ss = scann.nextInt();
                guest.setTelephone(ss);
                System.out.println(guest.getTelephone());
                System.out.println("\n" + guest);

            }
        }
    }
//    public void extendBooking(){
//        System.out.println("All current bookings:");
//        System.out.println(bookingNumber);
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Which booking would you like to extend");
//        int booking = scan.nextInt();
//
//        for (Booking room : bookings){
//            if(booking == bookingNumber){ //bookingNumber
//                System.out.println("Extend your booking by how many days");
//                int extend;
//                extend = scan.nextInt();
//
//
//                System.out.println("bleble");
//                //System.out.println(room);
//            } else{
//                System.out.println("type correct booking number");
//            }
//
//
//        }
//        //System.out.println(booking);
//    }

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
        FileOutputStream fileOut = new FileOutputStream("Room.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(roomArray);
        out.close();
        fileOut.close();

        }

    public void displayRoom() {
        try {
            FileInputStream fileIn = new FileInputStream("Room.ser");
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

    public void changeRoomPrice() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Search for room by room number: ");
        int roomNumber = scan.nextInt();
        for (Room room : roomArray) {
            if (room != null && roomNumber == room.getRoomNumber()) {
                System.out.println("Change price per night for room: ");
                int ss;
                ss = scan.nextInt();
                room.setPricePerNight(ss);
                System.out.println(room.getPricePerNight());
                System.out.println(room);

            }
        }
    }
//    public void extendBooking(){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Which booking would you like to extend");
//        System.out.println("please type booking number");
//        int booking = scan.nextInt();
//        for (Room room : roomArray){
//            if(room != null && booking == room.getBookingNumber());
//            System.out.println("Extend your booking by days");
//            int extend;
//            extend = scan.nextInt();
//            room.setBookingNumber(extend);
//            System.out.println(room.getBookingNumber());
//            System.out.println(booking);
//            System.out.println(room);
//        }
//       //  System.out.println(bookingNumber);
//
//
//   }


//    public void extendBooking(){
//
//    }

    public ArrayList<Room> getRoomArray() {
        return roomArray;
    }
}