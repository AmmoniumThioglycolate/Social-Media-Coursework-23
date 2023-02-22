package socialmedia;

public class Account {

    // Instance Attributes
    public int AccountId;
    public String Handle;
    public String Description;

    // Static Attributes
    public ArrayList<Account> accountList = new ArrayList<>();

    public int gen() {
      //this bit for if this is the first run
      Random r = new Random( System.currentTimeMillis() );
      double randomNumber = ((1 + r.nextInt(9)) * 10000 + r.nextInt(10000));
      for (int n= 1; randomNumber == ; i++){
        Random r = new Random( System.currentTimeMillis() );
        randomNumber = ((1 + r.nextInt(9)) * 10000 + r.nextInt(10000)); 
      }
      return randomNumber;

  }


    //Getter Methods
    public int getAccountId(){
      return AccountId;
    }

    //Setter Methods
    public int setAccountId() {
      this.AccountId = AccountId;
    }



}
