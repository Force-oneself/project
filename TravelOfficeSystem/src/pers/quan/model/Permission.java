package pers.quan.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Discription 权限
 * @author John丶Woo
 * @date 2019年11月10日 下午3:53:08
 *
 */
public class Permission {

	private Integer id;
	private Integer roleId;
	private String name;
	private Integer parent;
	private Set<Integer> children = new HashSet<>();

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

	public Set<Integer> getChildren() {
		return children;
	}

	public void setChildren(Set<Integer> children) {
		this.children = children;
	}

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
