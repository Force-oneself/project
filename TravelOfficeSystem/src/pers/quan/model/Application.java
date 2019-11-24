package pers.quan.model;

import java.util.Date;

/**
 *
 * @Discription 申请表
 * @author John丶Woo
 * @date 2019年11月23日 下午7:04:33
 *
 */

public class Application {

	// 申请表编号
	private Integer id;
	// 申请审核编号
	private Integer reviewId;
	// 申请人编号
	private Integer userId;
	// 申请类型
	private String applyType;
	// 申请时间
	private Date applyTime;
	// 申请说明
	private String remarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
