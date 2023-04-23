package com.controller.person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonDao;
@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
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
		int i=dao.deleteData(id);
		if(i==1)
		{
			out.print("<h3>Delete Successfully</h3>");
		}
		else {
			out.print("<h3>Id Not Found</h3>");
		}
	}

}
