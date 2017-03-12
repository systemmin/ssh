package com.min.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.util.FaceFile;

/**
 * 负责处理人脸识别请求，并返回json
 * @author ming
 *@version -1.0
 */
public class FaceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public FaceServlet() {
		super();
	}

	public void destroy() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path =request.getParameter("path");
		response.setContentType("application/json");
		// 这里路径换成自己的真实路径D:/webjsp/apache-tomcat-6.0.48/webapps就是Tomcat/webapps的位置
		String str = FaceFile.save("D:/webjsp/apache-tomcat-6.0.48/webapps/Face/"+path);
		PrintWriter out = response.getWriter();
		out.write(str);
		out.flush();
		out.close();
	}
	public void init() throws ServletException {
	}

}
