import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Room extends Guest implements Serializable {
    private int roomNumber;
    private int floor;
    private int numberOfBed;
    private boolean internet;
    private double pricePerNight;
    private boolean booked = false;
//    ArrayList<Room> rooms=new ArrayList<Room>();

    public Room(int roomNumber, int floor, int numberOfBed, boolean internet, double pricePerNight, boolean booked) {
        this.roomNumber = roomNumber;
        this.floor = floor;
        this.numberOfBed = numberOfBed;
        this.internet = internet;
        this.pricePerNight = pricePerNight;
        this.booked = booked;
    }


    boolean isBooked()
    {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String toString() {
        return "\nRoom" + "\n" + "Roomnumber: " + roomNumber +
                "\nFloor: " + floor +
                "\nNumber Of Beds: " + numberOfBed +
                "\nInternet: " + internet +
                "\nPrice Per Night: " + pricePerNight + "DKK" +
                "\nCurrently booked: " + booked +
                "\n";
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
