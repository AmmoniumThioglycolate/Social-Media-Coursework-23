package socialmedia;

import java.util.ArrayList;

public class Post{


  //Instance Attributes
  public int postId;
  public String body;
  public String handle;
  public double numberOfEndorsements;
  public double numberOfComments;


  //Static Attribute - An ArrayList to store the system's Posts
  private static int postsCreated = 0;
  public static ArrayList<Post> postArrayList = new ArrayList<Post>();
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

  //Seter methods
  public void setPostId(int newPostId) {
    this.postId = newPostId;
  }


  //Constructor
  public Post(String handle,String body){
    body = this.body;
    handle = this.handle;
    postId = ++numberOfPosts;
  }


}

public class Endorsement extends Post{
  super();
  public int originalPostID;
  public String endorsementMessage;
  public Endorsedment(String handle,int id){
    handle = this.handle;
    originalPostID = this.id;
    postId = ++numberOfPosts;


  }
}
