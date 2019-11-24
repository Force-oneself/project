package pers.quan.model.template;

import java.util.Date;

import pers.quan.model.Application;

/**
 *
 * @Discription 出差申请表
 * @author John丶Woo
 * @date 2019年11月23日 下午10:30:55
 *
 */
public class TravelApplication extends Application {

	// 出差日期
	private Date traveDate;
	// 出差地
	private String address;

	public Date getTraveDate() {
		return traveDate;
	}

	public void setTraveDate(Date traveDate) {
		this.traveDate = traveDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
