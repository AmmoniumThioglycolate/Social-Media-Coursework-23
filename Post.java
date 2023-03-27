package socialmedia;

import java.util.ArrayList;

public class Post{


  //Instance Attributes
  public int postId  = ++numberOfPosts;
  public String body;
  public String handle;
  public int numberOfEndorsements;
  public int numberOfComments;
  public int originalPostID;



  public static boolean isPostInvalid(String message) {
    if (message == "") {
      return true;
    }
    if (message.length() > 100) {
      return true;
    }
    return false;
  }


  public static boolean doesPostIdExist(int id) {
    for (int i = 0; i < postArrayList.size(); i++) {
      if ((postArrayList.get(i)).getPostId() == id) {
        return true;
      }
    }
    return false;
  }


  public static boolean isAnEndorsement(int id) {
    for (int i = 0; i < postArrayList.size(); i++) {
      if (((postArrayList.get(i)).getPostId()) == id) {
        if (postArrayList.get(i) instanceof Endorsement) {
          return true;
        }
      }
    }
    return false;
  }
  
  


  //Static Attribute - An ArrayList to store the system's Posts
  private static int postsCreated = 0;
  public static ArrayList<Post> postArrayList = new ArrayList<Post>();
  public static ArrayList<Post> postGraveyard = new ArrayList<Post>();
  public static int numberOfPosts =0;


  //Getter methods
  public int getPostId(){
    return postId;
  }
  public String getAccountHandle(){
    return handle;
  }
  public String getBody(){
    return body;
  }
  public int getCommentNUmber(){
    return numberOfComments;
  }
  public int getEndorsementNumber(){
    return numberOfEndorsements;
  }
    public int getOriginalPostId(){
    return originalPostID;
  }

  //Seter methods
  public void setPostId(int newPostId) {
    this.postId = newPostId;
  }
  public void setHandle(String handle) {
    this.handle = handle;
  }
  public void setEndorsements(int endorsementNumber){
    numberOfEndorsements =  ++endorsementNumber; 
  }
  public void setNumberOfComments(int commentNumber){
    numberOfComments = ++commentNumber;
  }
    public void setBody(String body) {
    this.body = body;
  }


  //Constructor
  public Post(){
    
  }
  public Post(String handle,String body){
    this.body = body;
    this.handle = handle;
  
  }


  

}


  class Endorsement extends Post{

  public String endorsementMessage;

  public Endorsement(String handle,int id){
    super();
    this.handle = handle;
    this.originalPostID = id;

  }

  public void setEndorsementMessage(String message){
    endorsementMessage = message;
  }
  }
 class Comment extends Post{

  public String commentMessage;


public Comment(String handle, int id, String message){
  super();
  handle = handle;
  commentMessage = message;
  originalPostID = id;
}
}






