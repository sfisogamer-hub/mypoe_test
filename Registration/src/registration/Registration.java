/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//Thimothi Thabethe
package registration;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sfiso
 */
public class Registration {
    
    /**
     * @param args the command line arguments
     */
    //Scanner input = new Scanner(System.in);
        //Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //ArrayList<String> sentMessage = new ArrayList<>();
        ArrayList<Message> sentMessages = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        Login log = new Login();
           
        
        System.out.println("Welcome to chart \n Enter 1 , 2 or 3 to select your choice");
       int choice;
        
        do{
            
        System.out.println("1:Registraction");
        System.out.println("2:Login");
        System.out.println("3:Exit");
        
        System.out.print("Enter a number to select your choice: ");
        choice = input.nextInt();
        input.nextLine();
        
        if (choice == 1){
            System.out.println("===Register===");
            
            System.out.print("Enter first name: ");
            String firstName = input.nextLine();
            
            System.out.print("Enter last name: ");
            String lastName = input.nextLine();
            
            System.out.print("Enter your username: ");
            String userName = input.nextLine();
            if (log.checkUserName(userName)){
                System.out.println("Username successfully captured");
            }else{
                System.out.println("Username is not correctly formatted;please ensure that your username contains an underscore and is no more than five characters in length");
            }
            
            System.out.print("Enter your password: ");
            String password = input.nextLine();
            if(log.checkPasswordComplexity(password)){
                System.out.println("Password successfully captured");
            }else{
                System.out.println("Password is not correctly formatted;please ensure that the password contains at least eight characters a capital letter,a number,and a special character");
            }
            
            
            System.out.print("Enter your number phone: +27 ");
            String number = input.nextLine();
            if(log.checkCellPhoneNumber(number)){
                System.out.println("cell phone number successfully added");
            }else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code");
            }
            
            String result = log.registerUser(userName,password,number,firstName,lastName);
            System.out.println(result);
            
            System.out.println("Registraction successfull");
        }
        else if (choice == 2){
            System.out.println("\n===login===");
        
            System.out.print("Enter your username: ");
            String userName = input.nextLine();
        
            System.out.print("Enter your password: ");
            String password = input.nextLine();
            boolean status = log.loginUser(userName, password);
                String mess = log.returnLoginStatus(status);
                System.out.println(mess);
                System.out.println("\nWelcome to Quick chat");
                        
                System.out.print("\nHow many messages would you like to send? ");
                int messages = input.nextInt();
                input.nextLine();
                for (int t = 1; t <= messages;t++){ 
                    System.out.print("\nEnter recipient number: ");
                    String recipient = input.nextLine();
                            
                    System.out.print("Enter your message: ");
                    String text = input.nextLine();
                            
                    Message msg = new Message(t,recipient,text);
                            
                    System.out.println(msg.checkRecipientCell());
                    System.out.println(msg.validateMessageLength());
                            
                    System.out.println("\n1.Send Message: ");
                    System.out.println("2.Show recently sent message: ");
                    System.out.println("3.Quit: "); 
                            
                    System.out.print("\nEnter a number to select your choice: ");
                    choice = input.nextInt();
                    input.nextLine();
                    System.out.println(msg.sentMessage(choice));
                    if(choice == 1){
                        sentMessages.add(msg);
                        System.out.print("Message successfully sent");
                        System.out.println(msg.printMessage());
                    }
                    else if (choice == 2){
                        if (sentMessages.size()== 0){
                            System.out.println("No messages sent");
                        }
                        else {
                            System.out.println("\nRecently sent messages");
                            for(Message m: sentMessages){
                                System.out.println(m.printMessage());
                            }
                        }
                    }
                    else if (choice == 3 ){
                        System.out.println("Exiting message menu");
                        break; 
                    }else{
                        System.out.print("Invalid option");
                    }
                }
                System.out.println("\nTotal messages sent: "+sentMessages.size());
            }
        
        }while (choice != 3);
            System.out.println("Thanks for using our program");
    }
        
}

