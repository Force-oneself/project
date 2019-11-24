package pers.quan.model;

/**
 *
 * @Discription 审核表
 * @author John丶Woo
 * @date 2019年11月23日 下午10:02:58
 *
 */
public class Review {

	// 审核编码
	private Integer id;
	// 审核状态
	private String status;
	// 审核说明
	private String remarks;
	// 审核人
	private Integer reviewerId;
	// 申请状态
	private String applyStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getReviewerId() {
		return reviewerId;
	}

	public void setReviewerId(Integer reviewerId) {
		this.reviewerId = reviewerId;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}
}
