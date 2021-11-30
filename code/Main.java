import com.sun.security.jgss.GSSUtil;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.temporal.*;
import java.time.temporal.ChronoUnit;

public class  Main{
    public static void main(String[] args) throws IOException, ParseException, ClassNotFoundException {

        Booking booking = new Booking();
        Database database = new Database();
        //Add rooms to roomArray
        database.roomArray.add(database.singleBed1);
        database.roomArray.add(database.singleBed2);
        database.roomArray.add(database.doubleBed1);
        database.roomArray.add(database.doubleBed2);
        database.roomArray.add(database.suite1);
        database.roomArray.add(database.suite2);
//        database.serializeRoom();

        Room r = new Room();
        //database.serializeRoom();

        // Create Staff: 1 General Manager, 1 Receptionist, 1 Cleaning Lady
        //               1 Accountant
        Staff s = new Staff();

        // Create Guests: 8 Guests
        Guest guest = new Guest();

        int ss;
        System.out.println("__________________________________________________________________________________");
        System.out.println("|  _    _  ____ _______ ______ _          _____  _               ______           |");
        System.out.println("| | |  | |/ __ |__   __|  ____| |        |  __ \\| |        /\\   |___  /   /\\      |");
        System.out.println("| | |__| | |  | | | |  | |__  | |        | |__) | |       /  \\     / /   /  \\     |");
        System.out.println("| |  __  | |  | | | |  |  __| | |        |  ___/| |      / /\\ \\   / /   / /\\ \\    |");
        System.out.println("| | |  | | |__| | | |  | |____| |____    | |    | |____ / ____ \\ / /__ / ____ \\   |");
        System.out.println("| |_|  |_|\\____/  |_|  |______|______|   |_|    |______/_/    \\_/_____/_/    \\_\\  |");
        System.out.println("|_________________________________________________________________________________|");
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("What would you like to do? ");
            System.out.println("[1][Book Room]");
            System.out.println("[2][Create Room]");
            System.out.println("[3][Change Price Per Night]");
            System.out.println("[4][Edit Booking]");
            System.out.println("[5][Edit guest info]");
            System.out.println("[6][Register Staff]");
            System.out.println("[7][Edit Staff]");
            System.out.println("[8][Exit Program]");
            ss = input.nextInt();
            switch (ss) {
                case 1 : {
                    System.out.println("Register Guest: ");
                    guest.createGuest();
                    database.guests.add(guest);
                    database.serializeGuests();

                    database.displayRoom();
                    booking.bookRoom(database.roomArray, database.guests);
                    database.bookings.add(booking);
                    database.serializeBooking();
                    break;
                }
                case 2 : {
                    System.out.println("Create New Room: ");
                    r = r.createRoom();
                    database.roomArray.add(r);
                    database.serializeRoom();
                    database.displayRoom();
                    break;
                }
                case 3 : {
                    database.displayRoom();
                    database.changeRoomPrice();
                    break;
                }
                case 4 : {
                    System.out.println("All current bookings:");
                    database.displayBooking();
                    booking.extendBooking();
                    database.serializeBooking();
                    database.displayBooking();
                    booking.receipt();

                    break;
                }
                case 5 : {
                    database.displayGuest();
                    database.editGuest();
                    database.serializeGuests();
                    database.displayGuest();
                    break;
                }
                case 6 : {
                    s = s.registerStaff();
                    database.staffArray.add(s);
                    database.serializeStaff();
                    break;
                }
                case 7 : {
                    database.displayStaff();
                    System.out.println("Search for staff by first name: ");
                    database.editStaff();
                    database.serializeStaff();
                    break;
                }
                case 8 : {
                    System.exit(0);
                    break;
                }
            }

        } while (ss != 8);


    }


}