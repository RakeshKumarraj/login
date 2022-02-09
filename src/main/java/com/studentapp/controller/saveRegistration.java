package com.studentapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.studentapp.model.DAO;
import com.studentapp.model.DAOImpl;

@WebServlet("/saveReg")
public class saveRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public saveRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Registration.jsp");
		 rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		HttpSession session = request.getSession(false);
		session.setMaxInactiveInterval(10);
		if(session.getAttribute("email")!=null){
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		 DAO dao = new DAOImpl();
		 dao.connectdb();
		 dao.Registration(id,name,city,email,mobile);
		  
		 request.setAttribute("msg", "New registration is create");
		 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Registration.jsp");
		 rd.include(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	
	} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("msg", "session time out. please login again");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request, response);
	
	}
	}
}