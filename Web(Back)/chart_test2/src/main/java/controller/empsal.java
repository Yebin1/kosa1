package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import service.emp;

@WebServlet("/empsal")
public class empsal extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public empsal() {
        super();
    }
    
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Action action = new emp();
		ActionForward forward = action.execute(request, response);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
