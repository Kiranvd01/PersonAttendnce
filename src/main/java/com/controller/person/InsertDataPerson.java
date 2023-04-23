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
@WebServlet("/InsertDataPerson")
public class InsertDataPerson extends HttpServlet {
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
		String name=request.getParameter("name");
		long salary=Long.parseLong(request.getParameter("salary"));
		Person p=new Person(id,name,salary);
		int i=dao.InsertPerson(p);
		if(i==1) {
			out.print("<h3>Inserted SuccesFully</h3>");
		}
		else {
			out.print("<h3>Something Wrong Try Again</h3>");
		}
	}

}
