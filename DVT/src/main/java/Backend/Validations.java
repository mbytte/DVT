/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author Meganl
 */
public class Validations 
{
    //checks if something was entered into the name field
    public static boolean isNameFieldNull(String input)
    {
        if(input.compareTo("") == 0)
        {
            return true;
        }
        return false;
    }
    
    
    //checks if the password is valid
    public static boolean isPasswordValid(String password)
    {
        //variables
        boolean containsUpperCase = false;
        boolean containsLowerCase = false;
        boolean containsNumber = false;
        boolean isCorrectLength = false;
    }
    
    
    //checks if an option was selected
    public static boolean isNoOptionChosen(boolean yes, boolean no)
    {
        if(yes || no)
        {
            return false;
        }
        
        return true;
    }
}
