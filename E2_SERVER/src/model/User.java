package model;
// Generated 15 ene 2025, 9:52:52 by Hibernate Tools 6.5.1.Final

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4993321448115647852L;
	private UserId id;

	public User() {
	}

	public User(UserId id) {
		this.id = id;
	}

	public UserId getId() {
		return this.id;
	}

	public void setId(UserId id) {
		this.id = id;
	}

}
