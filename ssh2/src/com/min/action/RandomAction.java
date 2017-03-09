package com.min.action;

import java.io.ByteArrayInputStream;


import com.min.tools.RandomNumUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 该类主要用于生成验证码
 * 
 */
public class RandomAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private ByteArrayInputStream inputStream;
    
    // 生成验证码方法
    public String execute() throws Exception {
       try {
			 RandomNumUtil rdnu = RandomNumUtil.Instance();
        this.setInputStream(rdnu.getImage());/// 取得带有随机字符串的图片
        ActionContext.getContext().getSession().put("random", rdnu.getString());//
		} catch (Exception e) {
			// TODO: handle exception
		}
        return SUCCESS;
    }

    public void setInputStream(ByteArrayInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public ByteArrayInputStream getInputStream() {
        return inputStream;
    }    
    
}
