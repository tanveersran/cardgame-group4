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
    public static final int minUsernameLength = 3;
    public static final int maxUsernameLength = 16;
    
    /**
     * This method validates the username that is inputted in the parameters
     * @param username
     * @return boolean true if username matches criteira, false if it does not
     */
    public boolean validate(String username) {
        boolean matchesCriteria = false;
        if (username.length() >= minUsernameLength && username.length() <= maxUsernameLength) {
            matchesCriteria = true;
        }
        return matchesCriteria;
    }
}
