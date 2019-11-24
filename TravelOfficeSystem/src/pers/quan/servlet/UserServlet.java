package pers.quan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pers.quan.model.User;
import pers.quan.service.UserService;
import pers.quan.service.impl.UserServiceImpl;

@SuppressWarnings("all")
public class UserServlet extends HttpServlet {

	private UserService userService = new UserServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		if ("".equals(username) || username == null) {
			request.setAttribute("error", "用户名不能为空！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if ("".equals(password) || password == null) {
			request.setAttribute("error", "密码不能为空！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		User user = userService.login(new User(username, password));
		if (user == null) {
			request.setAttribute("error", "用户名或者密码错误！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("user", user);
			response.sendRedirect("main.jsp");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		String confirmPassword = request.getParameter("confirmPassword");
		if (!newPassword.equals(newPassword)) {

		}
		if (user != null) {
			if (user.getPassword().equals(oldPassword)) {
				userService.update(new User(user.getName(), newPassword));
			}
		}
	}
}
