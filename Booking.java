class Booking {
    String type;
    int person;
    int days;

    // default constructor
    public Booking() {
        type = "enter the type of accomodation";
        person = 0;
        days = 0;
    }// end default
     // user contructor wher user can put the values to get the price

    public Booking(String typ, int per, int dys) {
        type = typ;
        person = per;
        days = dys;
    } // end the user constructor 
    // printing the object in class booking
public void printBooking()
{
    System.out.println("booking :" + type+person+days);
    
} // end print in Class Booking 
}
