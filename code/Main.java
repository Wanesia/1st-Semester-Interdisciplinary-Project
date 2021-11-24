import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {


        Booking booking = new Booking();
        Database database = new Database();
        //Add rooms to roomArray
        database.roomArray.add(database.singleBed1);
        database.roomArray.add(database.singleBed2);
        database.roomArray.add(database.doubleBed1);
        database.roomArray.add(database.doubleBed2);
        database.roomArray.add(database.suite1);
        database.roomArray.add(database.suite2);
        database.serializeRoom();


        // Create Staff: 1 General Manager, 1 Receptionist, 1 Cleaning Lady
        //               1 Accountant
        Staff s = new Staff();

        // Create Guests: 8 Guests
        Guest guest = new Guest();

        int ss;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("What would you like to do? ");
            System.out.println("[1][Book Room]");
            System.out.println("[2][Change Price Per Night]");
            System.out.println("[3][Edit Booking]");
            System.out.println("[4][Edit guest info]");
            System.out.println("[5][Register Staff]");
            System.out.println("[6][Edit Staff]");
            System.out.println("[7][Exit Program]");
            ss = input.nextInt();
            switch (ss) {
                case 1 : {
                    System.out.println("Register Guest: ");
                    guest.createGuest();
                    database.guests.add(guest);
                    database.serializeGuests();
                    //database.displayRoom();
                    //booking.bookRoom(database.roomArray, database.guests);
                    //database.bookings.add(booking);
                    break;
                }
                case 2 : {
                    //database.displayRoom();
                    database.changeRoomPrice();
                    break;
                }
                case 3 : {
                    System.out.println("Coming Soon");
                    break;
                }
                case 4 : {
                    database.displayGuest();
                    database.editGuest();
                    database.serializeGuests();
                    database.displayGuest();
                    break;
                }
                case 5 : {
                    s = s.registerStaff();
                    database.staffArray.add(s);
                    database.serializeStaff();
                    break;
                }
                case 6 : {
                    database.displayStaff();
                    System.out.println("Search for staff by first name: ");
                    database.editStaff();
                    database.serializeStaff();
                    break;
                }
                case 7 : {
                    System.exit(0);
                    break;
                }
            }

        } while (ss != 7);


    }


}