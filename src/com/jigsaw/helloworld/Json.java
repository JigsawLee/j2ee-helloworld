package com.jigsaw.helloworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Json extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Json() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(getDataFromDB());
		out.flush();
		out.close();
	}

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/RUNOOB";

	static final String user = "root";
	static final String pass = "123";

	private String getDataFromDB() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("Let's go!");
		java.sql.Connection conn = null;
		java.sql.Statement stmt = null;
		StringBuffer sbArr = new StringBuffer();

		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("�����������ݿ�sdfsdfsd...");

			conn = DriverManager.getConnection(DB_URL, user, pass);
			// ִ�в�ѯ
			System.out.println(" ʵ����Statement��...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, name, url FROM websites";
			java.sql.ResultSet rs = stmt.executeQuery(sql);
			sbArr.delete(0, sbArr.length());
			sbArr.append("[");
			// չ����������ݿ�
			while (rs.next()) {
				StringBuffer sb = new StringBuffer();
				sb.append("{");
				// ͨ���ֶμ���
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String url = rs.getString("url");
				sb.append("\"id\":" + id);
				sb.append(",\"name\":" + "\"" + name + "\"");
				sb.append(",\"url\":" + "\"" + url + "\"");
				sb.append("},");
				sbArr.append(sb.toString());
				// �������
				System.out.print("ID: " + id);
				System.out.print(", վ������: " + name);
				System.out.print(", վ�� URL: " + url);
				System.out.print("\n");
			}
			sbArr.replace(sbArr.length() - 1, sbArr.length(), "");
			sbArr.append("]");
			// ��ɺ�ر�
			rs.close();
			stmt.close();
			conn.close();
			return sbArr.toString();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (Exception e) {
			return "";
		} finally {
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	private String getJson() {
		return "{\"json\":\"����JSON\"}";
	}
}
