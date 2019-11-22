package pers.quan.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@SuppressWarnings("all")
public class UploadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			// 判断前台form是否有mutipart属性
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {
				
//				FileItemFactory factory = new DiskFileItemFactory();
				
				DiskFileItemFactory factory = new DiskFileItemFactory();
				
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				// 设置上传文件时, 用到的临时文件的大小;单位:B DiskFileItemFactory
				factory.setSizeThreshold(10240); // 10KB
				
				// 设置临时文件的路径
				factory.setRepository(new File("F:\\Tomcat\\temp"));
				
				// 控制文件的大小 单位:B ServletFileUpload
				upload.setSizeMax(1024); // 1KB
				
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iterator = items.iterator();
				while (iterator.hasNext()) {
					FileItem fileItem = (FileItem) iterator.next();
					// 获取表单字段名
					String itemName = fileItem.getFieldName();

					int sno = -1;
					String sname = null;
					// 判断是否是表单字段
					if (fileItem.isFormField()) {
						// 学号
						if (itemName.equals("sno")) {
							sno = Integer.parseInt(fileItem.getString("UTF-8"));
							// 姓名
						} else if (itemName.equals("sname")) {
							sname = fileItem.getString("UTF-8");
						} else {
							System.out.println("其他字段");
						}
					} else {
						// 文件 上传
						// 获取文件名
						String fileName = fileItem.getName();

						String ext = fileName.substring(fileName.indexOf(".") + 1);
						if (!(ext.equals("png") || ext.equals("gif") || ext.equals("jpg"))) {
							System.out.println("文件只能图片格式");
							return;
						}
						
						// 获取文件内容并上传

						// 定义文件路径:指定上传的位置(服务器路径)
//						String path = request.getSession().getServletContext().getRealPath("upload");
						// 写绝对路径
						String path = "F:\\Tomcat\\upload";
						
						File file = new File(path, fileName);
						
						fileItem.write(file);
						System.out.println(fileName + "上传成功");
						return;
					}
				}
			}
		} catch (FileUploadBase.SizeLimitExceededException e) {
			System.out.println("文件大小超出限制");
			e.printStackTrace();
		} catch (FileUploadException e) {
			e.printStackTrace();
		}  catch (Exception e) {
			e.printStackTrace();
		} 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
