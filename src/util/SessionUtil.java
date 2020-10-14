package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 数据库连接
 */
public class SessionUtil {
	
	
	//唯一的工厂
	private static SqlSessionFactory  factory= null;
	private static SessionUtil su ; 
	
	
	//私有化构造方法
	private SessionUtil() {
		
		try {
			//1、读取配置文档 （主配置文档）
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			//2、创建会话工厂
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 单例模式设计
	 */
	public static SessionUtil getInstance() {
		
		if( su == null) {
			return  new SessionUtil();
		}
		return su;
	}

	
	/**
	 * 返回新的会话
	 */
	public static SqlSession getSession() {
		 getInstance();
		 return  factory.openSession();
	}
	
	
	
	
	
	

}
