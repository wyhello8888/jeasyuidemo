package com.wyhello.jeasyuidemo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wyhello.jeasyuidemo.dao.UserDAO;
import com.wyhello.jeasyuidemo.dao.impl.UserDAOImpl;
import com.wyhello.jeasyuidemo.pojo.User;
import com.wyhello.jeasyuidemo.service.UserService;
import com.wyhello.jeasyuidemo.service.impl.UserServiceImpl;
import com.wyhello.jeasyuidemo.util.JsonUtil;

/**
 * 提供服务的Servlet，数据的操作
 * @author Administrator
 *
 */
public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("m");
		UserService us = new UserServiceImpl();
		if ("lst".equals(method)){
			List<User> l = us.queryAllUser();
			String jsonStr = JsonUtil.toJson(l);
			PrintWriter out = resp.getWriter();
			out.println(jsonStr);
		} else if("add".equals(method)){
			
			String fname = req.getParameter("firstname");
			String lname = req.getParameter("lastname");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");
			User u = new User();
			u.setFirstname(fname);
			u.setLastname(lname);
			u.setPhone(phone);
			u.setEmail(email);
			us.addUser(u);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
	
}
