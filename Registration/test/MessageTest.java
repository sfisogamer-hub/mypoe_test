/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import registration.Message;
/**
 *
 * @author sfiso
 */
public class MessageTest {
    @Test
    public void testMessagesArraysCorrectlyPopulated(){
        ArrayList<String>sentMessages = new ArrayList<>();
        sentMessages.add("Did you get the cake?");
        sentMessages.add("It is dinner time!");
        
        assertEquals("Did you get the cake?",sentMessages.get(0));
        assertEquals("It is dinner time!",sentMessages.get(1));
    }
    @Test
    public void testDisplayLongestMessage(){
        String msg1 = "Did you get the cake?";
        String msg2 = "Where are you?You are late!I have asked you to be on time.";
        String msg3 = "Yohoooo,I am at your gate";
        String msg4 = "It is dinner time!";
        
        String longest = msg1;
        if (msg2.length()>longest.length()){
            longest = msg2;
        }
        if (msg3.length()>longest.length()){
            longest = msg3;
        }
        if (msg4.length()>longest.length()){
            longest = msg4;
        }
        assertEquals("Where are you? You are late! I have asked you to be on time.",longest);
    }
    @Test
    public void testSearchMessageID(){
        Message msg = new Message(4,"0838884567","It is dinner time!");
        assertEquals("It is dinner time!",msg.getMessageText());
    }
    @Test
    public void testSearchMessageByRecipient(){
        ArrayList<String>messages = new ArrayList<>();
        messages.add("Where are you? You are late!I have asked you to be on time.");
        messages.add("Ok,I am leaving without you.");
        assertEquals(2,messages.size());
        assertTrue(messages.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(messages.contains("Ok,I am leaving without you"));    
    }
    @Test
    public void testDeleteMessageUsingHash(){
        ArrayList<Message>storedMessages = new ArrayList<>();
        Message msg = new Message(2,"+27838884567","Where are you? You are late! I have asked you to be on time.");
        storedMessages.add(msg);
        String hash = msg.getMessageHash();
        storedMessages.removeIf(m -> m.getMessageHash().equals(hash));
        assertEquals(0,storedMessages.size());
    }
    @Test
    public void testDisplayReport(){
        ArrayList<Message> sentMessages = new ArrayList<>();
        Message msg1 = new Message(1,"+27838884567","Did you get the cake ");
        Message msg2 = new Message(2,"+27838884567","Did you get the cake ");
        sentMessages.add(msg1);
        sentMessages.add(msg2);
        assertEquals(2,sentMessages.size());
        assertEquals("+27838884567",sentMessages.get(0).getMessageID());
        assertEquals("Did you get the cake ",sentMessages.get(0).getMessageText());
        assertNotNull(sentMessages.get(0).getMessageHash());
        assertNotNull(sentMessages.get(1).getMessageHash());
    }
}
