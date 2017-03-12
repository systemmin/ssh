package com.min.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.min.util.SaveFile;

/**
 * 负责保存客户端上传的文件
 * @author ming
 *@version -1.0
 */
public class FileServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public FileServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	/**
	 * 保存文件
	 * 文件名放入session
	 * 页面重定向反之页面重复提交
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = SaveFile.save(request, response);
		request.getSession().setAttribute("fileName","upload/"+name);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	public void init() throws ServletException {
	}

}
