public class Endorsement extends Post{
  public int originalPostID;
  public String endorsementMessage;

  public Endorsement(String handle,int id){
    handle = this.handle;
    originalPostID = this.id;
    postId = ++numberOfPosts;
  }
  public int getOriginalPostId(){
    return this.originalPostID;
  }
  

}