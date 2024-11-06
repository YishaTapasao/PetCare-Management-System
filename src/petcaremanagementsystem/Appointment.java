package petcaremanagementsystem;

import java.util.Scanner;

public class Appointment {

    public void appointmentDetails() {
        Scanner sc = new Scanner(System.in);
        String response;
    do{
        System.out.println("\n------------------------------");
        System.out.println("APPOINMENT DETAIL");
        System.out.println("1. ADD APPOINMENT DETAIL");               
        System.out.println("2. VIEW APPOINTMENT DETAIL");        
        System.out.println("3. UPDATE APPOINMENT DETAIL");        
        System.out.println("4. DELETE APPOINTMENT DETAIL");        
        System.out.println("5. EXIT");      
        
        System.out.print("Enter Selection: ");
        int act = sc.nextInt();
        Appointment appt = new Appointment();
        
        
        switch(act){
            
            case 1:
                appt.addAppointmentDetails();
                appt.viewAppointmentDetails();

                break;
                
            case 2:
                appt.viewAppointmentDetails();
                break;
                
            case 3:

                break;
                
            case 4:
              
                break;
                
            case 5:
                
                break;
                
                
        }
        
        System.out.println("Do you want to continue? yes/no: ");
        response = sc.next();
        
    }while(response.equalsIgnoreCase("yes"));  
    }
    
    public void addAppointmentDetails(){
       Scanner sc = new Scanner(System.in);
       config conf = new config();
       
       Owner os = new Owner();
       os.viewOwnerDetails();

    
        System.out.print("Enter the ID of the Owner: ");
        int oId = sc.nextInt();
        
     String osql = "SELECT o_id FROM tbl_owner WHERE o_id = ?"; 
     while(conf.getSingleValue(osql, oId)==0){
         System.out.println("Owner does not exist, Select Again: ");
         oId = sc.nextInt();                
     }
      
       Pet pt = new Pet();
       pt.viewPetDetails();
       
        System.out.print("Enter the ID of the Pet: ");
        int pId = sc.nextInt();
        
     String psql = "SELECT p_id FROM tbl_pet WHERE p_id = ?"; 
     while(conf.getSingleValue(psql, pId)==0){
         System.out.println("Pet does not exist, Select Again: ");
         pId = sc.nextInt();                
     } 
     
        sc.nextLine();
        System.out.print("Enter Date(yyyy-mm-dd): ");
        String date = sc.nextLine();
        System.out.print("Enter Time: ");
        String time = sc.nextLine();
        System.out.print("Enter Reason: ");
        String reason = sc.nextLine();
     
    String qry = "INSERT INTO tbl_appoinment (o_id, p_id, date, time, reason) VALUES (?, ?, ?, ?, ?)";
    conf.addRecord(qry, oId, pId, date, time, reason);
    }
    
public void viewAppointmentDetails() {
    String qry = "SELECT tbl_owner.o_id, tbl_owner.o_fname, tbl_owner.o_lname, tbl_pet.p_id, tbl_pet.p_name, tbl_appointment.date, tbl_appointment.time " +
                 "FROM tbl_appointment " +
                 "LEFT JOIN tbl_owner ON tbl_owner.o_id = tbl_appointment.o_id " +
                 "LEFT JOIN tbl_pet ON tbl_pet.p_id = tbl_appointment.p_id";
    
    String[] hdrs = {"OWNER ID", "OWNER FIRST NAME", "OWNER LAST NAME0", "PET ID", "PET NAME", "APPOINTMENT DATE", "APPOINTMENT TIME"};
    String[] clms = {"o_id", "o_fname", "o_lname", "p_id", "p_name", "date", "time"};
    config conf = new config();
    conf.viewRecords(qry, hdrs, clms);
}

 
    
}