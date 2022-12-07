package kr.or.kosa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.UserDao;
import kr.or.kosa.dto.User;
import kr.or.kosa.service.user.LoginCheckService;
import kr.or.kosa.service.user.SessionCheckService;
import kr.or.kosa.service.user.UserInsertService;


@WebServlet("*.admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminController() {
        super();
        
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    	
       	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlcommand = requestURI.substring(contextPath.length());
    	Action action=null;
    	ActionForward forward=null;
    	
    	

    	if(urlcommand.equals("/index.do")) {   //메인페이지(홈버튼)
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/index.jsp");
	    }else if(urlcommand.equals("/loginok.do")) { //loginok는 ajax로 뺴려고 생각중.
    	   action = new LoginCheckService();
  		   forward = action.execute(request, response);   
    	}
    	
    
    	if(forward != null) {
    		if(forward.isRedirect()) {
    			response.sendRedirect(forward.getPath());
    		}else {
    			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
