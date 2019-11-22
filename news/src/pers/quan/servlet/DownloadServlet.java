package pers.quan.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

@SuppressWarnings("serial")
public class DownloadServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		// 获取需要下载的文件名
		String fileName = request.getParameter("filename");
		// 下载文件:需要设置消息头 
		// 设置二进制任意文件
		response.addHeader("content-Type", "application/octet-stream");
		
		// 对于不同浏览器,进行不同的处理
		// 获取客户端的user-agent信息
		String agent = request.getHeader("User-Agent");
		if (agent.toLowerCase().indexOf("firefox") != -1) {
			// Firefox下载文件名为中文时:
			response.addHeader("content-Disposition", "attachment;filename=?UTF-8?B?" + new String(Base64.encodeBase64(fileName.getBytes("UTF-8"))) +"?=");
		} else {
			// Edag 下载文件名为中文时:URLEncoder 设置编码防止中文乱码
			response.addHeader("content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") );
		}
		
		
		
		// Servlet通过文件的地址 将文件转为输入流 读到servlet中
		InputStream in = getServletContext().getResourceAsStream("/images/MIME.png");
		
		// 通过输出流将刚才已经转为输入流的文件 输出给用户
		ServletOutputStream out = response.getOutputStream();
		byte[] bs = new byte[10];
		int len = -1;
		while((len = in.read(bs)) != -1) {
			out.write(bs, 0, len);
		}
		out.close();
		in.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
