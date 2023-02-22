package socialmedia;

public class Account {

    // Instance Attributes
    public int AccountId;
    public String Handle;
    public String Description;

    // Static Attributes
    public ArrayList<Account> accountList = new ArrayList<>();


    //Getter Methods
    public int getAccountId(){
      return AccountId;
    }

    //Setter Methods
    public int setAccountId() {
      this.AccountId = AccountId;
    }



}
