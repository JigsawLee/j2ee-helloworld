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
			System.out.println("�����������ݿ�...");

			conn = DriverManager.getConnection(DB_URL, user, pass);
			// ִ�в�ѯ
			System.out.println(" ʵ����Statement��...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, name, url FROM websites";
			java.sql.ResultSet rs = stmt.executeQuery(sql);

			// չ����������ݿ�
			while (rs.next()) {
				// ͨ���ֶμ���
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");

				// �������
				System.out.print("ID: " + id);
				System.out.print(", վ������: " + name);
				System.out.print(", վ�� URL: " + url);
				System.out.print("\n");
			}
			// ��ɺ�ر�
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
