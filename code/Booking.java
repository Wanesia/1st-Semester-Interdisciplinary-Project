import java.awt.print.Book;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import java.time.temporal.ChronoUnit;


public class Booking extends Database {

    private Date startDate;
    private Date endDate;
    Room room;
    Guest guest;
    //    ArrayList<Booking> bookings =new ArrayList<Booking>();

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Booking() {

    }

    public Booking(Date startDate, Date endDate, Guest guest, Room room) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.guest = guest;
        this.room = room;
    }
    public Booking bookRoom(ArrayList<Room> roomList, ArrayList<Guest> guestList) throws ParseException {

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
        System.out.println("Enter start date: (day/month/year)");
        String s0 = scan.next();
        String sDate = s0;
        Date date1 = new SimpleDateFormat("dd/MM/yy").parse(sDate);
        this.startDate=date1;


        System.out.println("Enter end date: (day/month/year)");
        String s1 = scan.next();
        String s1Date = s1;
        Date date2=new SimpleDateFormat("dd/MM/yy").parse(s1Date);
        this.endDate=date2;


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
