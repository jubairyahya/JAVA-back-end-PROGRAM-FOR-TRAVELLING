import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class TravelMain3 {
    public static void main(String[] args) {
        
            Travel[] ticket = new Travel[2]; // This array will bring two objectss from class travel
            Booking[] accom = new Booking[2];// This array will bring two objectss from class booking

            // j frame which display the the below heading 
            JFrame frame = new JFrame("Travel Booking System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 500);

            JPanel panel = new JPanel();
            frame.add(panel);
            placeComponents(panel, ticket, accom);
            
            frame.setVisible(true);
        
    }
// placecomponents method which passes the parameters inside and using it for buttons 
    private static void placeComponents(JPanel panel, Travel[] ticket, Booking[] accom) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Travel Booking System");
        titleLabel.setBounds(180, 10, 200, 50);
        panel.add(titleLabel);

        JButton inputDetailsButton = new JButton("Input Travelling Details");
        inputDetailsButton.setBounds(50, 50, 200, 25);
        panel.add(inputDetailsButton);

        JButton searchDestinationButton = new JButton("Search for Destination");
        searchDestinationButton.setBounds(50, 90, 200, 25);
        panel.add(searchDestinationButton);

        JButton accommodationBookingButton = new JButton("Accommodation Booking Details");
        accommodationBookingButton.setBounds(50, 130, 250, 25);
        panel.add(accommodationBookingButton);

        JButton bubbleSortButton = new JButton("Bubble Sort Travel");
        bubbleSortButton.setBounds(50, 170, 150, 25);
        panel.add(bubbleSortButton);

        JButton writeInputButton = new JButton("Write to File");
        writeInputButton.setBounds(50, 210, 150, 25);
        panel.add(writeInputButton);

        JButton readAndDisplayButton = new JButton("Read and Display File Content");
        readAndDisplayButton.setBounds(50, 250, 250, 25);
        panel.add(readAndDisplayButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(50, 290, 100, 25);
        panel.add(exitButton);

        inputDetailsButton.addActionListener(e -> inputTravelDetails(ticket));
        searchDestinationButton.addActionListener(e -> searchDestination(ticket));
        accommodationBookingButton.addActionListener(e -> accommodationBooking(accom));
        bubbleSortButton.addActionListener(e -> {
            bubbleSortTravel(ticket);
            System.out.println("Sorted Travel Details based on Age:");
            for (Travel t : ticket) {
                System.out.println(t);
            }
        });
        writeInputButton.addActionListener(e -> writeinput());
        readAndDisplayButton.addActionListener(e -> readAndDisplayFileContent());
        exitButton.addActionListener(e -> System.exit(0));
    }
    public static void inputTravelDetails(Travel[] ticket) {
        System.out.println(" welcome to the world of travelling and you can see the price here"); // printing the introduction
        JOptionPane.showMessageDialog(null, " ZU Travelling "); // message dialog prompt

        // introduce for loop here
        for (int i = 0; i < 2; i++) {

            System.out.println(" enter the details of traveller  " + (i + 1));
            String mde = JOptionPane.showInputDialog(" enter the mode of transport (flight,bus,train) ");
            int ag = Integer.parseInt(JOptionPane.showInputDialog(" enter the age "));
            String frmc = JOptionPane.showInputDialog(" enter the city from you are travelling from ");
            String des = JOptionPane.showInputDialog(" enter the destination (london, paris, Oslo) ");
            String dateInput = JOptionPane.showInputDialog("Enter the travel date (YYYY-MM-DD): ");
            LocalDate trd = LocalDate.parse(dateInput);
            ticket[i] = new Travel(mde, ag, des, frmc, trd);// calling an class for user contructor
            ticket[i].printTravel(); // print the object in the class Travel
            if (ticket[i].mode.equals("flight") && ticket[i].age >= 18) {
                if (ticket[i].destination.equals("london")) {
                    System.out.println(trd + " " + "Price for an adult to London by flight is $100");
                } else if (ticket[i].destination.equals("paris")) {
                    System.out.println(trd + " " + "Price for an adult to Paris by flight is $150");
                } else if (ticket[i].destination.equals("oslo")) {
                    System.out.println(trd + " " + "Price for an adult to Oslo by flight is $200");
                }
            } else if (ticket[i].mode.equals("flight") && ticket[i].age < 18) {
                if (ticket[i].destination.equals("london")) {
                    System.out.println(trd + " " + "Price for a child to London by flight is $90");
                } else if (ticket[i].destination.equals("paris")) {
                    System.out.println(trd + " " + "Price for a child to Paris by flight is $130");
                } else if (ticket[i].destination.equals("oslo")) {
                    System.out.println(trd + " " + "Price for a child to Oslo by flight is $180");
                }
            } else if (ticket[i].mode.equals("bus") && ticket[i].age >= 18) {
                if (ticket[i].destination.equals("london")) {
                    System.out.println(trd + " " + "Price for an adult to London by bus is $30");
                } else if (ticket[i].destination.equals("paris")) {
                    System.out.println(trd + " " + "Price for an adult to Paris by bus is $50");
                } else if (ticket[i].destination.equals("oslo")) {
                    System.out.println(trd + " " + "Price for an adult to Oslo by bus is $70");
                }
            } else if (ticket[i].mode.equals("bus") && ticket[i].age < 18) {
                if (ticket[i].destination.equals("london")) {
                    System.out.println(trd + " " + "Price for a child to London by bus is $20");
                } else if (ticket[i].destination.equals("paris")) {
                    System.out.println(trd + " " + "Price for a child to Paris by bus is $40");
                } else if (ticket[i].destination.equals("oslo")) {
                    System.out.println(trd + " " + "Price for a child to Oslo by bus is $60");
                }
            } else if (ticket[i].mode.equals("train") && ticket[i].age >= 18) {
                if (ticket[i].destination.equals("london")) {
                    System.out.println(trd + " " + "Price for an adult to London by train is $70");
                } else if (ticket[i].destination.equals("paris")) {
                    System.out.println(trd + " " + "Price for an adult to Paris by train is $100");
                } else if (ticket[i].destination.equals("oslo")) {
                    System.out.println(trd + " " + "Price for an adult to Oslo by train is $130");
                }
            } else if (ticket[i].mode.equals("train") && ticket[i].age < 18) {
                if (ticket[i].destination.equals("london")) {
                    System.out.println(trd + " " + "Price for a child to London by train is $50");
                } else if (ticket[i].destination.equals("paris")) {
                    System.out.println(trd + " " + "Price for a child to Paris by train is $80");
                } else if (ticket[i].destination.equals("oslo")) {
                    System.out.println(trd + " " + "Price for a child to Oslo by train is $110");
                }
            } else {
                System.out.println("No specific pricing available for the provided details.");
            } // end of if

        } // end of for loop

    }

    // end of while loop
    public static void searchDestination(Travel[] ticket) {
        String str = JOptionPane.showInputDialog("What destination do you wish to search for?");
        Travel a = linearSearch(ticket, str);
        if (a == null) {
            System.out.println("Record not found");
        } else {
            System.out.println("Following is the first record to match:\n");
            a.printTravel();
        }

    }// end of travel serach method

    public static void bubbleSortTravel(Travel[] ticket) {
        int n = ticket.length;
        Travel temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ticket[j].getAge() > ticket[j + 1].getAge()) {
                    // swap the elements
                    temp = ticket[j];
                    ticket[j] = ticket[j + 1];
                    ticket[j + 1] = temp;
                    

                }
            }
        }
    }

    public static void accommodationBooking(Booking[] accom) {

        System.out.println("You can find a lot of options for your stay");
        JOptionPane.showMessageDialog(null, "ZU Accommodation");

        // introduce for loop here

        for (int x = 0; x < 2; x++) {
            System.out.println(" enter the details for your accomodation  " + (x + 1));
            String typ = JOptionPane.showInputDialog(" enter the type of accomodation(hotel, hostel, apartment)");
            int per = Integer.parseInt(JOptionPane.showInputDialog(" number of persons (1 person)"));
            int dys = Integer.parseInt(JOptionPane.showInputDialog("number of days (1 to 7 days)"));
            accom[x] = new Booking(typ, per, dys);
            // introduce the switch statement here
            switch (accom[x].type) {
                case "hotel":
                    switch (accom[x].days) {
                        case 1:
                            System.out.println("Hotel price for One day per person is $30");
                            break;
                        case 2:
                            System.out.println("Hotel price for Two days per person is $55");
                            break;
                        case 3:
                            System.out.println("Hotel price for Three days per person is $80");
                            break;
                        case 4:
                            System.out.println("Hotel price for Four days per person is $100");
                            break;
                        case 5:
                            System.out.println("Hotel price for Five days per person is $120");
                            break;
                        case 6:
                            System.out.println("Hotel price for Six days per person is $140");
                            break;
                        case 7:
                            System.out.println("Hotel price for Seven days per person is $160");
                            break;
                        default:
                            System.out.println("No specific pricing available for the provided number of days.");
                            break;
                    }
                    break;

                case "hostel":
                    switch (accom[x].days) {
                        case 1:
                            System.out.println("Hostel price for One day per person is $10");
                            break;
                        case 2:
                            System.out.println("Hostel price for Two days per person is $20");
                            break;
                        case 3:
                            System.out.println("Hostel price for Three days per person is $30");
                            break;
                        case 4:
                            System.out.println("Hostel price for Four days per person is $40");
                            break;
                        case 5:
                            System.out.println("Hostel price for Five days per person is $50");
                            break;
                        case 6:
                            System.out.println("Hostel price for Six days per person is $60");
                            break;
                        case 7:
                            System.out.println("Hostel price for Seven days per person is $70");
                            break;
                        default:
                            System.out.println("No specific pricing available for the provided number of days.");
                            break;
                    }
                    break;

                case "apartment":
                    switch (accom[x].days) {
                        case 1:
                            System.out.println("Apartment price for One day per person is $10");
                            break;
                        case 2:
                            System.out.println("Apartment price for Two days per person is $20");  
                                                                                                  // discount for multiple days
                            break;
                        case 3:
                            System.out.println("Apartment price for Three days per person is $30"); 
                                                                                                    //  discountfor multiple days
                            break;
                        case 4:
                            System.out.println("Apartment price for Four days per person is $40"); 
                                                                                                  
                            break;
                        case 5:
                            System.out.println("Apartment price for Five days per person is $50"); 
                                                                                                   
                            break;
                        case 6:
                            System.out.println("Apartment price for Six days per person is $60"); 
                                                                                                  
                            break;
                        case 7:
                            System.out.println("Apartment price for Seven days per person is $70"); 
                                                                                                    
                            break;
                        default:
                            System.out.println("No specific pricing available for the provided number of days.");
                            break;
                    }
                    break;
                default:
                    System.out.println("No specific pricing available for the provided details.");
                    break;
            } // end of Switch statement
            accom[x].printBooking(); // printing in the class Booking

        } // end of for loop

        // end of while loop
    } // end of method accomodtaion
// writing in a file 
    public static void writeinput() {
        try {

            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("C:\\Users\\surface\\OneDrive\\Desktop\\Java\\Main project\\test\\output.txt"));
            String input = JOptionPane.showInputDialog("Enter content to write to file:");

            bw.write(input);
            bw.close();
            JOptionPane.showMessageDialog(null, "Content written to file successfully!");

            bw.close();
        } catch (IOException ex) {
            return;

        } // close exception
    } //closing method writeinput
// reading in a file 
    public static void readAndDisplayFileContent() {
        try (BufferedReader br = new BufferedReader(
                new FileReader("C:\\Users\\surface\\OneDrive\\Desktop\\Java\\Main project\\test\\output.txt"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }

            JOptionPane.showMessageDialog(null, "The following was stored in the file:\n" + content.toString());
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static Travel linearSearch(Travel data[], String key) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].getdestination().equals(key)) {
                return data[i];
            }
        }
        return null;
    }  // closing method linear search and it returns the printing statemnet in above main method for destination

    // ========================

}// end class
