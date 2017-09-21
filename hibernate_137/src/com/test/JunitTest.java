package com.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.entity.Dept;
import com.entity.Xueshihou;
import com.util.HibernateUtil;

public class JunitTest {
	private Session session;
	Transaction tran;
	@Before
	public void before(){
		session=HibernateUtil.getSession();
		tran=session.beginTransaction();
	}
	//get vs load
	//get 若数据不存在，返回null
	//load 若数据不存在，使用时抛出ObjectNotFoundException
	//get 立即加载
	//load 懒加载
	@Test
	public void test() {
		Dept dept=(Dept) session.load(Dept.class,11);
		System.out.println(dept.getDeptNo());
	}
	@Test
	public void add(){
		Dept dept=new Dept();
		dept.setDname("s137");
		dept.setLoc("beijing");
		try {
			session.save(dept);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tran.rollback();
		}
	}
	@Test
	public void update(){
		Dept dept=new Dept();
		dept.setDeptNo(459);
		dept.setDname("s13711");
		//dept.setLoc("beijing11");
		try {
			session.update(dept);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tran.rollback();
		}
	}
	//update,更改session缓存里对象的值，这种比较好用,更新时不影响其它字段的值
	@Test
	public void update2(){
		Dept dept=(Dept) session.get(Dept.class, 50);
		dept.setDname("abc");
	}
	@Test
	public void del(){
		Dept dept=new Dept();
		dept.setDeptNo(459);
		try {
			session.delete(dept);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tran.rollback();
		}
	}
	@Test
	public void addXue() {
		Xueshihou xh=new Xueshihou();
		xh.setName("s137");
		xh.setPwd("123");
		try {
			session.save(xh);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tran.rollback();
		}
	}
	@After
	public void after(){
		tran.commit();
	}
}
