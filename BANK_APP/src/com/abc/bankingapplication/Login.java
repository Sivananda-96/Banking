 package com.abc.bankingapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String custid = request.getParameter("custid");		
		String pwd = request.getParameter("pwd");
		Model model = new Model();
		model.setCustid(custid);
		model.setPwd(pwd);
		boolean result = model.login();
		if(result==true)

		{
			String accno = model.getAccno();
			String name=model.getName();
			int balance=model.getBalance();
			HttpSession session = request.getSession(true);
			session.setAttribute("accno", accno);
			session.setAttribute("name", name);
			session.setAttribute("balance", balance);

			response.sendRedirect("/BANK_APP/home.jsp");

		}

		else
		{
			response.sendRedirect("/BANK_APP/errorLogin.html");
		}
	}

}
