/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author Tanveer
 */
public class UsernameValidator {
    
    /**
     * This method validates the username that is inputted in the parameters
     * @param username
     * @return boolean true if username matches criteira, false if it does not
     */
    public boolean validate(String username) {
        boolean matchesCriteria = false;
        if (username.length() >= 3) {
            matchesCriteria = true;
        }
        return matchesCriteria;
    }
}
