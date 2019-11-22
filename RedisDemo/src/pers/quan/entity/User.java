package pers.quan.entity;

import java.io.Serializable;

/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年10月6日 下午7:11:56
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 2418173187060509318L;
	private int id;
	private String name;

	public User() {

	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
