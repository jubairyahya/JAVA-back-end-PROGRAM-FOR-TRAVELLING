import java.time.LocalDate;
// plan is a super class which extends in other two classes
public class Plan {
    String from_city;
    LocalDate travel_date;
    
    public Plan(String frmc,LocalDate trd)
    {
    from_city=frmc;
    travel_date=trd;

    } // user constructor
}
