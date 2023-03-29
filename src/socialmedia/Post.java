package socialmedia;

import java.util.ArrayList;
import java.io.*;

public class Post implements Serializable{


  //Instance Attributes
  public int postId  = ++numberOfPosts;
  public String body;
  public String handle;
  public int numberOfEndorsements;
  public int numberOfComments;
  public int originalPostID;



  /**
   * This function takes a string and returns true if the string is empty or longer than 100 characters
   * 
   * @param message The message that the user is trying to post.
   * @return A boolean value.
   */
  public static boolean isPostInvalid(String message) {
    if (message == "") {
      return true;
    }
    if (message.length() > 100) {
      return true;
    }
    return false;
  }


  /**
   * It loops through the array list of posts and checks if the post id of the post at the current
   * index is equal to the id passed in as a parameter. If it is, it returns true. If it isn't, it
   * returns false
   * 
   * @param id the id of the post
   * @return A boolean value
   */
  public static boolean doesPostIdExist(int id) {
    for (int i = 0; i < postArrayList.size(); i++) {
      if ((postArrayList.get(i)).getPostId() == id) {
        return true;
      }
    }
    return false;
  }


  /**
   * This function checks if a post is an endorsement by checking if the post is an instance of the
   * Endorsement class
   * 
   * @param id the id of the post
   * @return The method is returning a boolean value.
   */
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
  /**
   * This function returns the postId of the post
   * 
   * @return The postId
   */
  public int getPostId(){
    return postId;
  }
  /**
   * This function returns the account handle of the user
   * 
   * @return The handle of the account.
   */
  public String getAccountHandle(){
    return handle;
  }
  /**
   * // Java
   * public String getBody(){
   *     return body;
   *   }
   * 
   * @return The body of the email.
   */
  public String getBody(){
    return body;
  }
  /**
   * This function returns the number of comments on a post
   * 
   * @return The number of comments.
   */
  public int getCommentNUmber(){
    return numberOfComments;
  }
  /**
   * This method returns the number of endorsements a post has
   * 
   * @return The number of endorsements.
   */
  public int getEndorsementNumber(){
    return numberOfEndorsements;
  }
  /**
   * This function returns the original post ID of the post (Posts being Endorsements and Comments).
   * If Post id is zero, then it is an original post. 
   * 
   * @return The original post ID.
   */
  public int getOriginalPostId(){
    return originalPostID;
  }

  public int getTotalPostCount(){
    return (getCommentNUmber() + getEndorsementNumber());
  }
  public int getAccountEndorsementTotal(String handle){
    int count = 0;
    for (int k = 0; k < (Post.postArrayList).size(); k++) {
			if ((Post.postArrayList).get(k) instanceof Endorsement) {
				continue;
			} else if (Post.postArrayList.get(k).getAccountHandle() == handle){
        count += Post.postArrayList.get(k).getEndorsementNumber();
        }
		}
    return count;
  }

  //Seter methods
  /**
   * This function sets the postId to the newPostId passed.
   * 
   * @param newPostId The new post ID to set.
   */
  public void setPostId(int newPostId) {
    this.postId = newPostId;
  }
  /**
   * This function sets the handle of the user
   * 
   * @param handle The handle of the user to be followed.
   */
  public void setHandle(String handle) {
    this.handle = handle;
  }
  /**
   * The function takes in an integer, increments it by one, and then sets the value of the variable
   * numberOfEndorsements to the new value
   * 
   * @param endorsementNumber The number of endorsements the user has.
   */
  public void setEndorsements(int endorsementNumber){
    numberOfEndorsements =  ++endorsementNumber; 
  }
  /**
   * This function takes an integer as a parameter and sets the numberOfComments variable to the value
   * of the parameter plus one
   * 
   * @param commentNumber The number of comments that the post has.
   */
  public void setNumberOfComments(int commentNumber){
    numberOfComments = ++commentNumber;
  }
    
  /**
   * This function sets the body of the post
   * 
   * @param body The body of the message.
   */
  public void setBody(String body) {
    this.body = body;
  }


  //Constructor
  /** Default constructor for post object
   */
  public Post(){
    
  }
  // This constructor creates a post object
  public Post(String handle,String body){
    this.body = body;
    this.handle = handle;
  
  }


  

}


  /**
   * The Endorsement class is a subclass of the Post class. It has a constructor that takes in a handle
   * and an id. It also has a method called setEndorsementMessage that takes in a message and sets the
   * endorsementMessage variable to that message
   */
  class Endorsement extends Post{

  public String endorsementMessage;

// This constructor creates an endorsement object
  public Endorsement(String handle,int id){
    super();
    this.handle = handle;
    this.originalPostID = id;

  }

  /**
   * This function sets the endorsement message to the message passed in as a parameter
   * 
   * @param message The endorsement message to be displayed on the endorsement.
   */
  public void setEndorsementMessage(String message){
    endorsementMessage = message;
  }
  }
 /**
  * A subclass Comment is created, which extends the Post superclass.
  */
 class Comment extends Post{

  public String commentMessage;

// Comment Constructor
public Comment(String handle, int id, String message){
  super();
  this.handle = handle;
  commentMessage = message;
  originalPostID = id;
}
}






