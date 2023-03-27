package socialmedia;

import java.util.ArrayList;
import java.util.Random;

public class Account {

    // Instance Attributes
    public String accountId;
    public String handle;
    public String description;


    //Static Attribute - An ArrayList to store the system's Accounts
    public static ArrayList<Account> accountArrayList = new ArrayList<Account>();
    public static ArrayList<Integer> randomNumberArray = new ArrayList<Integer>();


    //Static Methods
    public static int generateUniqueRandomNumber() {
          //this bit for if this is the first run
          Random r = new Random( System.currentTimeMillis() );
          int randomNumber = ((1 + r.nextInt(9)) * 10000 + r.nextInt(10000));
          randomNumberArray.add(randomNumber);
          if (randomNumberArray.contains(randomNumber) == false){
            return randomNumber;}
            else{ generateUniqueRandomNumber();}
          return 0;  //make an assertion later on that the generate return number is not a zero
    }


    public boolean isAccountIdRecognised(String Id) {
      for (int i = 0 ; i < accountArrayList.size(); i++) {
        if (((accountArrayList.get(i)).getAccountId()).equals(Id)) {
          return true;
        }
      }
      return false;
    }

    public boolean doesHandleExist(String handle) {
      for (int i = 0; i < accountArrayList.size(); i++){
        if (((accountArrayList.get(i)).getHandle()).equals(handle)){
          return true;
        }
      }
      return false;
    } 


    public boolean doesItContainWhiteSpaceOrIsEmpty(String handle) {
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


    public boolean isHandleInvalid(String handle) {
      if (doesItContainWhiteSpaceOrIsEmpty(handle) == true || handle.length() > 30) {
        return true;
      }
      return false;
    }


    //Getter Methods
    public String getAccountId() {
      return accountId;
    }

    public String getHandle() {
      return handle;
    }

    public String getDescription() {
      return description;
    }


    //Setter Methods
    public void setAccountId(String newAccountId) {
      this.accountId = newAccountId;
    }

    public void setHandle(String newHandle) {
      this.handle = newHandle;
    }

    public void setDescription(String newDescription) {
      this.description = newDescription;
    }

}
