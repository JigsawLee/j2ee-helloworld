package com.jigsaw.helloworld;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class demo {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";

	static final String user = "root";
	static final String pass = "123";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Let's go!");
		java.sql.Connection conn = null;
		java.sql.Statement stmt = null;

		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("正在连接数据库...");

			conn = DriverManager.getConnection(DB_URL, user, pass);
			// 执行查询
			System.out.println(" 实例化Statement对...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, name, url FROM websites";
			java.sql.ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");

				// 输出数据
				System.out.print("ID: " + id);
				System.out.print(", 站点名称: " + name);
				System.out.print(", 站点 URL: " + url);
				System.out.print("\n");
			}
			// 完成后关闭
			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {

		}

	}
}
