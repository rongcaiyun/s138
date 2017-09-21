package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entity.Subject;

/**
 * 数据访问层，对Subject表进行的增、删、改、查
 * 
 * @author Administrator
 *
 */
public class SubjectDao extends BaseDao{
	
	public List<Subject> getAll() {
		List<Subject> list = new ArrayList<Subject>();
		// TODO Auto-generated method stub
		try {
			getConn();
			// 3.生成SQL语句，获取statement，执行SQL语句
			String sql = "select * from subject";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			Subject subject;
			while (rs.next()) {
				int sno = rs.getInt("subjectno");
				String sname = rs.getString("subjectname");
				int classHour = rs.getInt("classHour");
				int gradeId = rs.getInt("gradeId");
				subject = new Subject(sno, sname, classHour, gradeId);
				/*
				 * System.out.println("科目编号：" + sno + ",科目名称：" + sname + ",课时："
				 * + classHour + ",年级编号：" + gradeId);
				 */
				list.add(subject);
			}
			// 4.如果是查询，则遍历ResultSet
			// 5.关闭
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return list;
	}
	public Subject getSubjectByNo(int sjno) {
		try {
			getConn();
			// 3.生成SQL语句，获取statement，执行SQL语句
			String sql = "select * from subject where subjectno=?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, sjno);
			rs = pstm.executeQuery();
			Subject subject;
			if (rs.next()) {
				int sno = rs.getInt("subjectno");
				String sname = rs.getString("subjectname");
				int classHour = rs.getInt("classHour");
				int gradeId = rs.getInt("gradeId");
				subject = new Subject(sno, sname, classHour, gradeId);
				return subject;
			}
			// 4.如果是查询，则遍历ResultSet
			// 5.关闭
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return null;
	}
	

	
	/**
	 * 增加
	 */
	public int add(Subject subject) {
		String str = "insert into subject(subjectname,classHour,gradeId) values(?,?,?)";
		return this.executeSql(str, subject.getSubjectName(),subject.getClassHour(),subject.getGradeId());
	}

	/**
	 * 删除
	 * 
	 * @param subject
	 * @return
	 */
	public int del(int subjectno) {
		String str = "DELETE FROM SUBJECT WHERE subjectno=?";
		return this.executeSql(str,subjectno);
	}

	/**
	 * 更新
	 * 
	 * @param subject
	 * @return
	 */
	public int update(Subject subject) {
		String sql="update subject set subjectname=?,gradeId=? where subjectno=?";
		Object[] objs={subject.getSubjectName(),subject.getGradeId(),subject.getSubjectNo()};
		return executeSql(sql,objs);
	}

	
}
