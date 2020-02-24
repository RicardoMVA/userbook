package com.br.userbook.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.userbook.dao.UserDao;

@WebServlet("/auth/*")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UserDao userDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		try {
			switch (action) {
			case "/login":
				showLogin(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			default:
				response.sendRedirect("/");
				break;
			}
		} catch (ServletException ex) {
			showException(request, response, ex);
		}
//		catch (SQLException ex) {
//			showException(request, response, ex);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String userEmail = request.getParameter("userEmail");
		String password = request.getParameter("password");

		if (userEmail.equals("ric") && password.equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("user", "Ricardo");
			// setting session to expire in 30 mins
			session.setMaxInactiveInterval(30 * 60);
			
			response.sendRedirect("/");
		} else {
			response.sendRedirect("/auth/login");
		}
	}

	protected void showLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher reqDis = request.getRequestDispatcher("/login.jsp");
		reqDis.forward(request, response);
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		todo
	}

	protected void showException(HttpServletRequest request, HttpServletResponse response, Exception ex)
			throws ServletException, IOException {
		request.setAttribute("error", ex.getMessage());
		RequestDispatcher reqDis = request.getRequestDispatcher("/error.jsp");
		reqDis.forward(request, response);
	}

}
