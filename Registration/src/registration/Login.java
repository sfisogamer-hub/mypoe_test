/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registration;

/**
 *
 * @author sfiso
 */
public class Login {
    private String storedUserName;
    private String storedpassword;
    private String storednumber;      
    private String firstname;
    private String lastname;
            
    public boolean checkUserName(String userName) {
        if (userName.length() != 5){
            return false;
        }
        boolean hasUnderscore = false;
        
        for (int i = 0;i < userName.length();i++){
            char ch = userName.charAt(i);
            
            if (ch == '_'){
                hasUnderscore = true;
            }
            
            if (!Character.isLetterOrDigit(ch) && ch != '_'){
                return false;
            }
        }
        return hasUnderscore;
    } 
     public boolean checkPasswordComplexity(String password){
        boolean upper = false;
        boolean digits = false;
        boolean special = false;
        
        if (password.length() < 8){
            return false ;
        }
        for (int i = 0;i < password.length();i++){
            char ch = password.charAt(i);
            
            if (Character.isUpperCase(ch)){
                upper = true;
            }
            if (Character.isDigit(ch)){
                digits = true;
            }
            if (!Character.isLetterOrDigit(ch)){
                special = true;
            }
        }
        return upper && digits && special;
    }
    public boolean checkCellPhoneNumber(String number){
        return number.matches("\\d{9}"); 
            
                    
    }
    public String registerUser(String userName,String password,String number,String firstName,String lastName){
        if (!checkUserName(userName)){
            return "The username is incorrectly formatted";
       }
        if (!checkPasswordComplexity(password)){
        return"The password does not meet the complexity requirements";
       }
        if (!checkCellPhoneNumber(number)){
        return"The cell numbers not correct";
    }
        storedUserName = userName;
        storedpassword = password;
        storednumber = number;
        firstname = firstName;
        lastname = lastName;
        
            return "The two above conditions have been met, and the user has been registered successfully";
        }   
    
    public boolean loginUser(String userName,String password){
        return storedUserName != null && storedpassword != null && userName.equals(storedUserName) && password.equals(storedpassword);
    }        
    public String returnLoginStatus(boolean logSuccess){
        if (logSuccess)return "Welcome "+firstname+" , "+lastname+" it is great to see you again";
        else return "Username or password incorrect please try again"; 
    }
}
