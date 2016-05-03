package com.netease;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class NoodlesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(NoodlesServlet.class);

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println("Log4JInitServlet 正在初始化 log4j日志设置信息");
		String log4jLocation = config.getInitParameter("log4j-properties-location");

		ServletContext sc = config.getServletContext();

		if (log4jLocation == null) {
			System.err.println("*** 没有 log4j-properties-location 初始化的文件, 所以使用 BasicConfigurator初始化");
			BasicConfigurator.configure();
		} else {
			String webAppPath = sc.getRealPath("/");
			String log4jProp = webAppPath + log4jLocation;
			File propfile = new File(log4jProp);
			if (propfile.exists()) {
				System.out.println("使用: " + log4jProp + "初始化日志设置信息");
				PropertyConfigurator.configure(log4jProp);
			} else {
				System.err.println("*** " + log4jProp + " 文件没有找到， 所以使用 BasicConfigurator初始化");
				BasicConfigurator.configure();
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
        
		String vegetable = request.getParameter("vegetable");
        
		if (vegetable == null) {
			vegetable = "Tomato";
		}

		// 记录debug级别的信息
		//logger.debug("This is debug message.");
		// 记录info级别的信息
		//logger.info("This is info message.");
		// 记录error级别的信息
		
		logger.info("这是用户提交的数据："+vegetable);
		
		//logger.error("This is error message.");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head></head><body>");
		writer.println("<h1> Noodles with " + vegetable + "</h1>");
		writer.println("</body></html>");
	}
}
