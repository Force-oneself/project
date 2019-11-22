package cn.itcast.entity;

public class Dict {

	private String did;
	private String dname;
	
	//之前在set集合表示所有客户，没有这个需求，可以不写
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
}
