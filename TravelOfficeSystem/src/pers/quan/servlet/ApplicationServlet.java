package pers.quan.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.quan.model.Application;
import pers.quan.service.ApplicationService;
import pers.quan.service.impl.ApplicationServiceImpl;

/**
 *
 * @Discription 申请servlet
 * @author John丶Woo
 * @date 2019年11月23日 下午11:51:54
 *
 */
@SuppressWarnings("all")
public class ApplicationServlet extends HttpServlet {

	private ApplicationService applicationService = new ApplicationServiceImpl();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Date applyTime = new Date();
		String userId = request.getParameter("userId");
		String remarks = request.getParameter("remarks");
		String applyType = request.getParameter("applyType");

		Application application = new Application();
		application.setApplyTime(applyTime);
		application.setApplyType(applyType);
		application.setUserId(Integer.valueOf(userId));

		applicationService.insert(application);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
