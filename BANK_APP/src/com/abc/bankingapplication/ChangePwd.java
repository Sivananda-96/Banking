package com.abc.bankingapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ChangePwd extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String accno=(String) session.getAttribute("accno");
		String name=(String) session.getAttribute("name");
		String npwd = request.getParameter("1");	
		Model model=new Model();
		
		model.setAccno(accno);
		model.setPwd(npwd);
		boolean res=model.changePwd();
		if(res==true)
		{
			session.setAttribute("name", name);
			response.sendRedirect("/BANK_APP/changePwdSuccess.jsp");
		}
		else
		{
			response.sendRedirect("/BANK_APP/changePwdfail.html");	
		}
	}

}
