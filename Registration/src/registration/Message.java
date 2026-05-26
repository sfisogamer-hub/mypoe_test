/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
//Thimothi Thabethe
package registration;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author sfiso
 */
public class Message {
    ArrayList<String>sentMessages = new ArrayList<>();
    private String messageId;
    private String recipient;
    private String messageText;
    private String messageHash;
    private int numMessage;
    
    public Message (int numMessage,String recipient,String messageText ){
        this.messageId = "1234567890";
        this.recipient = recipient;       
        this.messageText = messageText;
        this.messageHash = createMessageHash();      
        this.numMessage = numMessage;    
    }
    public boolean CheckMessageID(){
        return(messageId.length() == 10);
    }
    public String checkRecipientCell(){
        if (recipient.length() != 10){
            return "Invalid length";
        }
        if (recipient.charAt(0) != '0'){
            return "Must Start with 0";
        }
        if (recipient.matches("\\d{10}")){
            return "Digits only";
        }
        return "cell number captured succesfully";
    }
    public String createMessageHash(){
        String[] text = messageText.split("");
        String firstText = text[0];
        String lastText = text[text.length - 1];
        String firstTwo = messageId.substring(0,2);
        
        String hash = firstText +":"+numMessage+":"+firstText+lastText;
        return hash.toUpperCase();
    }
    public String sentMessage(int choice){
        sentMessages.add(messageText);
        if (choice == 1){
            return "Sent message succesfully sent";
        }
        if (choice == 2){
            return "Message disregarded";
        }
        if (choice == 3){
            return "Message successfully stored";
        }
        return "Invalid option";
    }
    public String printMessage(){
        return "MessageID: %s Message hash: %s Recipient:%s".formatted(messageId,messageHash,recipient,messageText);
    }      
    public int returnTotalMessage(){
        return sentMessages.size();
    }
    public void storeMessage(){
        try{
            FileWriter file = new FileWriter("message.txt",true);
            file.write("Message hash: "+messageHash+"\n");
            file.write("Message ID: "+messageId+"\n");
            file.write("Rcipient: "+recipient+"\n");
            file.write("Message: "+messageText+"\n");
            
            file.write("--------------------\n");
            file.close();
            
            System.out.println("Message stored");
        }
        catch(IOException e){
            System.out.println("Error storing message");
        }
    }
    public String validateMessageLength(){
        if (messageText.length() > 250){
            return "please enter 250 message";
        }else{
            return "Message send";
        }
    }
    public String getMessageID(){
        return messageId;
    }
    public String getMessageHash(){
        return recipient;
    }
    public String getMessageText(){
        return messageText;
    }

    public boolean checkMessageID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

