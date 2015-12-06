package com.journaldev.spring.model;

public class User {
    
	private String userid;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String userRole;
	
	private String password;


	public User() {
		super();
	}

	public User(String userid, String firstName, String lastName, String email, String userRole, String password) {
		super();
		this.userid = userid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRole = userRole;
		this.password = password;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}


	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{\"user\":[{"+"\"userid\":" + "\""+null+"\"" + ","+"\"firstName\":"  + "\""+ firstName+"\"" + ","+"\"lastName\":"  + "\""+lastName+"\"" + ","+"\"email\":" + "\""+email+"\""
				+ ","+"\"userRole\":" + "\"admin\"" +  ","+"\"password\":" + "\""+password+"\"" + "}]}";
	}

}
