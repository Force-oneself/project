package cn.itcast.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.entity.LinkMan;
import cn.itcast.service.CustomerService;
import cn.itcast.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

	private LinkMan linkMan = new LinkMan();
	public LinkMan getModel() {
		return linkMan;
	}
	
	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	//注入客户的service对象
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//多条件查询
	public String moreCondition() {
		//调用方法得到条件结果
		List<LinkMan> list = linkManService.findCondition(linkMan);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}
	
	//到联系人添加页面
	public String toSelectPage() {
		//查询所有客户，把传递到页面下拉列表中
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toSelectPage";
	}
	
	//5 修改联系人
	public String updateLinkMan() {
		linkManService.updateLink(linkMan);
		return "updateLinkMan";
	}
	
	//4 到修改联系人页面
	public String showLinkMan() {
		//使用模型驱动得到id值
		int linkid = linkMan.getLinkid();
		//根据id查询联系人对象
		LinkMan link = linkManService.findOne(linkid);
		
		//需要所有客户的list集合
		List<Customer> listCustomer = customerService.findAll();
		
		//放到域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("linkman", link);
		request.setAttribute("listCustomer", listCustomer);
		
		return "showLinkMan";
	}

	//3 联系人列表的方法
	public String list() {
		List<LinkMan> list = linkManService.listLinkMan();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	
	/*
	 * 需要上传文件（流）
	 * 需要上传文件名称
	 * （1）在action里面成员变量位置定义变量（命名规范）
	 * - 一个表示上传文件
	 * - 一个表示文件名称
	 * （2）生成变量的get和set方法
	 * 
	 * 还有一个变量，上传文件的mime类型
	 * */
	// 上传文件
	//变量的名称需要是表单里面文件上传项的name值
	private File upload;
	
	//上传文件名称   表单里面文件上传项的name值FileName
	private String uploadFileName;
	
	//生成get和set方法
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	//2 添加数据到数据库的方法
	public String addLinkMan() throws Exception {
		//判断是否需要上传文件
		if(upload != null) {
			//写上传代码
			//在服务器文件夹里面创建文件
			File serverFile = new File("I:\\sshimg"+"/"+uploadFileName);
			//把上传文件复制到服务器文件里面
			FileUtils.copyFile(upload, serverFile);
		}

		/*
		 * 可以封装联系人基本信息
		 * 但是有cid是客户id值不能直接封装的
		 * 把cid封装LinkMan实体类里面customer对象里面
		 * 
		 * */
		//原始方式实现
//		String scid = ServletActionContext.getRequest().getParameter("cid");
//		int cid = Integer.parseInt(scid);
		
		//创建customer对象
//		Customer c = new Customer();
//		c.setCid(cid);
//		
//		linkMan.setCustomer(c);
		
		linkManService.addLinkMan(linkMan);
		return "addLinkMan";
	}
	


	//1 到新增联系人页面的方法
	public String toAddPage() {
		//1.1 查询所有客户，把所有客户list集合传递到页面中显示（放到域对象）
		//调用客户service里面的方法得到所有客户
		List<Customer> listCustomer = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "toAddPage";
	}


}





