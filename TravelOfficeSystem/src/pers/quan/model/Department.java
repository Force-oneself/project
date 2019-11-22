package pers.quan.model;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Discription 部门
 * @author John丶Woo
 * @date 2019年11月10日 下午4:06:12
 *
 */
public class Department {

	private Integer id;
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

	public Integer getParent() {
		return parent;
	}

	public void setParent(Integer parent) {
		this.parent = parent;
	}

	public Set<Integer> getChildren() {
		return children;
	}

	public void setChildren(Set<Integer> children) {
		this.children = children;
	}

}
