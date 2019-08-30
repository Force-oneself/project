package pers.quan.entity;

/**
 * 实体类user
 * 
 * @author Administrator
 *
 */

public class User {

	private int uid;
	private String name;
	private String password;
	private String address;

	public int getId() {
		return uid;
	}

	public void setId(int id) {
		this.uid = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
