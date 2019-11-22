package pers.quan.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @Discription 
 * @author John丶Woo
 * @date 2019年9月18日 下午2:42:49
 *
 */
@SuppressWarnings("serial")
public class DemoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		request.setAttribute("showDate", "今天是" + ca.get(Calendar.YEAR) + "年的第" + ca.get(Calendar.WEEK_OF_YEAR) + "周");
		request.setAttribute("date", dateFormatter.format(date));
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
