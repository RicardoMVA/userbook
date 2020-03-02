package com.br.userbook.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.br.userbook.model.User;
import com.br.userbook.dao.UserDao;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UserDao userDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			showAllUsers(request, response);

		} catch (ServletException ex) {
			showException(request, response, ex);
		} catch (EJBException ex) {
			showException(request, response, ex);
		} catch (Exception ex) {
			showException(request, response, ex);
		}
	}

	protected void showAllUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<User> listUser = userDao.getUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher reqDis = request.getRequestDispatcher("landing.jsp");
		reqDis.forward(request, response);
	}

	protected void showException(HttpServletRequest request, HttpServletResponse response, Exception ex)
			throws ServletException, IOException {
		request.setAttribute("error", ex.getMessage());
		RequestDispatcher reqDis = request.getRequestDispatcher("/error.jsp");
		response.setStatus(400);
		reqDis.forward(request, response);
	}
}
