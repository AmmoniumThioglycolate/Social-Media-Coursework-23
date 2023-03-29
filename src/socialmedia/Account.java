// A package declaration. It is used to group classes together.
package socialmedia;
import java.util.ArrayList;
import java.util.Random;
import java.io.Serializable;


/**
 * The Account class is a class that stores the account's ID, handle and description. It also has
 * static methods that generate a unique random number, check if the account ID is recognised, check if
 * the handle exists, check if the handle contains white space or is empty, check if the handle is
 * invalid, and getter and setter methods.
 */
public class Account implements Serializable {


    // Instance Attributes
    public int accountId;
    public String handle;
    public String description;


    //Static Attribute - An ArrayList to store the system's Accounts
    public static ArrayList<Account> accountArrayList = new ArrayList<Account>();
    public static ArrayList<Integer> randomNumberArray = new ArrayList<Integer>();


    //Static Methods

    /**
     * It generates a random number (no parameters are passed) and checks to see if it's already in the array of previously generated numbers, 
     * and if it is, it generates another random number.
     * While the finla line says it returns zero, it was likely never be used.
     * 
     * @return The return value is an integer.
     */
    public static int generateUniqueRandomNumber() {
          //this bit for if this is the first run
          Random r = new Random( System.currentTimeMillis() );
          int randomNumber = ((1 + r.nextInt(9)) * 10000 + r.nextInt(10000));
          if (randomNumberArray.contains(randomNumber) == false){
            randomNumberArray.add(randomNumber);
            return randomNumber;}
            else{return generateUniqueRandomNumber();}
            //make an assertion later on that the generate return number is not a zero
    }


    /**
     * This method returns a boolean, depending on whether the account id is in the system or not.
     * True if the account ID exists, and false otherwise.
     * 
     * @param Id The account ID to be checked
     * @return The method isAccountIdRecognised is returning a boolean value.
     */
    public static boolean isAccountIdRecognised(int Id) {
      for (int i = 0 ; i < accountArrayList.size(); i++) {
        if (((accountArrayList.get(i)).getAccountId()) == Id) {
          return true;
        }
      }
      return false;
    }

    /**
     * This function takes in a string and returns a boolean. It returns true if the string is equal to
     * the handle of any account in the accountArrayList. It returns false if the string is not equal
     * to the handle of any account in the accountArrayList
     * 
     * @param handle the handle of the account to be checked
     * @return The method is returning a boolean value.
     */
    public static boolean doesHandleExist(String handle) {
      for (int i = 0; i < accountArrayList.size(); i++){
        if (((accountArrayList.get(i)).getHandle()).equals(handle)){
          return true;
        }
      }
      return false;
    } 


    /**
     * It returns true if the string contains a space or is empty
     * 
     * @param handle The handle to check for white space or emptiness.
     * @return The method is returning a boolean value.
     */
    public static boolean doesItContainWhiteSpaceOrIsEmpty(String handle) {
      for (int i = 0; i < handle.length(); i++) {
        if ((handle.charAt(i)) == (' ')) {
          return true;
        }
      }
      if (handle.equals("")) {
        return true;
      }
      return false;
    }


    /**
     * If the handle contains white space, is empty, or if the handle is longer than 30 characters,
     * the method returns true. Otherwise, it returns false.
     * 
     * @param handle The handle to be checked
     * @return The method is returning a boolean value.
     */
    public static boolean isHandleInvalid(String handle) {
      if (doesItContainWhiteSpaceOrIsEmpty(handle) == true || handle.length() > 30) {
        return true;
      }
      return false;
    }


    //Getter Methods
    /**
     * This is a getter method that returns the accountId of the account
     * 
     * @return The accountId
     */
    public int getAccountId() {
      return accountId;
    }

    /**
     * This function returns the handle of the user
     * 
     * @return The handle of the user.
     */
    public String getHandle() {
      return handle;
    }

    /**
     * This function returns the description of the object
     * 
     * @return The description of the item.
     */
    public String getDescription() {
      return description;
    }



    //Setter Methods
    /**
     * This function sets the accountId to the newAccountId
     * 
     * @param newAccountId The new account ID to set.
     */
    public void setAccountId(int newAccountId) {
      this.accountId = newAccountId;
    }

    /**
     * This function sets the handle of the user to the new handle
     * 
     * @param newHandle The new handle to set.
     */
    public void setHandle(String newHandle) {
      this.handle = newHandle;
    }

    /**
     * This function sets the description of the object to the newDescription parameter
     * 
     * @param newDescription The new description of the item.
     */
    public void setDescription(String newDescription) {
      this.description = newDescription;
    }

}
