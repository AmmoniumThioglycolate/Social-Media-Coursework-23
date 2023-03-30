import socialmedia.Account;
import socialmedia.AccountIDNotRecognisedException;
import socialmedia.SocialMedia;
import socialmedia.IllegalHandleException;
import socialmedia.InvalidHandleException;
import socialmedia.SocialMediaPlatform;
import socialmedia.HandleNotRecognisedException;
import socialmedia.InvalidPostException;
import socialmedia.PostIDNotRecognisedException;
import socialmedia.NotActionablePostException;
import socialmedia.Post;

import java.io.IOException;
import java.util.*;

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
			System.out.println(platform.showAccount("my_handle"));
			String handle = "my_handle";
			System.out.println(Account.accountArrayList);
			assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";

			platform.removeAccount(id);
			System.out.println(Account.accountArrayList + " this arrray of accounts has been printed");
			assert (platform.getNumberOfAccounts() == 0) : "number of accounts registered in the system does not match";

		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
		} catch (InvalidHandleException e) {
			assert (false) : "InvalidHandleException thrown incorrectly";
		}catch (AccountIDNotRecognisedException e){
			assert (false): "HandleNotRecognisedException thrown incorrectly";
		}catch (HandleNotRecognisedException e){
			assert (false): "HandleNotRecognisedException thrown incorrectly";
		}
		//creating an account with a description and then changing the description
		try {
			id = platform.createAccount("starbird","hello I'm shelly d'uval");
			String handle = "starbird";
			System.out.println(Account.accountArrayList);
			System.out.println(platform.showAccount("starbird"));
			platform.updateAccountDescription("starbird", "I've decided to change my name. I'm no longer");
			System.out.println(platform.showAccount("starbird"));
			assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";
			platform.removeAccount(handle);
			assert (platform.getNumberOfAccounts() == 0) : "number of accounts registered in the system does not match";

		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
		} catch (InvalidHandleException e) {
			assert (false) : "InvalidHandleException thrown incorrectly";
		}  catch(HandleNotRecognisedException e){
			System.out.println(e.getMessage());
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
/* 
		try {
			id = platform.createAccount("malik3");
			platform.changeAccountHandle("malik3", "malik3");
			System.out.println("hello" + platform.showAccount("makkapakka"));
			
			assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";
			System.out.println("This line of code worked : create post");

		} catch (IllegalHandleException e) {
			System.out.println(e.getMessage() );
		} catch (InvalidHandleException e) {
			System.out.println(e.getMessage() );
		} catch (HandleNotRecognisedException e){
			System.out.println( "The handle has not been recognised so this is thrown correctly");
		} */
		//create the post
		int postid = 0;
		// create a new id
		try {
			id = platform.createAccount("Lola");

		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
		} catch (InvalidHandleException e) {
			assert (true) : "InvalidHandleException thrown correctly";
		} 

		try{

			postid = platform.createPost("Lola","welcome to my island");
			System.out.println("This line of code worked : create post");
		} catch(HandleNotRecognisedException e){
			assert (true) : "Handle not recognised exception thrown correctly";
		} catch (InvalidPostException e) {
			System.out.println(e.getMessage());
		}
		//endorse post
		int endorsePostId;
		try{
			endorsePostId = platform.endorsePost("Lola",postid);
			assert (1 == endorsePostId) : "the endorsement number doednt match";
			System.out.println("This line of code worked : endorsePostId");
		} catch(HandleNotRecognisedException e){
			System.out.println(e.getMessage());
		} catch (PostIDNotRecognisedException e) {
			System.out.println(e.getMessage());
		}catch (NotActionablePostException e) {
			System.out.println(e.getMessage());
		}
	int commentID = 0;
	//test to create, show and delete comment
	try{
		commentID = platform.commentPost("Lola",postid,"this is the first comment");
		//System.out.println(commentID);
		//System.out.println(platform.showIndividualPost(postid));
		//System.out.println("This line of code worked : we've made a comment");
		//platform.deletePost(commentID);
		//System.out.println(platform.showIndividualPost(postid));
		//System.out.println(platform.showIndividualPost(commentID));
	} catch(HandleNotRecognisedException e){
		System.out.println(e.getMessage());
	} catch (PostIDNotRecognisedException e) {
		System.out.println(e.getMessage());
	}catch (NotActionablePostException e) {
		System.out.println(e.getMessage());
	} catch (InvalidPostException e){
		System.out.println(e.getMessage());
	}

	//show post children 
	try{
		int id2 = platform.createAccount("Lenny");
		int id3 = platform.createAccount("Lenor");
		int commentID2 = platform.commentPost("Lenny",postid,"welcome to my island again");
		int commentID4 = platform.commentPost("Lenny", 3, "more comments");
		int commentID5= platform.commentPost("Lola", 5, "stop spamming");
		int commentID7= platform.commentPost("Lenny", 5, "I'm not spamming");
		int commentID8= platform.commentPost("Lola", 1, "by Caroline Polachek");
		int postid3 = platform.createPost("Lenny", "No message yet");
		//System.out.println(platform.showAccount("Lenny"));
		int commentID3 = platform.commentPost("Lola", commentID2, "Be original");
		int endorsePostId3 = platform.endorsePost("Lola", postid3);
		int endorsePostId4 = platform.endorsePost("Lenor", postid3);
		System.out.println(platform.showPostChildrenDetails(postid));


	}catch(HandleNotRecognisedException e){
		System.out.println(e.getMessage());
	} catch (PostIDNotRecognisedException e) {
		System.out.println(e.getMessage());
	}catch (NotActionablePostException e) {
		System.out.println(e.getMessage());
	} catch (InvalidPostException e){
		System.out.println(e.getMessage());
	}catch (IllegalHandleException e) {
		System.out.println(e.getMessage());
	} catch (InvalidHandleException e) {
		System.out.println(e.getMessage());
	} 
	//test to get number of account
	try {
		System.out.println(Account.accountArrayList);
		int numberOfAccounts = platform.getNumberOfAccounts();
		System.out.printf("\nThere are %s accounts",numberOfAccounts);
		int totalOriginalPosts = platform.getTotalOriginalPosts();
		System.out.printf("\nThere are %s original posts",totalOriginalPosts);
		int numberOfEndorsements = platform.getTotalEndorsmentPosts();
		System.out.printf("\nThere are %s endorsements",numberOfEndorsements);
		int totalComments = platform.getTotalCommentPosts();
		System.out.printf("\nThere are %s comments in total",totalComments);
		int getMostEndorsedPost = platform.getMostEndorsedPost();
		System.out.printf("\nThe most endorsed post is %s ",getMostEndorsedPost);
		int getMostEndorsedAccount = platform.getMostEndorsedAccount();
		System.out.printf("\nThe most endorsed account is %s",getMostEndorsedAccount);


	} catch(Exception e){
		System.out.println("There's been a problem");

	}
	finally{System.out.println("\nThe test for number total stuff ran perfectly");}
	try{ platform.savePlatform("accountdata.ser");} 
	catch(IOException e){System.out.println("There's been an issue");}
			
				







// 

	}

}
