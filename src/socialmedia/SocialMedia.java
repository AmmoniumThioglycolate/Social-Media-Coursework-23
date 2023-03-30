package socialmedia;
import java.io.IOException;
import java.util.HashMap;
import java.io.*;




/**
 * 
 * 
 * 
 * 
 * 
 * @author Student Number - 720080382, Candidate Number - 232950
 * @author Student Number - 700022556, Candidate Number - 245071
 * @version 30/03/2023
 */
public class SocialMedia implements SocialMediaPlatform {

	// Account-related methods ****************************************

	/**
	 * The method creates an account in the platform with the given handle and
	 * description.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 *
	 * @param handle      account's handle.
	 * @param description account's description.
	 * @throws IllegalHandleException if the handle already exists in the platform.
	 * @throws InvalidHandleException if the new handle is empty, has more than 30
	 *                                characters, or has white spaces.
	 * @return the ID of the created account.
	 */

	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		

		if (Account.doesHandleExist(handle) == true) {
			throw new IllegalHandleException("An account with this handle alreayd exists" + handle);
		}

		if (Account.isHandleInvalid(handle) == true) {
			throw new InvalidHandleException("The handle inputted either has a whitespace, is more than 30 characters, or is empty");
	   }

		Account newAccount = new Account();

		newAccount.setHandle(handle);
		newAccount.setDescription(description);
		newAccount.setAccountId(Account.generateUniqueRandomNumber());

		(Account.accountArrayList).add(newAccount); //Adding the new account to our accountArrayList so we can find/use it later.

		return newAccount.getAccountId();

	}

		/**
	 * The method creates an account in the platform with the given handle.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 *
	 * @param handle account's handle.
	 * @throws IllegalHandleException if the handle already exists in the platform.
	 * @throws InvalidHandleException if the new handle is empty, has more than 30
	 *                                characters, or has white spaces.
	 * @return the ID of the created account.
	 *
	 */
	@Override
	public int createAccount(String handle) throws IllegalHandleException, InvalidHandleException {

		if (Account.doesHandleExist(handle) == true) {
			throw new IllegalHandleException("And account with this handle alreayd exists in the system");
		}

		if (Account.isHandleInvalid(handle) == true) {
			 throw new InvalidHandleException("The handle inputted is not valid for the system. It either contains whitespace, is more than 30 characters or is empty");
		}

		Account newAccount = new Account();
			
		newAccount.setHandle(handle);
		//This method doesn't parse a description, so we don't use our setter mehtod for an account's description.
		
		newAccount.setAccountId(Account.generateUniqueRandomNumber());

		(Account.accountArrayList).add(newAccount); //Adding the new Account to the system.

		return newAccount.getAccountId();

	}
		/**
	 * The method removes the account with the corresponding ID from the platform.
	 * When an account is removed, all of their posts and likes should also be
	 * removed.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 *
	 * @param id ID of the account.
	 * @throws AccountIDNotRecognisedException if the ID does not match to any
	 *                                         account in the system.
	 */
	@Override
	public void removeAccount(int id) throws AccountIDNotRecognisedException {
	

		//The following block checks if the id actually exists in the system. If it doesn't, we throw AccountIDNotRecognisedException.
		if (Account.isAccountIdRecognised(id) == true) {
			throw new AccountIDNotRecognisedException("The ID does not match any in the system");
		}

		for (int i = 0; i < (Account.accountArrayList).size(); i++) {
			if ((((Account.accountArrayList).get(i)).getAccountId()) == id) {
				(Account.accountArrayList).remove(i); //Remove the account with the specified Id.
			}
		}


	}


	/**
	 * The method removes the account with the corresponding handle from the
	 * platform. When an account is removed, all of their posts and likes should
	 * also be removed.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 *
	 * @param handle account's handle.
	 * @throws HandleNotRecognisedException if the handle does not match to any
	 *                                      account in the system.
	 */

	@Override
	public void removeAccount(String handle) throws HandleNotRecognisedException {

		if (Account.doesHandleExist(handle) == false) {
			throw new HandleNotRecognisedException("The handle inputted does not match any in the system");
		}


		for (int i = 0; i < (Account.accountArrayList).size(); i++) {
			if ((((Account.accountArrayList).get(i)).getHandle()).equals(handle)) {
				(Account.accountArrayList).remove((Account.accountArrayList).get(i));
			}
		}
	}

		/**
	 * The method replaces the oldHandle of an account by the newHandle.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 *
	 * @param oldHandle account's old handle.
	 * @param newHandle account's new handle.
	 * @throws HandleNotRecognisedException if the old handle does not match to any
	 *                                      account in the system.
	 * @throws IllegalHandleException       if the new handle already exists in the
	 *                                      platform.
	 * @throws InvalidHandleException       if the new handle is empty, has more
	 *                                      than 30 characters, or has white spaces.
	 */
	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
			throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {


				//The following block checks if the old handle actually exists in the system. If it doesn't, we throw HandleNotRecognisedException.
				if (Account.doesHandleExist(oldHandle) == false) {
					throw new HandleNotRecognisedException("The oldhandle doesnt match any in the system: " + oldHandle);
				}

				//The following block checks if the new handle already exists in the system. If it does, we throw IllegalHandleException.
				if (Account.doesHandleExist(newHandle) == true) {
					throw new IllegalHandleException("The newhandle alreayd exists in the platform: " + newHandle);
				}

				//The following block checks if the new handle is not empty and does not contain whitespace AND is no longer than 30 chars. If it fails this check, we throw InvalidHandleException.
				if (Account.isHandleInvalid(newHandle) == true) {
					throw new InvalidHandleException("This handle is invalid");
			    }


				for (int i = 0; i < (Account.accountArrayList).size(); i++) {
					if ((((Account.accountArrayList).get(i)).getHandle()).equals(oldHandle)) {
						((Account.accountArrayList).get(i)).setHandle(newHandle);
					}
				}

			}



	/**
	 * The method updates the description of the account with the respective handle.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 *
	 * @param handle      handle to identify the account.
	 * @param description new text for description.
	 * @throws HandleNotRecognisedException if the handle does not match to any
	 *                                      account in the system.
	 */
	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		
		if (Account.doesHandleExist(handle) == false) {
			throw new HandleNotRecognisedException("the handle inputted does not match any in the system");
		}
		
		
		for (int i = 0; i < (Account.accountArrayList).size(); i++) {
			if ((((Account.accountArrayList).get(i)).getHandle()).equals(handle)) {
				((Account.accountArrayList).get(i)).setHandle(handle);
				((Account.accountArrayList).get(i)).setDescription(description);
		}
	}
	}

	/**
	 * The method creates a formatted string summarising the stats of the account
	 * identified by the given handle. The template should be:
	 *
	 * <pre>
	 * ID: [account ID]
	 * Handle: [account handle]
	 * Description: [account description]
	 * Post count: [total number of posts, including endorsements and replies]
	 * Endorse count: [sum of endorsements received by each post of this account]
	 * </pre>
	 *
	 * @param handle handle to identify the account.
	 * @return the account formatted summary.
	 * @throws HandleNotRecognisedException if the handle does not match to any
	 *                                      account in the system.
	 */
	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {
		String output = "";
		if (Account.doesHandleExist(handle) == false) {
			throw new HandleNotRecognisedException("The handle inputted does not match any in the system");
		}

		for (int i = 0; i < (Account.accountArrayList).size(); i++) {
			if ((((Account.accountArrayList).get(i)).getHandle()).equals(handle)) {
				output = String.format("ID: %s \nHandle: %s \nDescription: %s \nPost count: %s \nEndorse Count: %s " ,((Account.accountArrayList).get(i)).getAccountId(),((Account.accountArrayList).get(i)).getHandle(),((Account.accountArrayList).get(i)).getDescription(),Post.getTotalPostCount(handle),Post.getAccountEndorsementTotal(handle));
			}	
		}
		return output;
	}


	// End Account-related methods ****************************************
	// Post-related methods ****************************************

	/**
	 * The method creates a post for the account identified by the given handle with
	 * the following message.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 *
	 * @param handle  handle to identify the account.
	 * @param message post message.
	 * @throws HandleNotRecognisedException if the handle does not match to any
	 *                                      account in the system.
	 * @throws InvalidPostException         if the message is empty or has more than
	 *                                      100 characters.
	 * @return the sequential ID of the created post.
	 */
	@Override
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {

		if (Account.doesHandleExist(handle) == false) {
			throw new HandleNotRecognisedException("The handle inputted does not match nay in the system");
		}else if (Post.isPostInvalid(message) == true) {
			throw new InvalidPostException("Either the message is empty or is more than a hundred characters");
		}


		Post newPost = new Post(handle, message);
		(Post.postArrayList).add(newPost);
		return newPost.getPostId();
		

		
		
				

		}

	

	/**
	 * The method creates an endorsement post of an existing post, similar to a
	 * retweet on Twitter. An endorsement post is a special post. It contains a
	 * reference to the endorsed post and its message is formatted as:
	 * <p>
	 * <code>"EP@" + [endorsed account handle] + ": " + [endorsed message]</code>
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 *
	 * @param handle of the account endorsing a post.
	 * @param id     of the post being endorsed.
	 * @return the sequential ID of the created post.
	 * @throws HandleNotRecognisedException if the handle does not match to any
	 *                                      account in the system.
	 * @throws PostIDNotRecognisedException if the ID does not match to any post in
	 *                                      the system.
	 * @throws NotActionablePostException   if the ID refers to a endorsement post.
	 *                                      Endorsement posts are not endorsable.
	 *                                      Endorsements are not transitive. For
	 *                                      instance, if post A is endorsed by post
	 *                                      B, and an account wants to endorse B, in
	 *                                      fact, the endorsement must refers to A.
	 */
	@Override
	public int endorsePost(String handle, int id) throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
				String formattedMessage;

				if (Account.doesHandleExist(handle) == false) {
					throw new HandleNotRecognisedException("the handle is not recognised");
				} else if (Post.doesPostIdExist(id) == false) {
					throw new PostIDNotRecognisedException("The post id does not exist");
				} else if (Post.isAnEndorsement(id)){
					throw new NotActionablePostException("The id entered refers to an endorsement");
				}

				Endorsement newPost = new Endorsement(handle, id);
				for (int i = 0; i < (Post.postArrayList).size(); i++) {
					if ((((Post.postArrayList).get(i)).getPostId()) == id){
						formattedMessage = String.format("EP@ %s : %s",(Post.postArrayList).get(i).getAccountHandle(), (Post.postArrayList).get(i).getBody());
						newPost.setEndorsementMessage(formattedMessage);
						(Post.postArrayList).add(newPost);
						((Post.postArrayList).get(i)).setEndorsements(((Post.postArrayList).get(i)).getEndorsementNumber());
						return newPost.getPostId();
					}





				}
				return 0; // assert that it is returning not zero
			}

				



		

	/**
	 * The method creates a comment post referring to an existing post, similarly to
	 * a reply on Twitter. A comment post is a special post. It contains a reference
	 * to the post being commented upon.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 *
	 * @param handle  of the account commenting a post.
	 * @param id      of the post being commented.
	 * @param message the comment post message.
	 * @return the sequential ID of the created post.
	 * @throws HandleNotRecognisedException if the handle does not match to any
	 *                                      account in the system.
	 * @throws PostIDNotRecognisedException if the ID does not match to any post in
	 *                                      the system.
	 * @throws NotActionablePostException   if the ID refers to a endorsement post.
	 *                                      Endorsement posts are not endorsable.
	 *                                      Endorsements cannot be commented. For
	 *                                      instance, if post A is endorsed by post
	 *                                      B, and an account wants to comment B, in
	 *                                      fact, the comment must refers to A.
	 * @throws InvalidPostException         if the comment message is empty or has
	 *                                      more than 100 characters.
	 */

	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {

				if (Account.doesHandleExist(handle) == false) {
					throw new HandleNotRecognisedException("the handle does not match any in the system");
				} else if (Post.doesPostIdExist(id) == false) {
					throw new PostIDNotRecognisedException("the id does not exist in the system");
				} else if (Post.isAnEndorsement(id) == true) {
					throw new NotActionablePostException("The id refers to an endorsement post");
				} else if (Post.isPostInvalid(message) == true) {
					throw new InvalidPostException("Either the comment is empty or it is more than 100 characters");
				}

				Post newComment = new Comment(handle,id,message);// no longer upcasting
				(Post.postArrayList).add(newComment);
				for (int i = 0; i < (Post.postArrayList).size(); i++) {
					if ((((Post.postArrayList).get(i)).getPostId()) == id){
						((Post.postArrayList).get(i)).setNumberOfComments(((Post.postArrayList).get(i)).getCommentNUmber());

				return newComment.getPostId();

				} 
			}
			return 0; // assert that it is returning not zero
		 }

	/**
	 * The method removes the post from the platform. When a post is removed, all
	 * its endorsements should be removed as well. All replies to this post should
	 * be updated by replacing the reference to this post by a generic empty post.
	 * <p>
	 * The generic empty post message should be "The original content was removed
	 * from the system and is no longer available.". This empty post is just a
	 * replacement placeholder for the post which a reply refers to. Empty posts
	 * should not be linked to any account and cannot be acted upon, i.e., it cannot
	 * be available for endorsements or replies.
	 * <p>
	 * The state of this SocialMediaPlatform must be be unchanged if any exceptions
	 * are thrown.
	 *
	 * @param id ID of post to be removed.
	 * @throws PostIDNotRecognisedException if the ID does not match to any post in
	 *                                      the system.
	 */
	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {


		if (Post.doesPostIdExist(id) == false) {
			throw new PostIDNotRecognisedException("the post with this id does not exist");
		}


		for (int i = 0; i < Post.postArrayList.size(); i++) {
			// delete endorsement posts. Since there are no comments, there's no need to point to a generic empty post
			if (((Post.postArrayList).get(i) instanceof Endorsement) && (((Post.postArrayList).get(i)).getPostId()) == id) {
				
				// remove one of the number of endorsements here
				for (int j = 0; j < Post.postArrayList.size(); j++) {
			// delete endorsement posts. Since there are no comments, there's no need to point to a generic empty post
				if ((((Post.postArrayList).get(i)).getOriginalPostId()) == (((Post.postArrayList).get(j)).getPostId())) {
				(Post.postArrayList.get(j)).numberOfEndorsements = (Post.postArrayList.get(j)).getEndorsementNumber() - 1 ; } // remove the log of the endorsement
			} 
			
		}
			else if (((Post.postArrayList).get(i) instanceof Comment) && ((((Post.postArrayList).get(i)).getPostId()) == id)) {
				// remove one of the number of endorsements here
				for (int j = 0; j < (Post.postArrayList).size(); j++) {
			// delete endorsement posts. Since there are no comments, there's no need to point to a generic empty post
				if ((((Post.postArrayList).get(i)).getOriginalPostId()) == (((Post.postArrayList).get(j)).getPostId())) {
				((Post.postArrayList).get(j)).numberOfComments = (Post.postArrayList.get(j)).getCommentNUmber() - 1 ; } // remove the log of the endorsement
				
			} 
			
		}

			// this deletes the original post, it will also work for an endorsement post
			if ((((Post.postArrayList).get(i)).getPostId()) == id) {
				((Post.postArrayList).get(i)).setBody("The original content was removed from the system and is no longer available."); // the post descriptionn is changed to a generic emoty post
				(Post.postArrayList.get(i)).setHandle(null); // the handle is nullified
				(Post.postGraveyard).add((Post.postArrayList).get(i)); // the post is then moved to a post graveyard so if ever needed we can use it to link its comments we can
				(Post.postArrayList).remove(i); // the  post is removed from the post array list
			}
		

		

	} }

	/**
	 * The method generates a formated string containing the details of a single
	 * post. The format is as follows:
	 *
	 * <pre>
	 * ID: [post ID]
	 * Account: [account handle]
	 * No. endorsements: [number of endorsements received by the post] | No. comments: [number of comments received by the post]
	 * [post message]
	 * </pre>
	 *
	 * @param id of the post to be shown.
	 * @return a formatted string containing post's details.
	 * @throws PostIDNotRecognisedException if the ID does not match to any post in
	 *                                      the system.
	 */
	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {

		if (Post.doesPostIdExist(id) == false) {
			throw new PostIDNotRecognisedException("The id does not match any post in the system");
		}
		String postOutput = "";
		for (int k = 0 ; k < (Post.postArrayList).size(); k++){
			if ((((Post.postArrayList).get(k)).getPostId()) == id) {
				postOutput = String.format("ID : %s \nAccount: %s \nNo. endorsements: %s | No. comments : %s\n%s ",((Post.postArrayList).get(k)).getPostId(),((Post.postArrayList).get(k)).getAccountHandle(),((Post.postArrayList).get(k)).getEndorsementNumber(),((Post.postArrayList).get(k)).getCommentNUmber(),((Post.postArrayList).get(k)).getBody());
				break;
			}

		}
		return postOutput;

	}
	

	/**
	 * The method builds a StringBuilder showing the details of the current post and
	 * all its children posts. The format is as follows (you can use tabs or spaces to represent indentation):
	 *
	 * <pre>
	 * {@link #showIndividualPost(int) showIndividualPost(id)}
	 * |
	 * [for reply: replies to the post sorted by ID]
	 * |  > {@link #showIndividualPost(int) showIndividualPost(reply)}
	 * </pre>
	 *
	 * See an example:
	 *
	 * <pre>
	 * ID: 1
	 * Account: user1
	 * No. endorsements: 2 | No. comments: 3
	 * I like examples.
	 * |
	 * | > ID: 3
	 *     Account: user2
	 *     No. endorsements: 0 | No. comments: 1
	 *     No more than me...
	 *     |
	 *     | > ID: 5
	 *         Account: user1
	 *         No. endorsements: 0 | No. comments: 1
	 *         I can prove!
	 *         |
	 *         | > ID: 6
	 *             Account: user2
	 *             No. endorsements: 0 | No. comments: 0
	 *             prove it
	 * | > ID: 4
	 *     Account: user3
	 *     No. endorsements: 4 | No. comments: 0
	 *     Can't you do better than this?
	 *
	 * | > ID: 7
	 *     Account: user5
	 *     No. endorsements: 0 | No. comments: 1
	 *     where is the example?
	 *     |
	 *     | > ID: 10
	 *         Account: user1
	 *         No. endorsements: 0 | No. comments: 0
	 *         This is the example!
	 * </pre>
	 *
	 * Continuing with the example, if the method is called for post ID=5
	 * ({@code showIndividualPost(5)}), the return would be:
	 *
	 * <pre>
	 * ID: 5
	 * Account: user1
	 * No. endorsements: 0 | No. comments: 1
	 * I can prove!
	 * |
	 * | > ID: 6
	 *     Account: user2
	 *     No. endorsements: 0 | No. comments: 0
	 *     prove it
	 * </pre>
	 *
	 * @param id of the post to be shown.
	 * @return a formatted StringBuilder containing the details of the post and its
	 *         children.
	 * @throws PostIDNotRecognisedException if the ID does not match to any post in
	 *                                      the system.
	 * @throws NotActionablePostException   if the ID refers to an endorsement post.
	 *                                      Endorsement posts do not have children
	 *                                      since they are not endorsable nor
	 *                                      commented.
	 */

	@Override
	public StringBuilder showPostChildrenDetails(int id) 
		throws PostIDNotRecognisedException, NotActionablePostException {


		if (Post.doesPostIdExist(id) == false) {
			throw new PostIDNotRecognisedException("the post with this id does not exist on this system");
		} else if (Post.isAnEndorsement(id) == true){
			throw new  NotActionablePostException("The post id inputted is for that of an endorsement");
		}
	    StringBuilder hierarchy = new StringBuilder();
    	buildObjectHierarchy(id, hierarchy, 0);
    	return hierarchy;



        /*
		StringBuilder outputOfPosts = new StringBuilder();
		for (int k = 0 ; k < postArrayList.size(); k++){
			if (((postArrayList.get(k)).getPostId()) == this.id) {
				commentsLeftToShow = (postArrayList.get(i)).getCommentNUmber;
				break;} */
		


	
		

		


/*
		for (int k = 0 ; k < postArrayList.size(); k++){
			if (((postArrayList.get(k)).getPostId()) == this.id) {
				commentNumber = (postArrayList.get(i)).getCommentNUmber;}
			while (commentNumber > 0){
				for (int k = 0 ; k < postArrayList.size(); k++){
					if (((postArrayList.get(k)).getOriginalPostId()) == this.id) {
						outputOfPosts.append((" ".repeat(indent)) + showIndividualPost(postArrayList.get(k).getPostId) );
						commentNumber -=;} else if (commentNumber == 0) {break;}
				}
			} */
					
					
					
					
					
		}




	/**
	 * The function takes in an id, a StringBuilder object and an integer level. It then creates a new
	 * SocialMedia object(in order to use the showIndividualPost since it is not static method) and checks if the id is 0. If it is, it returns. If it isn't, it loops through
	 * the level and appends two spaces to the StringBuilder object. It then appends the post with the id
	 * to the StringBuilder object and then loops through the postArrayList and checks if the
	 * originalPostId is equal to the id. If it is, it calls the function again with the originalPostId,
	 * the StringBuilder object and the level + 1
	 * 
	 * @param id The id of the post you want to start with.
	 * @param sb StringBuilder object
	 * @param level This is the level of the hierarchy. This helps determine the ammount of indentation
	 * @throws PostIDNotRecognisedException if the ID does not match to any post in
	 *                                      the system
	 */
	protected static void buildObjectHierarchy(int id, StringBuilder sb, int level) throws PostIDNotRecognisedException {
			SocialMedia newPost = new SocialMedia(); // this is created so that we can use the show individual post method as it is not staticr
      
    		if (id == 0){
        	return;
                }
			try{
			String[] postArr = (newPost.showIndividualPost(id)).split("\n");
			sb.append("\n");
			for (int j = 0; j < postArr.length;j++){
				sb.append("\n");
    		for (int i = 0; i < level; i++) {
        	sb.append("   ");
			} sb.append(postArr[j]);}} catch (PostIDNotRecognisedException e){}

// the post array list is looped thrrough here and if necessary calls itself again. We decided using a recursive method was the bets way around
    		for (Post post : Post.postArrayList) {
				if ((post instanceof Endorsement) == false){
					if (post.getOriginalPostId() == id){
        				buildObjectHierarchy(post.getPostId(), sb, level + 1);
    													} }
				}
  }



		



	

	// End Post-related methods ****************************************



	// Analytics-related methods ****************************************

	/**
	 * This method returns the current total number of accounts present in the
	 * platform. Note, this is NOT the total number of accounts ever created since
	 * the current total should discount deletions.
	 *
	 * @return the total number of accounts in the platform.
	 */
	@Override
	public int getNumberOfAccounts() {
		return Account.accountArrayList.size();
	}

	/**
	 * This method returns the current total number of original posts (i.e.,
	 * disregarding endorsements and comments) present in the platform. Note, this
	 * is NOT the total number of posts ever created since the current total should
	 * discount deletions.
	 *
	 * @return the total number of original posts in the platform.
	 */
	@Override
	public int getTotalOriginalPosts() {
		int originalPostcount = 0;
		for (int i = 0; i < (Post.postArrayList).size(); i++) {
			if ((Post.postArrayList).get(i) instanceof Comment) { //Comments aren't original posts, so we disregard them here
				continue;
			} else if ((Post.postArrayList).get(i) instanceof Endorsement) { //Endorsement's are also no original posts, so we disregard them here
				continue;
			} else {
				originalPostcount +=1;
			}
		}
		return originalPostcount;
	}

	/**
	 * This method returns the current total number of endorsement posts present in
	 * the platform. Note, this is NOT the total number of endorsements ever created
	 * since the current total should discount deletions.
	 *
	 * @return the total number of endorsement posts in the platform.
	 */
	@Override
	public int getTotalEndorsmentPosts() {
		int endorsementCount = 0;
		for (int i = 0; i < (Post.postArrayList).size(); i++) {
			if ((Post.postArrayList).get(i) instanceof Endorsement) {
				endorsementCount++ ;
			}
		}
		return endorsementCount;
 }	

	/**
	 * This method returns the current total number of comments posts present in the
	 * platform. Note, this is NOT the total number of comments ever created since
	 * the current total should discount deletions.
	 *
	 * @return the total number of comments posts in the platform.
	 */
	@Override
	public int getTotalCommentPosts() {
		int commentCount = 0;
		for (int i = 0; i < (Post.postArrayList).size(); i++) {
			if ((Post.postArrayList).get(i) instanceof Comment) {
				commentCount++ ;
			}
		}
		return commentCount;
	}

	/**
	 * This method identifies and returns the post with the most number of
	 * endorsements, a.k.a. the most popular post.
	 *
	 * @return the ID of the most popular post.
	 */
	@Override
	public int getMostEndorsedPost(){
		int index = 0;
		int max = (((Post.postArrayList).get(0)).getEndorsementNumber());
		for (int i = 0; i < (Post.postArrayList).size(); i++) {
			if ((Post.postArrayList).get(i) instanceof Endorsement) {
				continue;
			}
			else if (((Post.postArrayList).get(i)).getEndorsementNumber() > max ) {
				index = i;
				max = ((Post.postArrayList).get(i)).getEndorsementNumber();
			}
		}
		return ((Post.postArrayList).get(index)).getPostId();

	}

	/**
	 * This method identifies and returns the account with the most number of
	 * endorsements, a.k.a. the most popular account.
	 *
	 * @return the ID of the most popular account.
	 */
	@Override
	public int getMostEndorsedAccount() {
		// a hashmap (/dictionary)  is created
		HashMap<String, Integer> endorsementLeaderboard = new HashMap<String, Integer>();

// 
		for (int i = 0; i < (Account.accountArrayList).size(); i++){
			endorsementLeaderboard.put(((Account.accountArrayList).get(i)).getHandle(),0);
		}

		for (int k = 0; k < (Post.postArrayList).size(); k++) {
			if ((Post.postArrayList).get(k) instanceof Endorsement) {
				continue;
			} else {
				endorsementLeaderboard.put(((Post.postArrayList).get(k)).getAccountHandle(), (endorsementLeaderboard.get(((Post.postArrayList).get(k)).getAccountHandle()) + ((Post.postArrayList).get(k)).getEndorsementNumber() ));
			}
		}

		String mostPopular = "";
		int highest = 0;

		for (String j : endorsementLeaderboard.keySet()) {
			if ((endorsementLeaderboard.get(j)) > highest) {
				mostPopular = j;
				highest = endorsementLeaderboard.get(j);
			}
		}

		//Loop through the account array list to get the id 
		for (int i = 0; i < (Account.accountArrayList).size(); i++){
			if (((Account.accountArrayList).get(i)).getHandle() == mostPopular){
				return (Account.accountArrayList).get(i).getAccountId();
			}
		}
		return 0; // assert that it is returning not zero



	}

	// End Analytics-related methods ****************************************

	// Management-related methods ****************************************

	/**
	 * Method empties this SocialMediaPlatform of its contents and resets all
	 * internal counters.
	 */
	@Override
	public void erasePlatform(){
		(Account.accountArrayList).clear();
		(Post.postArrayList).clear();
		(Post.postGraveyard).clear();
		Post.setNumberOfPostsToZero();
		
	}

	/**
	 * Method saves this SocialMediaPlatform's contents into a serialised file, with
	 * the filename given in the argument.
	 *
	 * @param filename location of the file to be saved
	 * @throws IOException if there is a problem experienced when trying to save the
	 *                     store contents to the file
	 */
	@Override
	public void savePlatform(String filename) throws IOException{
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))){
			out.writeObject(Post.postArrayList);
			out.writeObject(Account.accountArrayList);
			System.out.println("The platform has been saved");
		} catch (IOException e){
			System.out.println("There's been a problem saving the file.");
		}
		
	}

	/**
	 * Method should load and replace this SocialMediaPlatform's contents with the
	 * serialised contents stored in the file given in the argument.
	 * <p>
	 * The state of this SocialMediaPlatform's must be be unchanged if any
	 * exceptions are thrown.
	 *
	 * @param filename location of the file to be loaded
	 * @throws IOException            if there is a problem experienced when trying
	 *                                to load the store contents from the file
	 * @throws ClassNotFoundException if required class files cannot be found when
	 *                                loading
	 */
	@Override
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException{
		
	}

	// End Management-related methods ****************************************

}
				

