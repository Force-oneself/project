package pers.quan.model;

/**
 * 
 * @Description 演示一个model
 * @author 何永泉
 * @date 2019年8月12日 下午4:23:52
 *
 */
public class Demo {

	private int id;
	private String name;
	private String password;

	public Demo() {}
	
	public Demo(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	
}
