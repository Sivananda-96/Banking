package com.abc.bankingapplication;

import java.io.IOException;
//import java.sql.Date;
import java.time.LocalDateTime;
//import java.util.Date;
//import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LocalDateTime now = LocalDateTime.now();
		String no=now.toString();
		HttpSession session = request.getSession();
		String accno=(String) session.getAttribute("accno");
		String racc=request.getParameter("1");
		String bal=request.getParameter("2");
		int thebal=Integer.parseInt(bal);
		Model model=new Model();
		model.setAccno(accno);
		model.setRaccno(racc);
		model.setBalance(thebal);
		model.setTime(no);
		boolean res=model.transfer();
		if(res==true)
		{
			session.setAttribute("racc", racc);
			session.setAttribute("bal", thebal);
			response.sendRedirect("/BANK_APP/TransferSuccess.jsp");
		}
		else
		{
			response.sendRedirect("/BANK_APP/transferfail.html");
		}
		
	}

}
