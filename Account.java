package socialmedia;

public class Account {

    // Instance Attributes
    public String AccountId;
    public String Handle;
    public String Description;


    //Static Attribute - An ArrayList to store the system's Accounts
    public static ArrayList<Account> accountArrayList = new ArrayList<Account>();


    //Static Methods
    public static int generateUniqueRandomNumber() {
          //this bit for if this is the first run
          Random r = new Random( System.currentTimeMillis() );
          double randomNumber = ((1 + r.nextInt(9)) * 10000 + r.nextInt(10000));
          /*
          for (int n= 1; randomNumber ==  ; i++){
            Random r = new Random( System.currentTimeMillis() );
            randomNumber = ((1 + r.nextInt(9)) * 10000 + r.nextInt(10000));
          } */
          return Integer.toString(randomNumber);

      }


    public static boolean doesItContainWhiteSpaceOrIsEmpty(String handle) {
      for (int i = 0; i < handle.length(); i++) {
        if ((handle.charAt(i)).equals(" ")) {
          throw new InvalidHandleException("blah blah to be filled in later");
          return true;
        }
      }
      if (handle.equals("")) {
        throw new InvalidHandleException("blah blah to be filled in later");
        return true;
      }
      return false;
    }


    //Getter Methods
    public String getAccountId() {
      return AccountId;
    }

    public String getHandle() {
      return handle;
    }


    //Setter Methods
    public void setAccountId(String newAccountId) {
      this.AccountId = newAccountId;
    }

    public void setHandle(String newHandle) {
      this.Handle = newHandle;
    }

}
