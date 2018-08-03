package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Profile;
import com.revature.dao.ProfileDao;

/**
 * Servlet implementation class GuestProfileServlet
 */
public class GuestProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname");
		String[] split = fullname.split("\\s+");
		HttpSession session = request.getSession();
		Profile profile = (Profile) session.getAttribute("profile");
		ProfileDao.updateFirstNameById(profile.getUserId(), split[0]);
		ProfileDao.updateLastNameById(profile.getUserId(), split[1]);
		
		profile = ProfileDao.getProfileByUserId(profile.getUserId());
		session.setAttribute("profile", profile);
		response.sendRedirect("GuestConnectedServlet");
		
		
	}

}
