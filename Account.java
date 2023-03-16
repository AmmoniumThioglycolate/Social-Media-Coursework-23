package socialmedia;

public class Account {

    // Instance Attributes
    public String accountId;
    public String handle;
    public String description;


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
