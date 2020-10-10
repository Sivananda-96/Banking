package com.abc.bankingapplication;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Statement
 */
public class Statement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String accno=(String) session.getAttribute("accno");
		Model m=new Model();
		m.setAccno(accno);
		m.getStatement();
		ArrayList<Integer> arraylist = m.getArraylist();
		ArrayList<String> arraylist1 = m.getArraylist1();
		if(arraylist.isEmpty() && arraylist1.isEmpty())
		{
			response.sendRedirect("/BANK_APP/getStatementUns.jsp");
		}
		else
		{
			session.setAttribute("arraylist", arraylist);
			session.setAttribute("arraylist1", arraylist1);
			response.sendRedirect("/BANK_APP/getStatementSuccess.jsp");
		}

	}
}