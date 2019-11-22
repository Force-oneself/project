package pers.quan.model;

/**
 *
 * @Discription 用户
 * @author John丶Woo
 * @date 2019年11月10日 下午3:48:45
 *
 */
public class User {

	private Integer id;
	private String name;
	private String phone;
	private String password;
	private String sex;
	private Integer departmengtId;

	public User(String username, String password2) {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getDepartmengtId() {
		return departmengtId;
	}

	public void setDepartmengtId(Integer departmengtId) {
		this.departmengtId = departmengtId;
	}
}
