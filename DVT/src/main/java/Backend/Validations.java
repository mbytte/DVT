/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Meganl
 */
public class Validations 
{
    //variables
    private static int currentYear = 2023;
    
    
    //checks if something was entered into the name field
    public static boolean isUsernameEmpty(String input)
    {
        //the name field is empty
        if(input.compareTo("") == 0)
        {
            return true;
        }
        
        //name field is not empty
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
        
        //running through each character in the text and running a series of tests on them
        for(int i = 0; i < password.length() - 1; i++)
        {
            if(Character.isUpperCase(password.charAt(i)))
            {
                containsUpperCase = true;
            }
            
            if(Character.isLowerCase(password.charAt(i)))
            {
                containsLowerCase = true;
            }
            
            if(Character.isDigit(password.charAt(i)))
            {
                containsNumber = true;
            }
            
            if(password.length() > 7)
            {
                isCorrectLength = true;
            }
        }
        
        
        //checks if all the requirements are met
        if(containsUpperCase && containsLowerCase && containsNumber && isCorrectLength)
        {
            return true;
        }
        return false;
    }
    
    
    //checks if the date entered is the applicable
    public static boolean isDateReal(String dayStr, String month, String yearStr)
    {
        //convverting the strings into an integer
        int dayInt = Integer.parseInt(dayStr);
        int yearInt = Integer.parseInt(yearStr);
        
        //makes sure the day of the date applies to all months(except february)
        if(dayInt == 31)
        {
            if(month.compareTo("April")==0 || month.compareTo("June")==0 || month.compareTo("September")==0 || month.compareTo("November")==0)
            {
                return false;
            }
        }
        
        //running checks on February
        if(month.equals("February"))
        {
            //checks if the day is the extra day in a leap year 
            if(dayInt == 29 && yearInt%4 != 0)
            {
                return false;
            }
            
            if(dayInt == 30 || dayInt == 31)
            {
                return false;
            }
        }
        
        //date exists
        return true;
    }
    
    
    //checks if the age fits in with a range that exists
    public static boolean isAgeWithinRange(String age)
    {
        //makes sure that there is something in the field
        if(age.equals(""))
        {
            return false;
        }
        
        if(Character.isDigit(age.charAt(0))) //will know if the age is an integer from the first character
        {
            //converting the string into an integer
            int ageInt = Integer.parseInt(age);

            if(ageInt < 121 && ageInt > 17 )
            {
                return true;
            }
        }
        
        //either the age was typed as a word or it did not fit into the range
        return false;
    }
    
    
    //checks if the birthdate and age coincide
    public static boolean isBirthdayAndAgeRelated(String ageStr, String yearStr)
    {
        //makes sure that there is something inputted for age
        if(ageStr.equals(""))
        {
            return false;
        }
        
        //converting strings to integers
        int ageInt = Integer.parseInt(ageStr);
        int yearInt = Integer.parseInt(yearStr);
        
        //don't coincide
        if((currentYear - yearInt) != ageInt)
        {
            return false;
        }
        
        //do coincide
        return true;
    }
    
    
    //checks if an option was selected
    public static boolean isNoOrTwoOptionsChosen(boolean yes, boolean no)
    {
         if(yes && no)
        {
            return true;
        }
        
        if(yes || no)
        {
            return false;
        }

        return true;
    }
    
    
    //makes the date into a date object
    public static LocalDate deriveBirthdate(String day, String month, String year)
    {
        //checks to see if there is a date that is applicable
        if(isDateReal(day, month, year))
        {
            //creating a date time formatter to get the date into a specific format
            String birthday = day + " " + month + " " +  year;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");

            LocalDate newDate = LocalDate.parse(birthday, dtf);
            return newDate;
        }
        
        //date isn't real
        return null;
    }
}
