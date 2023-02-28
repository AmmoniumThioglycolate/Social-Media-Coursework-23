package socialmedia;

import java.util.Dictionary;
import java.util.Hashtable;


public class Account {

    // Instance Attributes
    public int AccountId;
    public String Handle;
    public String Description;

    // Static Attributes
    public Dictionary<String, String> accountDictionary = new Hashtable<String, String>(); //This dictionary allows us to find an AccountID from a handle.


    //Getter Methods
    public int getAccountId() {
      return AccountId;
    }

    //Setter Methods
    public void setAccountId(int newAccountId) {
      this.AccountId = newAccountId;
    }

}
