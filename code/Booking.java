import java.awt.print.Book;
import java.io.Serializable;
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


public class Booking implements Serializable {

    private String startDate;
    private String endDate;
    Room room;
    Guest guest;
    long daysBetween;

    Random rand = new Random();

    private int bookingNumber = rand.nextInt(1000);;
    private LocalDate startDateLD;


    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }
        //ArrayList<Booking> bookings =new ArrayList<Booking>();

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Booking() {

    }

    public Booking(String startDate, String endDate, Guest guest, Room room, long daysBetween) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.guest = guest;
        this.room = room;
        this.daysBetween = daysBetween;
    }

     //  Booking booking = new Booking();
    public Booking bookRoom(ArrayList<Room> roomList, ArrayList<Guest> guestList) throws ParseException {

        System.out.println("Which room would you like to book?");
        Scanner scan = new Scanner(System.in);
        System.out.println("Please type in the room number: ");
        int roomNumber = scan.nextInt();
        for (Room room : roomList) {
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
//        System.out.println("Enter start date: (day/month/year)");
//        String s0 = scan.next();
//        String sDate = s0;
//        Date date1 = new SimpleDateFormat("dd/MM/yy").parse(sDate);
//        this.startDate=date1;
//
//
//        System.out.println("Enter end date: (day/month/year)");
//        String s1 = scan.next();
//        String s1Date = s1;
//        Date date2=new SimpleDateFormat("dd/MM/yy").parse(s1Date);
//        this.endDate=date2;

        System.out.println("Enter start date");
        System.out.println("Enter start year: ");
        int d1 = scan.nextInt();
        System.out.println("Enter month: ");
        int d2 = scan.nextInt();
        System.out.println("Enter day: ");
        int d3 = scan.nextInt();
        LocalDate ld1 = LocalDate.of(d1, d2, d3);
        this.setStartDateLD(ld1);

        String date4 = d1 + ", " + d2 + ", " + d3;

        System.out.println("Enter end date");
        System.out.println("Enter year: ");
        d1 = scan.nextInt();
        System.out.println("Enter month: ");
        d2 = scan.nextInt();
        System.out.println("Enter day: ");
        d3 = scan.nextInt();
        LocalDate ld2 = LocalDate.of(d1, d2, d3);

        String date5 = d1 + ", " + d2 + ", " + d3;


        this.setStartDate(date4);
        this.setEndDate(date5);

        System.out.println("Number of nights: ");
        daysBetween = ChronoUnit.DAYS.between(ld1, ld2);
        System.out.println(Math.abs(daysBetween));


        System.out.println(receipt());
        return this;
    }

    private void setStartDateLD(LocalDate ld1) {
        this.startDateLD = ld1;
    }
    public LocalDate getStartDateLD(){
        return this.startDateLD;
    }
    // int bookingNumber = rand.nextInt(1000);

    public void extendBooking() {
        Scanner scan = new Scanner(System.in);
        //System.out.println("All current bookings:");
        //System.out.println(bookingNumber);
        System.out.println("Which booking would you like to extend");
        int booking = scan.nextInt();

if(booking == bookingNumber) {
    System.out.println("Enter end date");
    System.out.println("Enter year: ");
    int d1 = scan.nextInt();
    System.out.println("Enter month: ");
    int d2 = scan.nextInt();
    System.out.println("Enter day: ");
    int d3 = scan.nextInt();
    LocalDate ld2 = LocalDate.of(d1, d2, d3);

    String date5 = d1 + ", " + d2 + ", " + d3;

    this.setEndDate(date5);
    daysBetween = ChronoUnit.DAYS.between(this.getStartDateLD(), ld2);

    System.out.println("New number of nights is " + Math.abs(daysBetween) + " extended booking starts at " + startDate + " extended booking finishes at " +  endDate);
} else {
    System.out.println("insert correct booking number");
}

    }


    public String receipt() {
        System.out.println("      RECEIPT               ");
        System.out.println("      -------               ");
        System.out.println("  Receipt#" + bookingNumber +"                   ");
        System.out.println("  Receipt Date "+endDate+"                   ");
        System.out.println("______________________________                     ");
        System.out.println("  Booked by                   ");
        System.out.println("  "+guest+"                   ");
        System.out.println("______________________________                     ");
        System.out.println("  Description                   ");
        System.out.println("  "+room+"                   ");
        System.out.println("  Number of nights "+daysBetween+"                           ");
        System.out.println("______________________________                     ");
        System.out.println("Grand total                 "+daysBetween*room.getPricePerNight()+"DKK          ");

        return "";
    }

    @Override
    public String toString() {
        return "Booking#" +  bookingNumber +
                "\nNumber of nights: " +daysBetween+
                "\nStart Date: " + startDate +
                "\nEnd Date: " + endDate +
                "\nRoom: " + room +
                "\nGuest: " + guest;
    }

}