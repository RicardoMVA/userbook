package com.br.userbook.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.br.userbook.model.Phone;
import com.br.userbook.model.User;
import com.br.userbook.dao.UserDao;

@WebServlet("/users/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private UserDao userDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		try {
			switch (action) {
			case "/new":
				showCreateUser(request, response);
				break;
			case "/view":
				showOneUser(request, response);
				break;
			case "/edit":
				showEditUser(request, response);
				break;
			default:
				response.sendRedirect("/");
				break;
			}
		} catch (ServletException ex) {
			showException(request, response, ex);
		} catch (EJBException ex) {
			showException(request, response, ex);
		} catch (Exception ex) {
			showException(request, response, ex);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			User newUser = new User();

			manipulateUser(request, newUser);

			userDao.createUser(newUser);

			HttpSession session = request.getSession(false);

			if (session.getAttribute("user") != null) {
				response.sendRedirect("/?msgType=alert-success&msg=User created successfully!");
			} else {
				response.sendRedirect("/auth/login?msgType=alert-success&msg=User created successfully!");
			}

		} catch (EJBException ex) {
			showException(request, response, ex);
		} catch (Exception ex) {
			showException(request, response, ex);
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long id = Long.parseLong(request.getParameter("id"));
			User existingUser = userDao.getUser(id);

			manipulateUser(request, existingUser);

			userDao.updateUser(existingUser);

			response.setStatus(200);

		} catch (EJBException ex) {
			sendExceptionString(request, response, ex);
		} catch (Exception ex) {
			sendExceptionString(request, response, ex);
		}
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long id = Long.parseLong(request.getParameter("id"));

			User deletedUser = userDao.getUser(id);

			HttpSession session = request.getSession();
			User loggedUser = (User) session.getAttribute("user");

			if (deletedUser.getId() == loggedUser.getId()) {
				session.invalidate();
			}

			userDao.deleteUser(id);

			response.setStatus(200);
		} catch (EJBException ex) {
			sendExceptionString(request, response, ex);
		} catch (Exception ex) {
			sendExceptionString(request, response, ex);
		}
	}

	private void showCreateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher reqDis = request.getRequestDispatcher("/user/new.jsp");
		reqDis.forward(request, response);
	}

	private void showOneUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		User existingUser = userDao.getUser(id);

		RequestDispatcher reqDis = request.getRequestDispatcher("/user/view.jsp");
		request.setAttribute("user", existingUser);
		reqDis.forward(request, response);
	}

	private void showEditUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		long id = Long.parseLong(request.getParameter("id"));
		User existingUser = userDao.getUser(id);

		RequestDispatcher reqDis = request.getRequestDispatcher("/user/edit.jsp");
		request.setAttribute("user", existingUser);
		reqDis.forward(request, response);
	}

	private User manipulateUser(HttpServletRequest request, User user) throws Exception {
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");

		if (password.equals(passwordConfirm) != true) {
			throw new Exception("Passwords do not match");
		}

		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));

		String[] ddds = request.getParameterValues("ddd");
		String[] numbers = request.getParameterValues("number");
		String[] types = request.getParameterValues("type");

		List<Phone> updatedPhones = new ArrayList<>();
		List<Phone> oldPhones = user.getPhones();

		for (int i = 0; i < numbers.length; i++) {
			int ddd = 0;

			try {
				ddd = Integer.parseInt(ddds[i]);
			} catch (NumberFormatException e) {
				throw new Exception("Invalid DDD number.");
			}

			String number = numbers[i];
			String type = types[i];

//			this will run when a user has no phones (typically in creation)
			if (oldPhones == null) {
				Phone newPhone = new Phone(user, ddd, number, type);
				updatedPhones.add(newPhone);

			} else {
//				this will run when a user is being updated
				Phone numberIsSame = oldPhones.stream().filter(oldPhone -> number.equals(oldPhone.getNumber()))
						.findFirst().orElse(null);
				
				if (numberIsSame != null) {
					updatedPhones.add(numberIsSame);
				} else {
					Phone newPhone = new Phone(user, ddd, number, type);
					updatedPhones.add(newPhone);
				}
			}
		}

		user.setPhones(updatedPhones);

		return user;
	}

	protected void showException(HttpServletRequest request, HttpServletResponse response, Exception ex)
			throws ServletException, IOException {
		request.setAttribute("error", ex.getMessage());
		RequestDispatcher reqDis = request.getRequestDispatcher("/error.jsp");
		response.setStatus(400);
		reqDis.forward(request, response);
	}

	protected void sendExceptionString(HttpServletRequest request, HttpServletResponse response, Exception ex)
			throws ServletException, IOException {
		response.setStatus(400);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(ex.getMessage());
		out.close();
	}
}
