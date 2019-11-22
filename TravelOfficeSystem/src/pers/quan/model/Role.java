package pers.quan.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Discription 角色
 * @author John丶Woo
 * @date 2019年11月10日 下午3:59:26
 *
 */
public class Role {

	private Integer id;
	private Integer userId;
	private String name;
	private String description;
	private Set<Integer> permissions = new HashSet<>();

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Integer> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Integer> permissions) {
		this.permissions = permissions;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
