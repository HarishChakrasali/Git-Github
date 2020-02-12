package com.mccoy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Signupservlet extends HttpServlet {
	
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException { 
		PrintWriter out = res.getWriter();
        String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String phoneNo=req.getParameter("phoneNo");
		out.println(phoneNo);
	HttpSession session = req.getSession(); 
		try {
			Signup signup = new Signup();
			signup.addUserDetails(firstName,lastName,phoneNo);
			System.out.println(firstName);
			RequestDispatcher rd=req.getRequestDispatcher("Success");  
            rd.forward(req, res);  
			 out.println(firstName);
        } catch (Exception e) {
 
            e.printStackTrace();
        }

	

}
}
