package pers.quan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.quan.dao.TopicDao;
import pers.quan.dao.impl.TopicDaoImpl;
import pers.quan.entity.Page;
import pers.quan.entity.Topic;
import pers.quan.service.TopicService;
import pers.quan.service.impl.TopicServiceImpl;

/**
 * @Description 新闻主题的servlet
 * @author 何永泉
 * @date 2019年8月20日 下午4:30:42
 *
 */
@SuppressWarnings("all")
public class TopicServlet extends HttpServlet {

	private TopicService topicService = new TopicServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		// 设置page对象，页面大小10，设置总数据量，设置分页后得到的list集合
		Page<Topic> page = new Page<Topic>();
		// 设置分页大小
		page.setPageSize(10);
		// 获取数据总数
		page.setRows(topicService.getRows());
		// 获取页面page属性
		String currentPage = request.getParameter("page");
		// 没有page属性或者page小于1则赋值1
		if (currentPage == null || Integer.valueOf(currentPage) < 1) {
			currentPage = "1";
			// 检查page是否大于最大页面数
		} else if (Integer.valueOf(currentPage) > page.getPages()) {
			currentPage = "" + page.getPages();
		}			
		// 封装当前页
		page.setCurrentPage(Integer.valueOf(currentPage));	
		// 封装list集合数据
		page.setList(topicService.getPage(page));
		// 向页面设置request域属性
		request.setAttribute("page", page);
		request.getRequestDispatcher("/topic.jsp").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

}
