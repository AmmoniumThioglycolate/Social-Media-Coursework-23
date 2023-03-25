public class Comment extends Post{
  public int originalPostID;
  public String commentMessage;
  public String accountHandle;

public Comment(String handle, int id, String message){
  accountHandle = this.handle;
  commentMessage = this.message;
  originalPostID = this.id;
  postId = ++numberOfPosts;
}
}