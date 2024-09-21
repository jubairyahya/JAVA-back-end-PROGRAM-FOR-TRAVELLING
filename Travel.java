import java.time.LocalDate;

class Travel extends Plan { 
    String mode;
    int age;
    String destination;

    // default constructor

public Travel ()
{
    super("", LocalDate.now());
    mode= " enter the mode of transport " ;
    age=0;
    destination=" enter the destination";
} // end default 

// user constructor

public Travel(String mde, int ag, String des, String from_city, LocalDate travel_date)
{
    super(from_city, travel_date);
    mode=mde;
    age=ag;
    destination=des;
} // end User Travel
// print in class Travel
public String getdestination() {
    return destination; 
}
public int getAge(){
    return age;
}
@Override
public String toString() {
    return "Mode: " + mode + ", Age: " + age + ", Destination: " + destination ; 
}
public void printTravel()
 {
System.out.println("travel details :\n"+" mode of transport :" +mode+"\n"+"passenger age:"+ age+"\n"+ super.from_city+"\n"+"Destination of travelling:"+ destination+"\n"+super.travel_date );

} // print methos in class Travel

} // end class travel
