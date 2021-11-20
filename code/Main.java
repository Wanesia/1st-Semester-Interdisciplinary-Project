import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

        Room room=new Room();
//        room.createRoom();
//        System.out.println(room);

        Staff staff = new Staff();
//        staff.registerStaff();
//        System.out.println(staff);

        int ss;

        do {
            Scanner input = new Scanner(System.in);
            System.out.println("What would you like to do? ");
            System.out.println("[1][Book Room]");
            System.out.println("[2][Edit Booking]");
            System.out.println("[3][Register Staff]");
            System.out.println("[4][Display Staff]");
            System.out.println("[5][Exit Program]");
            ss = input.nextInt();
            switch (ss) {
                case 1 -> {
                    room.createRoom();
                    break;
                }
                case 2 -> {
                    System.out.println("Coming Soon");
                    break;
                }
                case 3 -> {
                    staff.registerStaff();
                    break;
                }
                case 4 -> {
                    staff.displayStaff();
                    break;
                }
                case 5 -> {
                    System.exit(0);
                    break;
                }
            }

        } while (ss != 5);








    }
}