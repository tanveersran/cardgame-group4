/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 * This class is a validator class which can verify if the username entered
 * matches the set criteria.
 *
 * @author Tanveer Singh Sran
 * @author Nimrat Kaur Virk
 * @author Rajat Rajat
 * @author Nancy Nancy
 */
public class UsernameValidator {

    public static final int minUsernameLength = 3; // minimum length possible for the username
    public static final int maxUsernameLength = 16;// maximum length possible for the username

    /**
     * This method validates the username that is inputted in the parameters
     *
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
