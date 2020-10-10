package com.abc.bankingapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session=request.getSession();
		String accno=(String) session.getAttribute("accno");
		Model model = new Model();
		model.setAccno(accno);
		boolean result = model.checkBalance();
		if(result==true) {
			//String name=model.getName();
			int balance = model.getBalance();
			//session.setAttribute("name", name);
			session.setAttribute("balance", balance);
			response.sendRedirect("/BANK_APP/CheckBalanceSuccess.jsp");
			
		}
		else
		{
			response.sendRedirect("/BANK_APP/checkBalanceError.html");
		}
	}

}
