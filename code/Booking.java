import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Booking extends Database {

    private Date startDate;
    private Date endDate;
    Room room;
    Guest guest;


    public Booking() {

    }

    public Booking(Date startDate, Date endDate, Guest guest, Room room) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.guest = guest;
        this.room = room;
    }

    public Booking bookRoom(ArrayList<Room> roomList, ArrayList<Guest> guestList) {

        System.out.println("Which room would you like to book?");
        Scanner scan = new Scanner(System.in);
        System.out.println("Please type in the room number: ");
        int roomNumber = scan.nextInt();
        for (Room room : roomArray) {
            if (room != null && roomNumber == room.getRoomNumber()) {

                this.room = room;
                room.setBooked(true);
            }

        }

        System.out.println("Who is booking the room?");
        String ss = scan.next();
        for (Guest guest : guestList) {
            if (ss.equals(guest.getFirstName())) {
                this.guest = guest;
            }

        }



        System.out.println(this);
        return this;

    }


    Random rand = new Random(); //instance of random class


    @Override
    public String toString() {
        return "Booking#" + rand.nextInt() +
                "\nStart Date: " + startDate +
                "\nEnd Date: " + endDate +
                "\nRoom: " + room +
                "\nGuest: " + guest;
    }

}
