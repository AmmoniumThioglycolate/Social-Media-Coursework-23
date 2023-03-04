
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

    public static int generateRandomNumber() {
      //this bit for if this is the first run
      Random r = new Random( System.currentTimeMillis() );
      double randomNumber = ((1 + r.nextInt(9)) * 10000 + r.nextInt(10000));
      /* 
      for (int n= 1; randomNumber ==  ; i++){
        Random r = new Random( System.currentTimeMillis() );
        randomNumber = ((1 + r.nextInt(9)) * 10000 + r.nextInt(10000)); 
      } */
      return randomNumber;

  }
    //Getter Methods
    public int getAccountId() {
      return AccountId;
    }

    //Setter Methods
    public void setAccountId(int newAccountId) {
      this.AccountId = newAccountId;
    }
}
