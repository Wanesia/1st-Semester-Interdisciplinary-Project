import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Room extends Guest implements Serializable {
    private int roomNumber;
    private int floor;
    private int numberOfBed;
    private boolean internet;
    private double pricePerNight;
    ArrayList<Room> rooms=new ArrayList<Room>();

    public void createRoom() {
        Room room = new Room();
        Scanner scan = new Scanner(System.in);
        System.out.print("Room number:");
        roomNumber=scan.nextInt();
        System.out.print("Floor");
        floor=scan.nextInt();
        System.out.print("Number of");
        numberOfBed=scan.nextInt();
        System.out.print("Internet access(true/false)");
        internet=scan.nextBoolean();
        System.out.print("Price per night: ");
        pricePerNight=scan.nextDouble();
        System.out.println("Room created successfully");
        try{
            FileInputStream f = new FileInputStream("rooms.bin");
            ObjectInputStream ois = new ObjectInputStream(f);
            rooms=(ArrayList<Room>)ois.readObject();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        rooms.add(room);
        try{
            FileOutputStream f = new FileOutputStream("rooms.bin");
            ObjectOutputStream out = new ObjectOutputStream(f);
            out.writeObject(rooms);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }
    public String toString() {
        return "Room "+roomNumber+" floor "+floor;
    }
    /**
     * @return int return the roomNumber
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * @param roomNumber the roomNumber to set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * @return int return the floor
     */
    public int getFloor() {
        return floor;
    }

    /**
     * @param floor the floor to set
     */
    public void setFloor(int floor) {
        this.floor = floor;
    }

    /**
     * @return int return the numberOfBed
     */
    public int getNumberOfBed() {
        return numberOfBed;
    }

    /**
     * @param numberOfBed the numberOfBed to set
     */
    public void setNumberOfBed(int numberOfBed) {
        this.numberOfBed = numberOfBed;
    }

    /**
     * @return boolean return the internet
     */
    public boolean isInternet() {
        return internet;
    }

    /**
     * @param internet the internet to set
     */
    public void setInternet(boolean internet) {
        this.internet = internet;
    }


    /**
     * @return double return the pricePerNight
     */
    public double getPricePerNight() {
        return pricePerNight;
    }

    /**
     * @param pricePerNight the pricePerNight to set
     */
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

}
