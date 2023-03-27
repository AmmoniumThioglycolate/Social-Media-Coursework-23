package socialmedia;

import java.util.ArrayList;

public class Post{


  //Instance Attributes
  public int postId  = ++numberOfPosts;
  public String body;
  public String handle;
  public int numberOfEndorsements;
  public int numberOfComments;


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
  
  
 /*protected void buildObjectHierarchy(int id, StringBuilder sb, int level) {
    		if (id == 0) {
        	return;
                }
    		for (int i = 0; i < level; i++) {
        	sb.append("  ");
			}
    		sb.append(SocialMedia.showIndividualPost(id)).append("\n");

    		for (Post post : Post.postArrayList) {
				if (post.getOriginalPostId() == id){
        			buildObjectHierarchy(post.getOriginalPostId(), sb, level + 1);
    													}
				}
  }*/

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

  //Seter methods
  public void setPostId(int newPostId) {
    this.postId = newPostId;
  }
  public void setEndorsements(int endorsementNumber){
    numberOfEndorsements =  ++endorsementNumber; 
  }
  public void setNumberOfComments(int commentNumber){
    numberOfComments = ++commentNumber;
  }


  //Constructor
  public Post(){
    
  }
  public Post(String handle,String body){
    this.body = body;
    this.handle = handle;
  
  }

  public class Endorsement extends Post{
  public int originalPostID;
  public String endorsementMessage;

  public Endorsement(String handle,int id){
    super();
    this.handle = handle;
    this.originalPostID = id;

  }
  public int getOriginalPostId(){
    return this.originalPostID;
  }
  

}
public class Comment extends Post{
  public int originalPostID;
  public String commentMessage;


public Comment(String handle, int id, String message){
  super();
  handle = handle;
  commentMessage = message;
  originalPostID = id;
}
}


}





