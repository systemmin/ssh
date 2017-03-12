package com.min.util;

import java.io.File;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
@SuppressWarnings("all")
/**
 * 文件上传到服务器上
 * @author ming
 *@version -1.0
 */
public class SaveFile {


	/**
	 * 问件保存
	 * @param request 请求
	 * @param response 响应
	 * @return 返回文件名
	 */
	public static String  save(HttpServletRequest request, HttpServletResponse response) {
		String imgName=null;
		try {
			// 解析请求之前，要判断是否文件上传类型
			boolean isMult = ServletFileUpload.isMultipartContent(request);
			// 创建件文件夹
			String path = request.getRealPath("upload/");
			File file = new File(path);
			if (!file.exists()) {
				file.mkdir();
			}
			if (isMult) {
				// 创建文件上传核心类servletFileUpload；
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload fileUpload = new ServletFileUpload(factory);
				// 解析请求
				Iterator<FileItem> it = fileUpload.parseRequest(request).iterator();
				while (it.hasNext()) {
					FileItem fileItem = (FileItem) it.next();
					if (!fileItem.isFormField()) {
						 File severs = new File(path,fileItem.getName()); //文件名，和文件路径
						 fileItem.write(severs);// 上传操作
						 imgName=fileItem.getName();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return imgName;
	}
}
