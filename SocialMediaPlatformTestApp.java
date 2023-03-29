import socialmedia.AccountIDNotRecognisedException;
import socialmedia.SocialMedia;
import socialmedia.IllegalHandleException;
import socialmedia.InvalidHandleException;
import socialmedia.SocialMediaPlatform;
import socialmedia.HandleNotRecognisedException;
import socialmedia.InvalidPostException;
import socialmedia.PostIDNotRecognisedException;
import socialmedia.NotActionablePostException;


/**
 * A short program to illustrate an app testing some minimal functionality of a
 * concrete implementation of the SocialMediaPlatform interface -- note you will
 * want to increase these checks, and run it on your SocialMedia class (not the
 * BadSocialMedia class).
 *
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class SocialMediaPlatformTestApp {

	/**
	 * Test method.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		System.out.println("The system compiled and started the execution...");

		SocialMediaPlatform platform = new SocialMedia();
		

		assert (platform.getNumberOfAccounts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalOriginalPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalCommentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalEndorsmentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";

		Integer id;
		try {
			id = platform.createAccount("my_handle");
			assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";

			platform.removeAccount(id);
			assert (platform.getNumberOfAccounts() == 0) : "number of accounts registered in the system does not match";

		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
		} catch (InvalidHandleException e) {
			assert (false) : "InvalidHandleException thrown incorrectly";
		} catch (AccountIDNotRecognisedException e) {
			assert (false) : "AccountIDNotRecognizedException thrown incorrectly";
		}

/*
		try {
			id = platform.createAccount(785589);
		} catch (InvalidHandleException e) {
			assert (true):  "InvalidHandleException is thrown";
		} */

				try {
			id = platform.createAccount("my_handlewwwwwwwwwwweereeweryuuytrewwyufddjhxctrstdhfjvkyfitvltitxxtytd");
			assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";

			platform.removeAccount(id);
			assert (platform.getNumberOfAccounts() == 0) : "number of accounts registered in the system does not match";

		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
		} catch (InvalidHandleException e) {
			assert (true) : "InvalidHandleException thrown correctly";
		} catch (AccountIDNotRecognisedException e) {
			assert (false) : "AccountIDNotRecognizedException thrown incorrectly";
		}
				try {
			id = platform.createAccount(" ");
			assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";

			platform.removeAccount(id);
			assert (platform.getNumberOfAccounts() == 0) : "number of accounts registered in the system does not match";

		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
		} catch (InvalidHandleException e) {
			assert (true) : "InvalidHandleException thrown correctly";
		} catch (AccountIDNotRecognisedException e) {
			assert (false) : "AccountIDNotRecognizedException thrown incorrectly";
		}
		/* 
		try{
		id = platform.createAccount("  ");} 
		catch (InvalidHandleException e){ System.out.println("The error has been caught: Invalid Handle");
		} catch (IllegalHandleException e){ System.out.println("The error has been caught: IllegalHandle");}
	*/
//Post Tests
// test to create post
//create an id;
		try {
			id = platform.createAccount("malik3");
			platform.changeAccountHandle("malik3", "makka pakka");
			System.out.println("hello" + platform.showAccount("makka pakka"));
			
			assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";
			System.out.println("This line of code worked : create post");

		} catch (IllegalHandleException e) {
			System.out.println(e.getMessage() + "Illegal handle exception");
		} catch (InvalidHandleException e) {
			System.out.println(e.getMessage() + "invalid handle exception");
		} catch (HandleNotRecognisedException e){
			System.out.println( "The handle has not been recognised so this is thrown correctly");
		}
		//create the post
		int postid = 0;
		try{
			postid = platform.createPost("malik","welcome to my island");
			System.out.println("This line of code worked : create post");
		} catch(HandleNotRecognisedException e){
			assert (true) : "Handle not recognised exception thrown correctly";
		} catch (InvalidPostException e) {
			System.out.println(e.getMessage());
		}
		//endorse post
		int endorsePostId;
		try{
			endorsePostId = platform.endorsePost("malik",postid);
			assert (1 == endorsePostId) : "the endorsement number doednt match";
			System.out.println("This line of code worked : endorsePostId");
		} catch(HandleNotRecognisedException e){
			assert (true) : "Handle not recognised exception thrown correctly";
		} catch (PostIDNotRecognisedException e) {
			System.out.println(e.getMessage());
		}catch (NotActionablePostException e) {
			System.out.println(e.getMessage());
		}





	}

}
