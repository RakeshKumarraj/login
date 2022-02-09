package com.studentapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentapp.model.DAO;
import com.studentapp.model.DAOImpl;

@WebServlet("/Update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public UpdateController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("email");
	String mobile = request.getParameter("mobile");
	request.setAttribute("email", email);
	request.setAttribute("mobile", mobile);
	
	RequestDispatcher dr = request.getRequestDispatcher("WEB-INF/views/updateRegistration.jsp");
	dr.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAO dao =new DAOImpl();
		dao.connectdb();
        dao.updateReg(email, mobile);
        
		ResultSet result = dao.getAllReg();
		   
		    request.setAttribute("result", result);
		    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/searchResult.jsp");
		    rd.forward(request, response);
			
		}

}
