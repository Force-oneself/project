package pers.quan.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.quan.entity.Page;
import pers.quan.entity.Topic;
import pers.quan.service.TopicService;
import pers.quan.service.impl.TopicServiceImpl;

@SuppressWarnings("all")
public class TopicDelete extends HttpServlet {

	private TopicService topicService = new TopicServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		topicService.delete(Integer.valueOf(request.getParameter("id")));
		String targetPage = request.getParameter("page");
		System.out.println(targetPage);
		Page<Topic> page = new Page<Topic>();
		page.setPageSize(10);
		page.setCurrentPage(Integer.valueOf(targetPage));
		page.setList(topicService.getPage(page));
		
		request.setAttribute("page", targetPage);
		request.setAttribute("list", page.getList());
		request.getRequestDispatcher("/topic.jsp").forward(request, response);
	}

}
