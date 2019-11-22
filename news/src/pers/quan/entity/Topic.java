package pers.quan.entity;

import java.util.Date;

/**
 * @Description 新闻主题实体类
 * @author 何永泉
 * @date 2019年8月20日 下午4:51:15
 *
 */
public class Topic {

	private Integer id;
	// 主题名
	private String topicName;
	// 创建时间
	private Date createDate;
	// 是否被修改
	private boolean flag;

	public Topic() {
	}

	public Topic(Integer id, String topicName, Date createDate, boolean flag) {
		this.id = id;
		this.topicName = topicName;
		this.createDate = createDate;
		this.flag = flag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", topicName=" + topicName + ", createDate=" + createDate + ", flag=" + flag + "]";
	}

}
