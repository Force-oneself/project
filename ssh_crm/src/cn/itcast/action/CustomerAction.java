package cn.itcast.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Customer;
import cn.itcast.entity.Dict;
import cn.itcast.entity.PageBean;
import cn.itcast.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private Customer customer = new Customer();
	public Customer getModel() {
		return customer;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//根据级别统计
	public String countLevel() {
		List list = customerService.findCountLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countLevel";
	}
	
	//根据来源统计
	public String countSource() {
		List list = customerService.findCountSource();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countSource";
	}
	
	//多条件查询
	public String moreCondition() {
		List<Customer> list = customerService.findMoreCondition(customer);
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}
	
	//到查询客户信息页面
	public String toSelectCustomerPage() {
		
		return "toSelectCustomerPage";
	}
	
	//条件查询的方法
	public String listcondition() {
		//如果输入客户名称，根据客户名称查询
		//如果不输入任何内容，查询所有
		if(customer.getCustName()!=null && !"".equals(customer.getCustName())) {
			//不为空
			List<Customer> list = customerService.findCondition(customer);
			ServletActionContext.getRequest().setAttribute("list", list);
		} else {
			//不输入任何内容，查询所有
//			list();
			list = customerService.findAll();
		}
		return "listcondition";
	}
	
	//使用属性封装获取
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	//分页的方法
	public String listpage() {
		//调用service的方法实现封装
		PageBean pageBean = customerService.listpage(currentPage);
		//放到域对象里面
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		return "listpage";
	}
	
	//1 到添加页面
	public String toAddPage() {
		//查询所有级别
		List<Dict> listDict = customerService.findAllDictLevel();
		ServletActionContext.getRequest().setAttribute("listDict", listDict);
		return "toAddPage";
	}
	
	//2 添加的方法
	public String add() {
		//添加逻辑
		customerService.add(customer);
		return "add";
	}
	
	//定义list变量
	private List<Customer> list;
	//生成变量的get方法
	public List<Customer> getList() {
		return list;
	}
	
	//3 客户列表的方法
	public String list() {
//		List<Customer> list = customerService.findAll();
		//放到域对象
//		ServletActionContext.getRequest().setAttribute("list", list);
		
		//返回list放到值栈里面
		list = customerService.findAll();
		
		return "list";
	}

	//4 删除的方法
	public String delete() {
		//使用模型驱动获取表单提交cid值
		int cid = customer.getCid();
		
		//删除规范写法：首先根据id查询，调用方法删除
		//根据id查询
		Customer c = customerService.findOne(cid);
		//判断根据id查询对象是否为空
		if(c != null) {
			//调用方法删除
			customerService.delete(c);
		}
		return "delete";
	}

	
	//5 修改-根据id查询
	public String showCustomer() {
		//使用模型驱动得到cid值
		int cid = customer.getCid();
		//根据id查询
		Customer c = customerService.findOne(cid);
		//放到域对象里面
		ServletActionContext.getRequest().setAttribute("customer", c);
		return "showCustomer";
	}
	
	//6 修改的方法
	public String update() {
		customerService.update(customer);
		return "update";
	}
}




