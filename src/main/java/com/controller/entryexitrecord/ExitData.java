package com.controller.entryexitrecord;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PersonEntryExitDao;
@WebServlet("/ExitData")
public class ExitData extends HttpServlet {
	PersonEntryExitDao dao;
	@Override
	public void init() throws ServletException {
		dao=new PersonEntryExitDao();
	}
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		int i=dao.insertExitData(id);
		if(i==1)
		{
			out.print("<h3>Succes</h3>");
		}
		else {
			out.print("<h3>Your Entry Record Not Found</h3>");
		}
	}

}
