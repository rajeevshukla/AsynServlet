package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet(urlPatterns={"/DemoServlet"},name="DemoServlet",asyncSupported=true)
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
           PrintWriter writer=response.getWriter();
           writer.write("<html><body>");
           writer.write("<progress max='100'  id='progress'></progress>");
           writer.write("</body></html>"+Thread.currentThread().getName());
           AsyncContext asyncContext= request.startAsync();
           asyncContext.addListener(new AsyncProcessListener());
           asyncContext.start(new AsyncProcessor(asyncContext));  
           writer.write("<br>Original Thread completed.."+Thread.currentThread().getName()+"<br>");
	}

}
