package petcaremanagementsystem;

import java.util.Scanner;

public class PetCareManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean exit = true;
    
        do{    
            System.out.println("\n------------------------------");
            System.out.println("WELCOME TO THE PETCARE CLINIC");
            System.out.println("1. OWNER");        
            System.out.println("2. PET");
            System.out.println("3. APPOINTMENT");
            System.out.println("4. REPORTS");
            System.out.println("5. EXIT");

            System.out.print("Enter Action: ");
            int action = sc.nextInt();
            
            switch(action){
                
                case 1:
                    Owner os = new Owner();
                    os.oDetails();              
                    break;
                 
                case 2:
                    Pet pt = new Pet();
                    pt.pDetails();
                    break;
                
                case 3:
                    Appointment appt = new Appointment();
                    appt.appointmentDetails(); 
                    break;

                case 4:
                    break;
                    
                case 5:
                    System.out.println("Exit Selected...type 'yes' to continue: ");
                    String resp = sc.next();
                    if(resp.equalsIgnoreCase("yes")){
                        exit = false;
                    }
                    break;
                
            }
            System.out.println("THANK YOU!!!");
            
        } while(exit);
    }
}

