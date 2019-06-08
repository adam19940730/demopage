package com.linzhehang.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.linzhehang.bean.User;
import com.linzhehang.dao.IUserDao;
import com.linzhehang.util.JdbcUtils;

public class UserDaoImpl implements IUserDao {

	@Override
	public void save(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtils.getCon();
			String sql = "insert into t_user values(null,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setDate(2, new java.sql.Date(user.getBrithday().getTime()));
			ps.setDouble(3, user.getMoney());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(con, ps, null);
		}

	}

	@Override
	public void update(User user) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtils.getCon();
			String sql = "update t_user set name=?,brithday=?,money=? where id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setDate(2, new java.sql.Date(user.getBrithday().getTime()));
			ps.setDouble(3, user.getMoney());
			ps.setInt(4, user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtils.free(con, ps, null);
		}

	}

	@Override
	public void delete(Integer id) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = JdbcUtils.getCon();
			String sql = "delete from t_user where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(con, ps, null);
		}

	}

	@Override
	public User findOne(Integer id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getCon();
			String sql = "select * from t_user where id=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			User user = null;
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setBrithday(rs.getDate("brithday"));
				user.setMoney(rs.getDouble("money"));
			}
			return user;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(con, ps, rs);
		}
	}

	@Override
	public List<User> findAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getCon();
			String sql = "select * from t_user";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setBrithday(rs.getDate("brithday"));
				user.setMoney(rs.getDouble("money"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(con, ps, rs);
		}
	}

	@Override
	public int getCountRow() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getCon();
			String sql = "select count(*) from t_user";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int countRow = 0;
			if(rs.next()) {
				countRow = rs.getInt(1);
			}
			return countRow;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(con, ps, rs);
		}
	}

	@Override
	public List<User> findAllByPage(int startLine, int size) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = JdbcUtils.getCon();
			String sql = "select * from t_user limit ?,?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, startLine);
			ps.setInt(2, size);
			rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setBrithday(rs.getDate("brithday"));
				user.setMoney(rs.getDouble("money"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			JdbcUtils.free(con, ps, rs);
		}
	}


}
