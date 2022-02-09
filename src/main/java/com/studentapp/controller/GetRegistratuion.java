package com.studentapp.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentapp.model.DAOImpl;

@WebServlet("/getReg")
public class GetRegistratuion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public GetRegistratuion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null){
		
		DAOImpl dao =new DAOImpl();
	   dao.connectdb();
	   ResultSet result = dao.getAllReg();
	   
	   
	    request.setAttribute("result", result);
	    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/searchResult.jsp");
	    rd.forward(request, response);
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request, response);
	}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
