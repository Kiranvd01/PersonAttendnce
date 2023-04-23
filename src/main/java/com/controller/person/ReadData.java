package com.controller.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonDao;
import com.model.Person;
@WebServlet("/ReadData")
public class ReadData extends HttpServlet {
	PersonDao dao;
	@Override
	public void init() throws ServletException {
		dao=new PersonDao();
	}
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		Person p=dao.readData(id);
		if(p.getName()!=null) {
		out.print("<table border=1px><tr><td>Id</td><td>Name</td><td>Salary</td></tr>");
		out.print("<tr><td>"+p.getId()+"</td><td>"+p.getName()+"</td><td"+p.getName()+"</td><td>"+p.getSalary()+"</td></tr></table>");
		}
		else {
			out.print("<h3>Id Not Found</h3>");
		}
	}

}
