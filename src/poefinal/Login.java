/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poefinal;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author PAUL
 */
public class Login {

     //Declartions
    private String username;
    private String password;
    private String name;
    private String surname;
    
    //Prompt user for their name and surname.
    public void promptUserDetails() {
        name = JOptionPane.showInputDialog(null, "Please enter your Name: ");
        surname = JOptionPane.showInputDialog(null, "Please enter your Surname: ");
        
    }

    //It's sets the condition to be met when creating a Username.
    public boolean checkUsername(String inputUsername) {
        if (inputUsername.length() <= 5 && inputUsername.contains("_")) {
            return true;
        } else {
            return false;
        }
    }

    //It's sets the condition to be met when creating a Password.
    public boolean checkPasswordComplexity(String inputPassword) {
        if (inputPassword.length() >= 8 && inputPassword.matches(".*[A-Z]+.*") && inputPassword.matches(".*[0-9]+.*")
                && inputPassword.matches(".*[!@#$%^&*()_+]+.*")) {
            return true;
        } else {
            return false;
        }
    }
    //This method respond to the above method and display a message when a condtion has been met or not.
    public void registerUser(String kyl_1, String chsecke99) {
        while (true) {
            username = JOptionPane.showInputDialog(null, "Please enter your username: ");
            if (checkUsername(username)) {
               JOptionPane.showMessageDialog(null, "Username was successfully captured.");
                break;
            } else {
                JOptionPane.showMessageDialog(null,
                     "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }

        while (true) {
            password = JOptionPane.showInputDialog(null, "Please enter your Password: ");
            if (checkPasswordComplexity(password)) {
                JOptionPane.showMessageDialog(null, "Password was successfully captured.");
                break;
            } else {
                JOptionPane.showMessageDialog(null,
           "Password is not correctly formatted, please ensure that the password contains at least 8  characters, a capital letter, a number and a special character.");
                continue;
            }
        }
    }
    //Sets the condtion that the login details added matches with those added in the above methods.
    public boolean loginUser(String inputUsername, String inputPassword) {
       if (username.equals(inputUsername) && password.equals(inputPassword)) {
            return true;
        } else {
            return false;
        }
    }
    //Prompt user to add their username and surname and responds to the above method with a statement if conditions are met or not.
   public String returnLoginStatus() {
    JPanel loginPanel = new JPanel(new GridLayout(0, 1));
    loginPanel.add(new JLabel("Username: "));
    JTextField usernameField = new JTextField();
    loginPanel.add(usernameField);
    loginPanel.add(new JLabel("Password: "));
    JPasswordField passwordField = new JPasswordField();
    loginPanel.add(passwordField);

    while (true) {
        int loginResult = JOptionPane.showConfirmDialog(null, loginPanel, "Login", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.OK_OPTION);
        if (loginResult == JOptionPane.OK_OPTION) {
            String inputUsername = usernameField.getText();
            String inputPassword = new String(passwordField.getPassword());
            if (loginUser(inputUsername, inputPassword)) {
                JOptionPane.showMessageDialog(null, "Login successful.");
                JOptionPane.showMessageDialog(null,
                        "Welcome " + name + " " + surname + ", it's great to see you again.");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Login failed. Please try again.");
            }
        } else if(loginResult==JOptionPane.CANCEL_OPTION){
            System.exit(0);
        }
    }
    return null;
  }
}

