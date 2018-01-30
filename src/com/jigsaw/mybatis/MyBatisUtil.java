package com.jigsaw.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @author Íæ¿á
 *
 */
public class MyBatisUtil {
	private static SqlSessionFactory sessionFactory;
	private static String resource = "mybatis-config.xml";

	public static SqlSessionFactory getSqlSsessionFactory() {
		if (null == sessionFactory) {
			synchronized (SqlSessionFactory.class) {
				if (null == sessionFactory) {
					try {
						InputStream inputStream = Resources.getResourceAsStream(resource);
						sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		}
		return sessionFactory;
	}
}
