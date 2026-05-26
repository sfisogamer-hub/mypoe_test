/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import registration.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author sfiso
 */
public class MessageUnit {
    
   @Test
   public void testMessageIDSuccess(){
       Message msg = new Message(1,"0728533779","Hi sfiso, to quick chart");
       //assertTrue(msg.checkMessageID());
   }
   @Test
   public void testRecipientCellSuccess(){
       Message msg = new Message(1,"0728532779","Hello");
       String expected = "Cell phone sucessfully captured ";
       
       String actual = msg.checkRecipientCell();
       assertEquals(expected,actual);
   }
   @Test
   public void testRecipientCellFailure(){
       Message msg = new Message(1,"0728532779","Hello");
       String expected = "Cell phone number is incorrectly formatted";
       String actual = msg.checkRecipientCell();
       assertEquals(expected,actual);
   }
   @Test
   public void testSendMessageOption1(){
       Message msg = new Message(1,"0728532779","Hello");
       String expected = "Message succesfully sent";
       String actual = msg.sentMessage(1);
       assertEquals(expected,actual);
       
   }
   @Test
   public void testSendMessageOption2(){
       Message msg = new Message(1,"0728532779","Hello");
       String expected = "PRess 0 to delete message";
       String actual = msg.sentMessage(2);
       assertEquals(expected,actual);        
   }
   @Test
   public void testSendMessageOption3(){
       Message msg = new Message(1,"0728532779","Hello");
       String expected = "Message succesfully stord";
       String actual = msg.sentMessage(3);
       assertEquals(expected,actual);        
   }
   @Test
   public void testReturnTotalMessages(){
       Message msg = new Message(2,"0728532779","Hello");
       int expected = 2;
       int actual = msg.returnTotalMessage();
       assertEquals(expected,actual);
   }
   @Test
   public void testprintMessage(){
       Message msg = new Message(1,"0728532779","Hello");
       String printed = msg.printMessage();
       assertTrue(printed.contains("Message ID")); 
       assertTrue(printed.contains("Message Hash")); 
       assertTrue(printed.contains("Recipient")); 
       assertTrue(printed.contains("Hello")); 
   }
}
