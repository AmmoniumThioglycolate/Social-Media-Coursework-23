package socialmedia;

import java.util.ArrayList;
import java.io.*;

/**
 * This class is used to create a post object
 */
public class Post implements Serializable{


  //Instance Attributes
  public int postId  = ++numberOfPosts;
  public String body;
  public String handle; // the account handle a post is linked to
  public int numberOfEndorsements; //keeps track of the number of endorsements a post has
  public int numberOfComments; //keeps track of the number of comments a post has
  public int originalPostID;// gives the parent post id (if it has one)



  /**
   * This function takes a string and returns true if the string is empty or longer than 100 characters
   * 
   * @param message The message that the user is trying to post.
   * @return A boolean value.
   */
  public static boolean isPostInvalid(String message) {
    if (message == "") {
      return true;
    } else if (message.length() > 100) {
      return true;
    } else {return false;}
  }
  /**
   * It checks if the post has any children posts.
   * 
   * @param id the id of the post
   * @return A boolean value.
   */
  public static boolean doesItHaveChildrenPost(int id){
    for (int i = 0; i < postArrayList.size(); i++) {
      if (((postArrayList.get(i)).getOriginalPostId() == id) && (postArrayList.get(i).getAccountHandle() == null)) {
        return true;
      }
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
      if (((postArrayList.get(i)).getPostId() == id) || (postArrayList.get(i).getAccountHandle() == null)) {
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
  public static ArrayList<Post> postArrayList = new ArrayList<Post>();
  public static ArrayList<Post> postGraveyard = new ArrayList<Post>();
  public static int numberOfPosts = 0;


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

  /**
   * This function takes in a string parameter and returns an integer. The integer is the total number
   * of posts that the user has made
   * 
   * @param handle the account handle of the account you want to get the post count of
   * @return The total number of posts made by a user.
   */
  public static int getTotalPostCount(String handle){
    int count = 0;
    for (int k = 0; k < (Post.postArrayList).size(); k++) {
      if (Post.postArrayList.get(k).getAccountHandle() == handle){
        count++;
      } else{continue;}
    
  }
  return count;
}
  /**
   * This function takes in a string, and returns an integer. The integer is the total number of
   * endorsements for all posts made by the account with the handle that was passed in
   * 
   * @param handle the account handle of the account you want to get the endorsement total of
   * @return The total number of endorsements for a given account.
   */
  public static int getAccountEndorsementTotal(String handle){
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
   * // Java
   * public static void setNumberOfPostsToZero(){
   *     numberOfPosts = 0;
   *   }
   */
  public static void setNumberOfPostsToZero(){
    numberOfPosts = 0;
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


// Comment Constructor
public Comment(String handle, int id, String message){
  super();
  this.handle = handle;
  body = message;
  originalPostID = id;
}
}






