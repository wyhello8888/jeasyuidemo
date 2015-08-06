package com.wyhello.jeasyuidemo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.wyhello.commonsdb.db.RsMappingObject;
import com.wyhello.commonsdb.db.SQLTemplate;
import com.wyhello.commonsdb.db.SQLTemplateImpl;
import com.wyhello.jeasyuidemo.dao.UserDAO;
import com.wyhello.jeasyuidemo.pojo.User;

public class UserDAOImpl implements UserDAO {
	
	private SQLTemplate sqlT = null;
	
	
	
	public UserDAOImpl() {
		sqlT = new SQLTemplateImpl();
	}

	@SuppressWarnings("unchecked")
	public List<User> queryAll() {
		return (List<User>) sqlT.query("select * from users", null, new UserRsMappingObject());
	}


	public void add(User u) {
		sqlT.update("insert into users (firstname,lastname,phone,email) values (?,?,?,?)", 
				new Object[]{u.getFirstname(),u.getLastname(),u.getPhone(),u.getEmail()});
	}
	
	class UserRsMappingObject implements RsMappingObject{

		public Object mapper2Obj(ResultSet rs) {
			User user = null;
			try {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstname(rs.getString("firstname"));
				user.setLastname(rs.getString("lastname"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}
		
	}

}
