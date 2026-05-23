/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import registration.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sfiso
 */
public class logintest {
    
    Login log = new Login();
    
    @Test
    public void testuserNameCorrectFormatted(){
        assertTrue(log.checkUserName("kyl_1"));
    }
    @Test
    public void testUserNameIncorrectFormatted(){
        assertFalse(log.checkUserName("kyle!!!!!!!"));
    }
    @Test
    public void testPasswordMeetsComplexity(){
        assertTrue(log.checkPasswordComplexity("ch&&sec@ke99!"));    
    }
    @Test
    public void testPasswordNotMeetsComplexity(){
        assertFalse(log.checkPasswordComplexity("password"));
    }
    @Test
    public void testCellPhoneCorrectlyFormatted(){
        assertTrue(log.checkCellPhoneNumber("+27838968976"));
    }
    @Test
    public void testCellPhoneIncorrectlyFormatted(){
        assertFalse(log.checkCellPhoneNumber("0896653"));
    }
    @Test
    public void testLoginSuccessful(){
        log.registerUser("Kyl_1","Ch&&sec@ke99!","+27838968976","sfgs","jdhs");
        assertTrue(log.loginUser("kyl_1","ch&&sec@ke99!"));
    }
    @Test
    public void testLoginFail(){
        log.registerUser("Kyl_1","Ch&&sec@ke99!","+27838968976","shsj","bdjs");
        assertFalse(log.loginUser("kyle!!!!!!!","password"));
    }

    
    
}
//public logintest() {
    //}
