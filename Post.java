package socialmedia;

import java.util.Dictionary;
import java.util.Hashtable;


public class Post{


  //Instance Attriubtes
  public int PostId;
  public String Body;

  //Static Attributes
  public Dictionary<Integer, Integer> PostDictionary = new Hashtable<Integer, Integer>(); //The bridge between PostId and AccountId


  //Getter methods
  public int getPostId(){
    return PostId;
  }

  //Seter methods
  public void setPostId(int newPostId) {
    this.PostId = newPostId;
  }


}
