package pers.quan.entity;

/**
 * @Description 学生实体类
 * @author 何永泉
 * @date 2019年8月28日 上午11:08:26
 *
 */
public class Student {

	private String name;
	private Integer age;

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
