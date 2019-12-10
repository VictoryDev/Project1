package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.RequestHelper;

public class MasterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestHelper.process(req, res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String targetURL = RequestHelper.process(req, res);
		System.out.println("-----------------------------------------------------");
		System.out.println("this is the targget URL" + targetURL);
		System.out.println("-----------------------------------------------------");
		req.getRequestDispatcher(targetURL).forward(req, res);
		// chose to respond with a forward for every POST request
	}

}