package com.br.userbook.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession(false);

		boolean isLoggedIn = (session != null && session.getAttribute("user") != null);
		boolean isLoginRequest = httpRequest.getRequestURI().equals("/auth/login");
		boolean isRegisterRequest = httpRequest.getRequestURI().equals("/users/new");

		if (isLoggedIn && isLoginRequest) {
//			the user is already logged in and he's trying to login again
//			so this redirects to homepage
			httpResponse.sendRedirect("/?msgType=alert-danger&msg=You're already logged in.&urlDest=/");

		} else if (isLoggedIn || isLoginRequest || isRegisterRequest) {
//			is either logged, or trying to login or register, so continues the filter chain
			chain.doFilter(request, response);

		} else {
//			not logged in and not trying to login or register, so redirects to login page			
			httpResponse.sendRedirect(
					"/auth/login?msgType=alert-danger&msg=You must be logged in to access this page.&urlDest=/auth/login");
		}
	}

	public void destroy() {

	}

}
