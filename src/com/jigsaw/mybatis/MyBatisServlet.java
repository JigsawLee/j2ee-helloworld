package com.jigsaw.mybatis;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jigsaw.service.PersonService;

public class MyBatisServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		PersonService service = context.getBean(PersonService.class);
		if (null != service) {
			
		}
		System.out.println(service);
		System.out.println("doGet");
		response.setContentType("text/html;charset=UTF-8");
		String userName = request.getParameter("userName");
		PrintWriter out = response.getWriter();
		try {
			// Write some content
			out.println("<html>");
			out.println("<head>");
			out.println("<title>LifeServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h2>Servlet MyFirstServlet at " + request.getContextPath() + "</h2>");
			if (null != userName) {
				out.println("<h2>UserName : " + userName + "</h2>");
			}
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}
}
