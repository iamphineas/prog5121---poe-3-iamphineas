/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poefinal;

/**
 *
 * @author PAUL
 */
public class POEFINAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String passWord = "";
        String userName = "";
        
        //call the class to the main method.
         Login object = new Login();
         
         //calling the method promptUserDetails to ask for the name and surname of the user.
         object.promptUserDetails();
        
         //calling the method checkUsername that sets the condition for the uername a customer can inputs.
         object.checkUsername(userName);
        
         //calling the method checkPasswordComplexity that sets the condition for the password a customer can inputs.
         object.checkPasswordComplexity(passWord);
         
         //calling the method registerUser that respond to the username and password inputed if it meets the condition or not.
         object.registerUser("kyl_1", "Ch&&sec@ke99!");
         
         //calling the method loginUser that sets the condition so that the username and password added on the above method matches the one that is about to be added.
         object.loginUser(userName, passWord);
         
         //calling the method returnLoginStatus that validate if the username and password inputed matches the one that was added on the above methods and responds accordingly.
         object.returnLoginStatus();
         
         
         Part3.WelcomeMessage();
         Part3.showMenu();
         Part3.displayTotalHours();
         
     } 
   }
